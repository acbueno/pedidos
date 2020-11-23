package br.com.acbueno.pedidos.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.pedidos.data.vo.PedidoVO;
import br.com.acbueno.pedidos.service.PedidosServices;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {


  private PedidosServices pedidosServices;

  private final PagedResourcesAssembler<PedidoVO> assembler;

  @Autowired
  public PedidoController(PedidosServices pedidosServices,
      PagedResourcesAssembler<PedidoVO> assembler) {
    this.pedidosServices = pedidosServices;
    this.assembler = assembler;
  }

  @GetMapping(value = "/{id}", produces = {"application/json"})
  public PedidoVO findById(@PathVariable("id") Long id) {
    PedidoVO pedidoVO = pedidosServices.findById(id);
    pedidoVO.add(linkTo(methodOn(PedidoController.class).findById(id)).withSelfRel());

    return pedidoVO;

  }

  @GetMapping(produces = {"application/json"})
  public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "lmiit", defaultValue = "12") int limit,
      @RequestParam(value = "direction", defaultValue = "asc") String direction) {

    var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
    Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "id"));

    Page<PedidoVO> pedidos = pedidosServices.findAll(pageable);

    pedidos.stream().forEach(
        p -> p.add(linkTo(methodOn(PedidoController.class).findById(p.getId())).withSelfRel()));

    PagedModel<EntityModel<PedidoVO>> pageModel = assembler.toModel(pedidos);
    return new ResponseEntity<>(pageModel, HttpStatus.OK);


  }

  @PostMapping(produces = {"application/json"}, consumes = {"application/json"})
  public PedidoVO create(@RequestBody PedidoVO pedidoVO) {
    PedidoVO pedVO = pedidosServices.create(pedidoVO);
    pedVO.add(linkTo(methodOn(PedidoController.class).findById(pedidoVO.getId())).withSelfRel());

    return pedVO;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(Long id) {
    pedidosServices.deleteById(id);

    return ResponseEntity.ok().build();
  }

  @PutMapping(produces = {"application/json"}, consumes = {"application/json"})
  public PedidoVO update(@RequestBody PedidoVO pedidoVO) {
    PedidoVO pediVo = pedidosServices.update(pedidoVO);
    pediVo.add(linkTo(methodOn(PedidoController.class).findById(pedidoVO.getId())).withSelfRel());

    return pediVo;
  }



}
