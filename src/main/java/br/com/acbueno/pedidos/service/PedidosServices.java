package br.com.acbueno.pedidos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.acbueno.pedidos.data.vo.PedidoVO;
import br.com.acbueno.pedidos.entity.Pedido;
import br.com.acbueno.pedidos.exception.ResourceNotFoundException;
import br.com.acbueno.pedidos.repostiory.PedidosRepository;

@Service
public class PedidosServices {

  private PedidosRepository pedidosRepository;

  @Autowired
  public PedidosServices(PedidosRepository pedidosRepository) {
    this.pedidosRepository = pedidosRepository;
  }

  public Page<PedidoVO> findAll(Pageable pageable) {
    var page = pedidosRepository.findAll(pageable);
    return page.map(this::convertToPedidoVO);
  }

  private PedidoVO convertToPedidoVO(Pedido pedido) {
    return PedidoVO.create(pedido);
  }

  public PedidoVO findById(Long id) {
    var entity = pedidosRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Não existem registro com esse ID"));
    return PedidoVO.create(entity);
  }

  public PedidoVO update(PedidoVO pedidoVO) {
    final Optional<Pedido> optionalPedidos = pedidosRepository.findById(pedidoVO.getId());

    if (!optionalPedidos.isPresent()) {
      new ResourceNotFoundException("Registro não encontrado");
    }
    return PedidoVO
        .create(pedidosRepository.save(Pedido.create(PedidoVO.create(optionalPedidos.get()))));
  }
  
  public void deleteById(Long id) {
    var entity = pedidosRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Não exitem registro com esse ID"));
        pedidosRepository.delete(entity);
  }
  
  public PedidoVO create(PedidoVO pedidoVO) {
    PedidoVO value = PedidoVO.create(pedidosRepository.save(Pedido.create(pedidoVO)));
    return value;
  }
}
