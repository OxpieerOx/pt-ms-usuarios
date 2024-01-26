package com.intech.ptmsusuarios.controller;

import com.intech.ptmsusuarios.common.Exceptions;
import com.intech.ptmsusuarios.model.Role;
import com.intech.ptmsusuarios.model.User;
import com.intech.ptmsusuarios.model.dto.RoleDTO;
import com.intech.ptmsusuarios.model.dto.UserDTO;
import com.intech.ptmsusuarios.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
  public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  private final UserServiceImpl userService;
  @GetMapping("/listUsers")
  public ResponseEntity<List<User>> listUsers() {
    try {
      List<User> userList = userService.listUsers();
      return new ResponseEntity<>(userList, HttpStatus.OK);
    } catch (Exception e) {
      LOGGER.error("Error al obtener la lista de usuarios", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @PostMapping("/createUser")
  public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
    try {
      userService.createUser(userDTO);
      LOGGER.info("User created");
      return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    } catch (Exception e) {
      LOGGER.error("Error al crear el usuario", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/deleteUser/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
    try {
      userService.deleteUser(userId);
      LOGGER.info("User deleted");
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      LOGGER.error("Error al eliminar el usuario", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/updateUser/{userId}")
  public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO updatedUserDTO) {
    try {
      userService.updateUser(userId, updatedUserDTO);
      LOGGER.info("User updated");
      return new ResponseEntity<>(updatedUserDTO, HttpStatus.OK);
    } catch (Exception e) {
      LOGGER.error("Error al actualizar el usuario", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/createRole")
  public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {
    try {
      userService.createRole(roleDTO);
      LOGGER.info("Role created");
      return new ResponseEntity<>(roleDTO, HttpStatus.CREATED);
    } catch (Exception e) {
      LOGGER.error("Error al crear el rol", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/listRoles")
  public ResponseEntity<List<Role>> listRoles() {
    try {
      List<Role> roleList = userService.listRoles();
      return new ResponseEntity<>(roleList, HttpStatus.OK);
    } catch (Exception e) {
      LOGGER.error("Error al obtener la lista de roles", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
