package com.devsuperior.dscatalog.resources.exceptions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StardardError {
  @Getter
  private List<FieldMessage> errors = new ArrayList<>();

  public void addError(String fieldName, String message) {
    errors.add(new FieldMessage(fieldName, message));
  }
}
