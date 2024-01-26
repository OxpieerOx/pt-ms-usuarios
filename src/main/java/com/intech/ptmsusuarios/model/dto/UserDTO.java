package com.intech.ptmsusuarios.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
  private String name;
  private String lastName;
  private int age;
  private int dni;
  private String email;
  private String roleName;
}
