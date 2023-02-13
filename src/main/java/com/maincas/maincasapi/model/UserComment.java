package com.maincas.maincasapi.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
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
