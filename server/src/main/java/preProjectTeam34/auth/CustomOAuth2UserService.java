package preProjectTeam34.auth;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import preProjectTeam34.auth.dto.OAuthAttributes;
import preProjectTeam34.auth.dto.SessionUser;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.member.repository.MemberRepository;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final MemberRepository memberRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Member member = saveOrUpdate(attributes);

        httpSession.setAttribute("user", new SessionUser(member));

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(Member.Role.USER.getKey())), attributes.getAttributes(), attributes.getNameAttributeKey());
    }

    private Member saveOrUpdate(OAuthAttributes attributes){
        Optional<Member> member = memberRepository.findByEmail(attributes.getEmail());
        if(member.isPresent()){ // Member 테이블에 이미 이메일이 있다면
            return member.get();
        }else{ // Member 테이블에 이메일이 없다면
            Member newMember = Member.builder()
                    .email(attributes.getEmail())
                    .password(makeTempPassword())
                    .nickName(attributes.getName())
                    .memberStatus(Member.MemberStatus.GOOGLE_LOGIN)
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
}
