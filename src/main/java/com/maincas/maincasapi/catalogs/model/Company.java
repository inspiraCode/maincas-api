package com.maincas.maincasapi.catalogs.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import com.maincas.maincasapi.model.Auditable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
@Audited(withModifiedFlag = true)
@AuditOverride(forClass = Auditable.class)
public class Company extends Auditable {
  @NotNull
  @NotBlank
  private String alias;
  @NotNull
  @NotBlank
  private String name;
  private String addressLineOne;
  private String addressLineTwo;
  private String addressCity;
  private String addressState;
  private String addressZip;
  private String addressCountry;
  @NotNull
  @NotBlank
  private String roles;
  private Boolean block;
}
