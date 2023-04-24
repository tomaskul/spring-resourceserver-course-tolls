package io.github.tomaskul.resourceserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> {
                            try {
                                // JWT OAuth configuration (if setting up, ensure auth server is up and running +
                                // configured, and application.properties values are set):
                                /*authz
                                        .requestMatchers(HttpMethod.GET, "api/tolldata").hasAuthority("SCOPE_reader")
                                        .anyRequest().authenticated()
                                        .and()
                                        .oauth2ResourceServer().jwt();*/
                                // Unsecured configuration:
                                authz
                                        .requestMatchers(HttpMethod.GET, "api/tolldata").permitAll();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
        return http.build();
    }
}
