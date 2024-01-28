package com.intech.ptmsusuarios.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "user")
@Entity
public class User {
  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "lastname")
  private String lastName;
  @Column(name = "age")
  private int age;
  @Column(name = "dni")
  private int dni;
  @Column(name = "email")
  private String email;
  @ManyToOne
  @JoinColumn(name = "id_role")
  private Role role;
}
