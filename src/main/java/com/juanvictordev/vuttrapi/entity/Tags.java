package com.juanvictordev.vuttrapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tags")
public class Tags {
  
  @Id
  String tag_name;

  // CONSTRUTORES
  public Tags() {
  }

  public Tags(String tag_name) {
    this.tag_name = tag_name;
  }

  //GETTERS E SETTERS
  public String getTag_name() {
    return tag_name;
  }

  public void setTag_name(String tag_name) {
    this.tag_name = tag_name;
 } 
}