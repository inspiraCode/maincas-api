package com.maincas.maincasapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class UserComment extends Identifiable {
  @Column(name = "created_by", updatable = false)
  private String createdBy;

  @Column(name = "created_date", updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;
  @NotNull
  @NotBlank
  private String comment;
}
