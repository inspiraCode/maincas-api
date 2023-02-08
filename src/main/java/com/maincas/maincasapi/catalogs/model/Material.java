package com.maincas.maincasapi.catalogs.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Material extends Auditable {
  @ManyToOne(optional = false)
  @JoinColumn(name = "buyer_id")
  private Company buyer;
  @ManyToOne(optional = false)
  @JoinColumn(name = "tariff_id")
  private TariffSchedule tariffSchedule;
  // SED = Shipper Export Declaration
  @ManyToOne(optional = false)
  @JoinColumn(name = "sed_tariff_id")
  private TariffSchedule sedTariffSchedule;
  private Boolean approvedImpo;
  private String legalDescription;
  private String commercialDescription;
  // SED = Shipper Export Declaration
  private String sedDescription;
  private String observations;
  private String unHazard;
  private Boolean isHazard;

}
