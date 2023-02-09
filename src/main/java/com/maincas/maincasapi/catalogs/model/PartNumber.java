package com.maincas.maincasapi.catalogs.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class PartNumber extends Auditable {
  @NotNull
  @NotBlank
  private String name;

  @ManyToOne(optional = false)
  @JoinColumn(name = "buyer_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Company buyer;

  @ManyToOne(optional = false)
  @JoinColumn(name = "material_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Material material;

  private Double minStock;
  private String measureUnit;
  // example: FELI-OME-A012
  private String storageLocation;
}
