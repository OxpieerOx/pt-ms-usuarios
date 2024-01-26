package com.intech.ptmsusuarios.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idrol")
  private long idrol;

  @Column(name = "name")
  private String name;

  @Column(name = "createdby")
  private String createdby;
}
