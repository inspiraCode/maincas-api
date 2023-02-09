package com.maincas.maincasapi.operation.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.maincas.maincasapi.model.Attachment;

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
public class ReceiptAttachment extends Attachment {
  @ManyToOne(optional = false)
  @JoinColumn(name = "receipt_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Receipt receipt;
}
