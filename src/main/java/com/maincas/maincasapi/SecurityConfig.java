package com.maincas.maincasapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.extern.slf4j.Slf4j;

/**
 * Configures our application with Spring Security to restrict access to our API
 * endpoints.
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
  @Value("${auth0.audience}")
  private String audience;

  @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
  private String issuer;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    log.info("ENABLING security filter chain.");
    http.cors((cors) -> cors.configurationSource(configurationSource())).csrf((csrf) -> csrf.disable())
        .authorizeHttpRequests(
            ar -> ar.requestMatchers("/api/**").authenticated().anyRequest().permitAll());

    return http.build();
  }

  @Bean
  JwtDecoder jwtDecoder() {
    /*
     * By default, Spring Security does not validate the "aud" claim of the token,
     * to ensure that this token is
     * indeed intended for our app. Adding our own validator is easy to do:
     */

    NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuer);

    OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
    OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
    OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

    jwtDecoder.setJwtValidator(withAudience);

    return jwtDecoder;
  }

  private CorsConfigurationSource configurationSource() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedOrigin("*");
    config.setAllowCredentials(true);
    config.addAllowedHeader("X-Requested-With");
    config.addAllowedHeader("Content-Type");
    config.addAllowedMethod(HttpMethod.POST);
    config.addAllowedMethod(HttpMethod.GET);
    config.addAllowedMethod(HttpMethod.PUT);
    config.addAllowedMethod(HttpMethod.DELETE);
    config.addAllowedMethod(HttpMethod.OPTIONS);
    source.registerCorsConfiguration("/**", config);
    return source;
  }

}
