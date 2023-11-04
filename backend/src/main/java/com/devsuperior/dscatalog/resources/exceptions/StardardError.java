package com.devsuperior.dscatalog.resources.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class StardardError {
  private Instant timestamp;
  private Integer status;
  private String error;
  private String message;
  private String path;
}
