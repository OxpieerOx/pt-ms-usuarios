package com.intech.ptmsusuarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "rol")
@Entity
public class Role {
  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "created_by")
  private String createdBy;
}
