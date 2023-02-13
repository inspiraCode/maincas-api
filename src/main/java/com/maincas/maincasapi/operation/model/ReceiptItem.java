package com.maincas.maincasapi.operation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;

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
public class ReceiptItem extends Auditable {
  @Min(value = 1, message = "Index must start with 1")
  private Integer index;
  @Min(value = 1, message = "At least 1 package per item")
  private Integer quantity;
  private String packingUnitOfMeasure;
  private Double grossWeightLbs;
  private Double grossWeightKg;
  private String description;
  private String unIdentifier;
  private Boolean wooden;

  @ManyToOne(optional = false)
  @JoinColumn(name = "receipt_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Receipt receipt;

}
