package com.maincas.maincasapi.catalogs.model;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.maincas.maincasapi.model.Attachment;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@ToString
@EqualsAndHashCode(callSuper = false)
public class CompanyAttachment extends Attachment {
  @ManyToOne(optional = false)
  @JoinColumn(name = "company_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Company company;

  @Builder
  public CompanyAttachment(String type, String name, String fileType, String fileName, String reference,
      String observations, Boolean singleUse, String usageReference, String eTag, String base64, Date issueDate,
      Date expirationDate, Company company) {
    super(type, name, fileType, fileName, reference, observations, singleUse, usageReference, eTag, base64, issueDate,
        expirationDate);
    this.company = company;
  }
}
