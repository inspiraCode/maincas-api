package com.maincas.maincasapi.operation.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import com.maincas.maincasapi.catalogs.model.Company;
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
public class Receipt extends Auditable {
  @NotNull
  @NotBlank
  private String documentNumber;
  private String trackingNumber;
  @Temporal(TemporalType.DATE)
  private Date trackingDate;
  @Temporal(TemporalType.DATE)
  private Date arrivalDate;
  @ManyToOne(optional = false)
  @JoinColumn(name = "buyer_id")
  private Company buyer;
  @ManyToOne(optional = false)
  @JoinColumn(name = "seller_id")
  private Company seller;
  @ManyToOne(optional = false)
  @JoinColumn(name = "shipper_id")
  private Company shipper;
  @ManyToOne(optional = false)
  @JoinColumn(name = "consignee_id")
  private Company consignee;
  @ManyToOne(optional = false)
  @JoinColumn(name = "broker_id")
  private Company broker;
  @ManyToOne(optional = false)
  @JoinColumn(name = "carrier_id")
  private Company carrier;
  private String observations;
}
