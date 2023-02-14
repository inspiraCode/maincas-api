package com.maincas.maincasapi.catalogs.model;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.maincas.maincasapi.model.UserComment;

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
public class CompanyUserComment extends UserComment {
  @ManyToOne(optional = false)
  @JoinColumn(name = "company_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Company company;

  @Builder
  public CompanyUserComment(String comment, String createdBy, Company company) {
    super(createdBy, new Date(), comment);
    this.company = company;
  }
}
