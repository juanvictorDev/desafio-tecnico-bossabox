package com.juanvictordev.vuttrapi.entity;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

  //COLUNA
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(unique = true, nullable = false)
  String email;
  
  @Column(nullable = false)
  String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name="user_role",
    joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
    inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName="id")
  )
  Set<Roles> roles;

  //CONSTRUTORES
  public User() {
  }

  public User(String email, String password, Set<Roles> roles) {
    this.email = email;
    this.password = password;
    this.roles = roles;
  }

  //GETTERS E SETTERS
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Roles> getRoles() {
    return roles;
  }

  public void setRoles(Set<Roles> roles) {
    this.roles = roles;
  }

  

}
