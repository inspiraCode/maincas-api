package com.maincas.maincasapi.catalogs.model;

import javax.persistence.Entity;

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
  private String alias;
  private String name;
  private String addressLineOne;
  private String addressLineTwo;
  private String addressCity;
  private String addressState;
  private String addressZip;
  private String addressCountry;
  private String roles;
  private Boolean block;
}
