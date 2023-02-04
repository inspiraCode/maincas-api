package com.maincas.maincasapi;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Attach a user identifier to requests / responses / logs for auditing
 * User details can be found in the Auth0 Dashboard: https://manage.auth0.com/#/users -> Search the "user_id" by Lucene Syntax
 */
public class SecurityAuditorAware implements AuditorAware<String> {
  private static final String SYSTEM = "System";

  @Override
  public Optional<String> getCurrentAuditor() {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      String currentUserName = authentication.getName();
      return Optional.of(currentUserName);
    } else {
      return Optional.of(SYSTEM);
    }
  }
}
