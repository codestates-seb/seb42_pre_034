package preProjectTeam34.auth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import preProjectTeam34.auth.dto.OAuthAttributes;
import preProjectTeam34.auth.jwt.JwtTokenizer;
import preProjectTeam34.auth.utils.CustomAuthorityUtils;
import preProjectTeam34.member.dto.MemberDtoImpl;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.member.mapper.MemberMapper;
import preProjectTeam34.member.repository.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils;
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("OAuth2 로그인 성공!");
        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
        String registrationId = oAuth2AuthenticationToken.getAuthorizedClientRegistrationId();
        OAuth2User oAuth2User = ((OAuth2AuthenticationToken) authentication).getPrincipal();
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, null, oAuth2User.getAttributes());
        Member.MemberStatus memberStatus = getMemberStatus(registrationId);

        Member member = saveOrUpdate(attributes, memberStatus);

        String accessToken = delegateAccessToken(member.getEmail(), member.getRoles());
        String refreshToken = delegateRefreshToken(member.getEmail());

        ResponseCookie cookie = ResponseCookie.from("refreshToken", refreshToken)
                        .maxAge(7*24*60*60)
                        .path("/")
                        .secure(true)
                        .sameSite("None")
                        .httpOnly(true)
                        .build();

        // Header 설정
        response.setHeader("accessToken", "Bearer " + accessToken);
        response.addHeader("Set-Cookie", cookie.toString());

        // Body 생성
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String body = objectMapper.writeValueAsString(memberMapper.memberToMemberResponse(member));
        response.getWriter().write(body);

//        response.sendRedirect("http://localhost:3000");

    }

    private Member saveOrUpdate(OAuthAttributes attributes, Member.MemberStatus memberStatus){
        Optional<Member> member = memberRepository.findByEmail(attributes.getEmail());
        if(member.isPresent()){ // Member 테이블에 이미 이메일이 있다면
            return member.get();
        }else{ // Member 테이블에 이메일이 없다면
            Member newMember = Member.builder()
                    .email(attributes.getEmail())
                    .password(makeTempPassword())
                    .nickName(attributes.getName())
                    .memberStatus(memberStatus)
                    .roles(List.of(Member.Role.GUEST.getTitle(), Member.Role.USER.getTitle()))
                    .picture(attributes.getPicture())
                    .build();
            return memberRepository.save(newMember);
        }
    }

    private String makeTempPassword(){
        RandomString randomString = new RandomString(35);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(randomString.toString());
    }

    private Member.MemberStatus getMemberStatus(String registrationId){
        if("google".equals(registrationId)){
            return Member.MemberStatus.GOOGLE_LOGIN;
        }else if("naver".equals((registrationId))){
            return Member.MemberStatus.NAVER_LOGIN;
        }else if("kakao".equals(registrationId)){
            return Member.MemberStatus.KAKAO_LOGIN;
        }else{
            // null인 상황은 예외를 던져주어야한다.
            return null;
        }
    }

    private String delegateAccessToken(String username, List<String> authorities) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("roles", authorities);

        String subject = username;
        Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getAccessTokenExpirationMinutes());

        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        return accessToken;
    }

    private String delegateRefreshToken(String username) {
        String subject = username;
        Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getRefreshTokenExpirationMinutes());
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        String refreshToken = jwtTokenizer.generateRefreshToken(subject, expiration, base64EncodedSecretKey);

        return refreshToken;
    }
}
