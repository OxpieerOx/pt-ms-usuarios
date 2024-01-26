package com.intech.ptmsusuarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "rol")
public class Role {
  @Id
  @Column(name = "Id")
  private int id;
  @Column(name = "Name")
  private String name;
  @Column(name = "CreatedBy")
  private String createdBy;
}
