package com.maincas.maincasapi.operation.model;

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
public class ReceiptItem extends Auditable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Integer index;
  private Integer quantity;
  private String packingUnitOfMeasure;
  private Double grossWeightLbs;
  private Double grossWeightKg;
  private String description;
  private String unIdentifier;
  private Boolean wooden;
  @ManyToOne(optional = false)
  @JoinColumn(name = "receipt_id")
  private Receipt receipt;
  
}
