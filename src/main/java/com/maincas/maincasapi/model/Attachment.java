package com.maincas.maincasapi.model;

import java.util.Date;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Attachment extends Auditable {
  @NotNull
  @NotBlank
  private String type;
  @NotNull
  @NotBlank
  private String name;
  @NotNull
  @NotBlank
  private String fileType;
  @NotNull
  @NotBlank
  private String fileName;
  private String reference;
  private String observations;
  @NotNull
  @NotBlank
  private Boolean singleUse;
  private String usageReference;
  private String eTag;

  @JsonInclude()
  @Transient
  private String base64;

  @Temporal(TemporalType.TIMESTAMP)
  private Date issueDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date expirationDate;

}
