package com.devsuperior.dscatalog.resources.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldMessage {

  private String fieldName;
  private String message;
}
