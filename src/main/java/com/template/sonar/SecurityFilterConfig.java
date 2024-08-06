package com.template.sonar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;


public class SecurityFilterConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(requests -> {
            requests.requestMatchers(HttpMethod.GET, "/login").permitAll();
            requests.requestMatchers(HttpMethod.GET, "/product/**").permitAll();
            requests.requestMatchers("/user/**").hasRole("ADMIN");
            requests.anyRequest().authenticated();});
        http.httpBasic(withDefaults());
        return http.build();
    }
}
