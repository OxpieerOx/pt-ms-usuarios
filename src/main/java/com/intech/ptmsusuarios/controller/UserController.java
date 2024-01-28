package com.intech.ptmsusuarios.controller;

import com.intech.ptmsusuarios.common.Exceptions;
import com.intech.ptmsusuarios.model.dto.RoleDTO;
import com.intech.ptmsusuarios.model.dto.UserDTO;
import com.intech.ptmsusuarios.model.response.ServiceResponse;
import com.intech.ptmsusuarios.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
  public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  private final UserServiceImpl userService;

  @PostMapping("/user/create")
  public void createUser(@RequestBody UserDTO userRequest) {

    userService.createUser(userRequest);

    LOGGER.info("User created");
  }

  @PostMapping("/role/create")
  public ServiceResponse createRole(@RequestBody RoleDTO roleRequest) throws Exceptions {

    userService.createRole(roleRequest);

    LOGGER.info("Role created");

    return ServiceResponse.builder()
            .code("200")
            .message("Role created")
            .build();
  }

}
