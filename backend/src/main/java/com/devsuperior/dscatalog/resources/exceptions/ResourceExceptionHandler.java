package com.devsuperior.dscatalog.resources.exceptions;

import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StardardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;

    StardardError err = StardardError.builder()
            .timestamp(Instant.now())
            .status(status.value())
            .error("Resource not found")
            .message(e.getMessage())
            .path(request.getRequestURI())
            .build();

    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(DatabaseException.class)
  public ResponseEntity<StardardError> database(DatabaseException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.CONFLICT;

    StardardError err = StardardError.builder()
            .timestamp(Instant.now())
            .status(status.value())
            .error("Database exception")
            .message(e.getMessage())
            .path(request.getRequestURI())
            .build();

    return ResponseEntity.status(status).body(err);
  }

}
