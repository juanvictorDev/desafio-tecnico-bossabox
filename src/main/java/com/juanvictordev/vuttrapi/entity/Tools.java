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
@Table(name = "tools")
public class Tools {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer tool_id;

  @Column(nullable = false)
  String title;

  @Column(nullable = false, unique = true)
  String link;

  @Column(nullable = false)
  String description;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name="tool_tag", 
    joinColumns = @JoinColumn(name="tool_id", referencedColumnName="tool_id"),
    inverseJoinColumns = @JoinColumn(name="tag_name", referencedColumnName="tag_name")
  )
  Set<Tags> tags;
  
  // CONSTRUTORES
  public Tools() {
  }
  
  public Tools(String title, String link, String description, Set<Tags> tags) {
    this.title = title;
    this.link = link;
    this.description = description;
    this.tags = tags;
  }

  //GETTERS E SETTERS
  public int getTool_id() {
    return tool_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<Tags> getTags() {
    return tags;
  }

  public void setTags(Set<Tags> tags) {
    this.tags = tags;
  }
  
}
