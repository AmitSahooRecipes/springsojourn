package com.amitsahoo.springsojourn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;




@Entity
public class Ticket
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String title;
  private String description;
  @ManyToOne
  @JoinColumn(name = "application_id")
  private Application application;
  @ManyToOne
  @JoinTable(name = "ticket_release", joinColumns = {@JoinColumn(name = "ticket_fk")}, inverseJoinColumns = {@JoinColumn(name = "release_fk")})
  private Release release;
  private String status;
  
  public Ticket() {}
  
  public Ticket(String title, String description, Application application, Release release, String status) {
     this.title = title;
     this.description = description;
     this.application = application;
     this.release = release;
     this.status = status;
  }
  
  public String getStatus() {
     return this.status;
  }
  
  public void setStatus(String status) {
     this.status = status;
  }
  
  public Integer getId() {
     return this.id;
  }
  
  public void setId(Integer id) {
     this.id = id;
  }
  
  public String getTitle() {
     return this.title;
  }
  
  public void setTitle(String title) {
     this.title = title;
  }
  
  public String getDescription() {
     return this.description;
  }
  
  public void setDescription(String description) {
     this.description = description;
  }
  
  public Application getApplication() {
     return this.application;
  }
  
  public void setApplication(Application application) {
     this.application = application;
  }
  
  public Release getRelease() {
     return this.release;
  }
  
  public void setRelease(Release release) {
     this.release = release;
  }
}



