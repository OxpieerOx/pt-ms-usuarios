package com.intech.ptmsusuarios.converter;

import com.intech.ptmsusuarios.model.User;
import com.intech.ptmsusuarios.model.dto.UserDTO;

public class UserConverter extends AbstractConverter<User, UserDTO> {

  @Override
  public User toEntity(UserDTO dto) {
    User user = new User();

    user.setName(dto.getName());
    user.setLastName(dto.getLastName());
    user.setAge(dto.getAge());
    user.setDni(dto.getDni());
    user.setEmail(dto.getEmail());

    return user;
  }

  @Override
  public UserDTO toDTO(User entity) {
    UserDTO userDto = new UserDTO();

    userDto.setName(entity.getName());
    userDto.setLastName(entity.getLastName());
    userDto.setAge(entity.getAge());
    userDto.setDni(entity.getDni());
    userDto.setEmail(entity.getEmail());
    userDto.setRoleName(entity.getRole().getName());

    return userDto;
  }

}
