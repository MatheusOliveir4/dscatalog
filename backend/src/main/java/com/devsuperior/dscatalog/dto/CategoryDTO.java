package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

  private Long id;
  private String name;

  public CategoryDTO(Category entity) {
    this.id = entity.getId();
    this.name = entity.getName();
  }
}
