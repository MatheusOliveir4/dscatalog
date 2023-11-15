package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class ProductDTO {

  private Long id;

  @Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
  @NotBlank(message = "Campo requerido")
  private String name;

  @NotBlank(message = "Campo requerido")
  private String description;

  @Positive(message = "Preço deve ser um valor positivo")
  private Double price;
  private String imgUrl;

  @PastOrPresent(message = "A data do produto não pode ser futura")
  private Instant date;

  private List<CategoryDTO> categories = new ArrayList<>();

  public ProductDTO(Product entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.price = entity.getPrice();
    this.imgUrl = entity.getImgUrl();
    this.date = entity.getDate();
  }

  public ProductDTO(Product entity, Set<Category> categories) {
    this(entity);

    categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
  }
}
