package com.maincas.maincasapi.catalogs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToOne(optional = false)
  @JoinColumn(name = "buyer_id")
  private Company buyer;
  @ManyToOne(optional = false)
  @JoinColumn(name = "tariff_id")
  private TariffSchedule tariffSchedule;
  @ManyToOne(optional = false)
  @JoinColumn(name = "sed_tariff_id")
  private TariffSchedule sedTariffSchedule;
  private Boolean approvedImpo;
  private String legalDescription;
  private String commercialDescription;
  private String sedDescription;
  private String observations;

}
