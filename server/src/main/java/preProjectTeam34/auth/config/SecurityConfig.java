package preProjectTeam34.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import preProjectTeam34.auth.CustomOAuth2UserService;
import preProjectTeam34.auth.provider.CustomOAuth2Provider;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    // 네이버와 카카오는 스프링에서 지원해주지 않기 때문에 ClientRegistrationRepository에 등록해줘야 함
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(
            OAuth2ClientProperties oAuth2ClientProperties,
            @Value("${spring.security.oauth2.client.registration.naver.client-id}") String naverClientId,
            @Value("${spring.security.oauth2.client.registration.naver.client-secret}") String naverClientSecret
    ){
        List<ClientRegistration> registrations = oAuth2ClientProperties
                .getRegistration().keySet().stream()
                .map(client -> getRegistration(oAuth2ClientProperties, client))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // jwkSetUri는 JWT 토큰이 기본으로 제공되었을 때 처리하기 위한 전략인데
        // 해당 부분을 나중에 다시 처리해주어야한다.
        registrations.add(CustomOAuth2Provider.NAVER.getBuilder("naver")
                .clientId(naverClientId)
                .clientSecret(naverClientSecret)
                .jwkSetUri("temp")
                .build());
        return new InMemoryClientRegistrationRepository(registrations);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // h2-console 화면을 사용하기 위해 잠시 disable
        http
                .csrf().disable()
                        .headers().frameOptions().disable();

        // OAuth2 로그인 방식 적용하기
        http
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

        // 인증에 성공할때마다 JSESSIONID를 재발급
        /**
         * 인증에 성공할 때마다 JSESSIONID를 재발급해주기는 하는데
         * 그게 로그인 동작이 일어날때만 그러네 매 페이지를 새로고침할 때마다 인증에 성공했다고 적용되면
         * JSESSIONID 재발급해주겠지?
         * anyRequest().authenticated로 변경하였음에도 적용이 안됨 자세히 공부해봐야함
         * */

        http
                .sessionManagement()
                        .sessionFixation().changeSessionId();


        // 인가 기능 구현시 아래 코드를 변경해주어야 함

        http
                .authorizeHttpRequests()
                .anyRequest().authenticated();

        return http.build();
    }

    private ClientRegistration getRegistration(OAuth2ClientProperties clientProperties, String client){
        if("google".equals(client)){
            OAuth2ClientProperties.Registration registration = clientProperties.getRegistration().get("google");
            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .scope("email", "profile")
                    .build();
        }
        return null;
    }
}
