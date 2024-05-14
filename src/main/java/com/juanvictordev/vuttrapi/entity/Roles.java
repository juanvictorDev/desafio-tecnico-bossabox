package com.juanvictordev.vuttrapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {
  
  //COLUNA
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(unique = true, nullable = false)
  @Enumerated(EnumType.STRING)
  RoleValue name;

  //CONSTRUTORES
  public Roles() {
  }

  public Roles(RoleValue name) {
    this.name = name;
  }
  
  //GETTERS E SETTERS
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RoleValue getName() {
    return name;
  }

  public void setName(RoleValue name) {
    this.name = name;
  }

}
