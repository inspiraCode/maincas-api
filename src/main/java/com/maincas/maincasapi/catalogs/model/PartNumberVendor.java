package com.maincas.maincasapi.catalogs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Company seller;

  @ManyToOne(optional = false)
  @JoinColumn(name = "part_number_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private PartNumber partNumber;

  private Integer packingUnit;
  private Double pricePerItem;
  private String currency;
  private Double packagePrice;
  @NotNull
  @NotBlank
  private String SKU;
}
