package com.devsuperior.dscatalog.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;
  private Double price;
  private String imgUrl;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant date;

  @ManyToMany
  @JoinTable(
          name = "tb_product_category",
          joinColumns = @JoinColumn(name = "product_id"),
          inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  @Getter
  Set<Category> categories = new HashSet<>();
}
