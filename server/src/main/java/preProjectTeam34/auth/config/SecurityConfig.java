package preProjectTeam34.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import preProjectTeam34.auth.CustomOAuth2UserService;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // h2-console 화면을 사용하기 위해 잠시 disable
        http
                .csrf().disable()
                        .headers().frameOptions().disable();

        http
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
        http
                .authorizeHttpRequests()
                .anyRequest().permitAll();
        return http.build();
    }
}
