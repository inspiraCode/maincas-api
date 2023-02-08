package com.maincas.maincasapi.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Identifiable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
}
