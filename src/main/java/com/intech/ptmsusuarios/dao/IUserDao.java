package com.intech.ptmsusuarios.dao;

import com.intech.ptmsusuarios.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends CrudRepository<User, Integer> { }
