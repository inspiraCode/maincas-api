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
public class PartNumberVendor extends Auditable {
  @ManyToOne(optional = false)
  @JoinColumn(name = "seller_id")
  private Company seller;
  @ManyToOne(optional = false)
  @JoinColumn(name = "part_number_id")
  private PartNumber partNumber;
  private Integer packingUnit;
  private Double pricePerItem;
  private String currency;
  private Double packagePrice;
  private String SKU;
}
