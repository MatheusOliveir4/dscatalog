package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleDTO {
  private Long id;
  private String authority;

  public RoleDTO(Role role) {
    id = role.getId();
    authority = role.getAuthority();
  }
}
