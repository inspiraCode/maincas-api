package com.maincas.maincasapi.service;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.maincas.maincasapi.model.UserComment;

public abstract class AbstractUserCommentServiceImpl<T extends UserComment, U extends JpaRepository<T, Long>>
    extends AbstractMaincasItemServiceImpl<T, U> {

  @Override
  public T create(T entity) {
    String loggedInUser = getAuthenticatedUser();
    entity.setCreatedBy(loggedInUser);
    entity.setCreatedDate(new Date());

    return super.create(entity);
  }

  @Override
  public T update(Long id, T entity) {
    String loggedInUser = getAuthenticatedUser();
    String errorMessage = String.format("Unable to find {} by id {}", getType().toString(), id);
    T dbEntity = super.fetchById(id).orElseThrow(() -> new IllegalArgumentException(errorMessage));
    if (!loggedInUser.equalsIgnoreCase(dbEntity.getCreatedBy()))
      throw new IllegalArgumentException(
          String.format("The user that created the comment must be the same to modify it ({})", loggedInUser));

    if (Objects.nonNull(entity.getComment()) && !"".equalsIgnoreCase(entity.getComment())) {
      dbEntity.setComment(entity.getComment());
    }

    return super.update(id, entity);
  }

  private String getAuthenticatedUser() {
    String loggedInUser = "System";
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      loggedInUser = authentication.getName();
    }
    return loggedInUser;
  }

}
