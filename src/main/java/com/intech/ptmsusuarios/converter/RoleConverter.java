package com.intech.ptmsusuarios.converter;

import com.intech.ptmsusuarios.model.Role;
import com.intech.ptmsusuarios.model.dto.RoleDTO;

public class RoleConverter extends AbstractConverter<Role, RoleDTO>{
  @Override
  public Role toEntity(RoleDTO dto) {
    Role role = new Role();

    role.setName(dto.getName());
    role.setCreatedby(dto.getCreatedBy());

    return role;
  }

  @Override
  public RoleDTO toDTO(Role entity) {
    RoleDTO roleDto = new RoleDTO();

    roleDto.setName(entity.getName());
    roleDto.setCreatedBy(entity.getCreatedby());

    return roleDto;
  }
}
