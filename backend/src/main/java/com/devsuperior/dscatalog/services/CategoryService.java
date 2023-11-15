package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Transactional(readOnly = true)
  public Page<CategoryDTO> findAll(Pageable pageable) {
    Page<Category> result = categoryRepository.findAll(pageable);

    return result.map(x -> new CategoryDTO(x));
  }

  @Transactional(readOnly = true)
  public CategoryDTO findById(Long id) {
    Optional<Category> obj = categoryRepository.findById(id);
    Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

    return new CategoryDTO(entity);
  }

  @Transactional
  public CategoryDTO insert(CategoryDTO dto) {
    Category entity = new Category();

    BeanUtils.copyProperties(dto, entity, "id");

    entity = categoryRepository.save(entity);
    return new CategoryDTO(entity);
  }

  @Transactional
  public CategoryDTO update(Long id, CategoryDTO dto) {
    try {
      Category entity = categoryRepository.getOne(id);

      BeanUtils.copyProperties(dto, entity, "id");

      entity = categoryRepository.save(entity);
      return new CategoryDTO(entity);

    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException("Id not found " + id);
    }
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void delete(Long id) {
    if (!categoryRepository.existsById(id)) {
      throw new ResourceNotFoundException("Id not found " + id);
    }

    try {
      categoryRepository.deleteById(id);

    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException("Integrity violation");
    }
  }
}
