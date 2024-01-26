package com.intech.ptmsusuarios.service;

import com.intech.ptmsusuarios.common.Exceptions;
import com.intech.ptmsusuarios.model.Role;
import com.intech.ptmsusuarios.model.User;
import com.intech.ptmsusuarios.model.dto.RoleDTO;
import com.intech.ptmsusuarios.model.dto.UserDTO;

import java.util.List;

public interface IUserService {
  void createUser(UserDTO userDTO);

  List<User> listUsers();
  void updateUser(Long userId, UserDTO updatedUserDTO);
  void deleteUser(Long userId);
  void createRole(RoleDTO roleDTO) throws Exceptions;

  List<Role> listRoles();
}
