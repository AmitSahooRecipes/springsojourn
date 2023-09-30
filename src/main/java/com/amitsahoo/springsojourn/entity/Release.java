package com.amitsahoo.springsojourn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Release
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String releaseDate;
  private String description;
  
  public Release() {}
  
  public Release(Integer id, String description, String releaseDate) {
     this.id = id;
     this.releaseDate = releaseDate;
     this.description = description;
  }
  
  public Integer getId() {
     return this.id;
  }
  
  public void setId(Integer id) {
     this.id = id;
  }
  
  public String getReleaseDate() {
     return this.releaseDate;
  }
  
  public void setReleaseDate(String releaseDate) {
     this.releaseDate = releaseDate;
  }
  
  public String getDescription() {
     return this.description;
  }
  
  public void setDescription(String description) {
     this.description = description;
  }
}



