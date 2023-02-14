package com.maincas.maincasapi.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
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
