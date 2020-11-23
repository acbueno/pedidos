package br.com.acbueno.pedidos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
  
  private static final long serialVersionUID = -5099435007293258431L;

  public ResourceNotFoundException(String message) {
    super(message);
  }
  
  

}
