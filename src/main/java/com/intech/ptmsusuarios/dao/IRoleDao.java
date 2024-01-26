package com.intech.ptmsusuarios.dao;

import com.intech.ptmsusuarios.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleDao extends CrudRepository<Role, Integer> {

    Role findByName(String name);
}
