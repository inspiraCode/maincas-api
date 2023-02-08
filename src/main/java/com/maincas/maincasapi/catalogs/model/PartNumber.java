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
public class PartNumber extends Auditable {
  @ManyToOne(optional = false)
  @JoinColumn(name = "buyer_id")
  private Company buyer;
  @ManyToOne(optional = false)
  @JoinColumn(name = "material_id")
  private Material material;
  private Double minStock;
  private String measureUnit;
  // example: FELI-OME-A012
  private String storageLocation;
}
