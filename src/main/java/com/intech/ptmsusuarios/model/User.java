package com.intech.ptmsusuarios.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "iduser")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "age")
  private int age;

  @Column(name = "dni")
  private int dni;

  @Column(name = "mail")
  private String email;

  @ManyToOne
  @JoinColumn(name = "idrol")
  private Role role;

}