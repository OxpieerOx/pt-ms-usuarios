package com.intech.ptmsusuarios.service;

import com.intech.ptmsusuarios.common.Exceptions;
import com.intech.ptmsusuarios.converter.RoleConverter;
import com.intech.ptmsusuarios.converter.UserConverter;
import com.intech.ptmsusuarios.dao.IRoleDao;
import com.intech.ptmsusuarios.dao.IUserDao;
import com.intech.ptmsusuarios.model.Role;
import com.intech.ptmsusuarios.model.User;
import com.intech.ptmsusuarios.model.dto.RoleDTO;
import com.intech.ptmsusuarios.model.dto.UserDTO;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

  public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  private final IRoleDao roleDao;
  private final IUserDao userDao;

  @Override
  public void createUser(UserDTO userDTO) {
    UserConverter userConverter = new UserConverter();
    Role role = roleDao.findByName(userDTO.getRoleName());

    if (role == null) {
      throw new RoleNotFoundException("Role not found with name: " + userDTO.getRoleName());
    }

    var newUser = userConverter.toEntity(userDTO);
    newUser.setRole(role);

    userDao.save(newUser);
  }

  @Override
  public List<User> listUsers() {
    return (List<User>) userDao.findAll();
  }

  @Override
  public void updateUser(Long userId, UserDTO updatedUserDTO) {
    Optional<User> optionalUser = userDao.findById(userId);
    UserConverter userConverter = new UserConverter();

    if (optionalUser.isPresent()) {
      User existingUser = optionalUser.get();
      existingUser.setName(updatedUserDTO.getName());
      existingUser.setLastName(updatedUserDTO.getLastName());
      existingUser.setAge(updatedUserDTO.getAge());
      existingUser.setDni(updatedUserDTO.getDni());
      existingUser.setEmail(updatedUserDTO.getEmail());
      userDao.save(existingUser);
    } else {

      User newUser = userConverter.toEntity(updatedUserDTO);
      userDao.save(newUser);
    }
  }

  @Override
  public void deleteUser(Long userId) {
    Optional<User> optionalUser = userDao.findById(userId);

    if (optionalUser.isPresent()) {
      userDao.deleteById(userId);
    } else {
      throw new RoleNotFoundException("ID NO ENCONTRADO" );
    }
  }



  @Override
  public void createRole(RoleDTO roleDTO) throws Exceptions {
    try {
      RoleConverter roleConverter = new RoleConverter();
      var newRole = roleConverter.toEntity(roleDTO);

      roleDao.save(newRole);
    }
    catch (HibernateException e) {
      throw new Exceptions(e.getMessage());
    }
  }

  @Override
  public List<Role> listRoles() {
    return (List<Role>) roleDao.findAll();
  }


  public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String message) {
      super(message);
    }
  }
}
