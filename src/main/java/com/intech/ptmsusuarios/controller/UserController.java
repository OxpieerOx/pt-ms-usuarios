package com.intech.ptmsusuarios.controller;

import com.intech.ptmsusuarios.common.Exceptions;
import com.intech.ptmsusuarios.model.dto.RoleDTO;
import com.intech.ptmsusuarios.model.dto.UserDTO;
import com.intech.ptmsusuarios.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
  public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  private final UserServiceImpl userService;

  @PostMapping("/create")
  public void createUser(UserDTO userRequest) {

    userService.createUser(userRequest);

    LOGGER.info("User created");
  }

  @PostMapping("/create")
  public void createRole(RoleDTO roleRequest) throws Exceptions {

    userService.createRole(roleRequest);

    LOGGER.info("Role created");
  }
}
