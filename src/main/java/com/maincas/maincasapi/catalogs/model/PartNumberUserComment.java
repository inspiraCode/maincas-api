package com.maincas.maincasapi.catalogs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.maincas.maincasapi.model.UserComment;

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
public class PartNumberUserComment extends UserComment {
  @ManyToOne(optional = false)
  @JoinColumn(name = "part_number_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private PartNumber partNumber;
  
}
