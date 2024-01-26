package com.intech.ptmsusuarios.service;

import com.intech.ptmsusuarios.common.Exceptions;
import com.intech.ptmsusuarios.model.dto.RoleDTO;
import com.intech.ptmsusuarios.model.dto.UserDTO;

public interface IUserService {
  void createUser(UserDTO userDTO);
  void createRole(RoleDTO roleDTO) throws Exceptions;
}
