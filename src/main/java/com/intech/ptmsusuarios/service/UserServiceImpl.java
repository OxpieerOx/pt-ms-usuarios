package com.intech.ptmsusuarios.service;

import com.intech.ptmsusuarios.common.Exceptions;
import com.intech.ptmsusuarios.converter.RoleConverter;
import com.intech.ptmsusuarios.converter.UserConverter;
import com.intech.ptmsusuarios.dao.IRoleDao;
import com.intech.ptmsusuarios.dao.IUserDao;
import com.intech.ptmsusuarios.model.dto.RoleDTO;
import com.intech.ptmsusuarios.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

  public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  private final IRoleDao roleDao;
  private final IUserDao userDao;

  @Override
  public void createUser(UserDTO userDTO) {
    UserConverter userConverter = new UserConverter();
    var newUser = userConverter.toEntity(userDTO);

    userDao.save(newUser);
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
}
