package com.intech.ptmsusuarios.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "usuario")
public class User {
  @Id
  @Column(name = "Id")
  private int id;
  @Column(name = "Name")
  private String name;
  @Column(name = "LastName")
  private String lastName;
  @Column(name = "Age")
  private int age;
  @Column(name = "Dni")
  private int dni;
  @Column(name = "Mail")
  private String email;
  @ManyToOne
  @Column(name = "IdRol")
  private Role role;
}
