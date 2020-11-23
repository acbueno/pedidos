package br.com.acbueno.pedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.pedidos.data.vo.StatusVO;
import br.com.acbueno.pedidos.dto.StatusResponseDTO;
import br.com.acbueno.pedidos.service.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController {

  
  StatusService statusService;
  
  
  @Autowired
  public StatusController(StatusService statusService) {
    this.statusService = statusService;
  }

  @PostMapping(produces = {"application/json"}, consumes = {"application/json"})
  public ResponseEntity< StatusResponseDTO> create(@RequestBody StatusVO statusVO) {
      StatusVO value = statusService.create(statusVO);
      return new ResponseEntity<>(StatusResponseDTO.convertEntityToDTO(value), HttpStatus.CREATED);
  }
  
}
