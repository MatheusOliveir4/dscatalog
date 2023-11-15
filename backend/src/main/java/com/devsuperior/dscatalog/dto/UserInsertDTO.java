package com.devsuperior.dscatalog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserInsertDTO extends UserDTO {
  private String password;
}
