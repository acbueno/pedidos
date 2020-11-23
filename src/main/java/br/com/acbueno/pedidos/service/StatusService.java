package br.com.acbueno.pedidos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.pedidos.data.vo.StatusVO;
import br.com.acbueno.pedidos.entity.Item;
import br.com.acbueno.pedidos.entity.Pedido;
import br.com.acbueno.pedidos.entity.Status;
import br.com.acbueno.pedidos.enums.StatusType;
import br.com.acbueno.pedidos.repostiory.PedidosRepository;
import br.com.acbueno.pedidos.repostiory.StatusRepository;

@Service
public class StatusService {

  private StatusRepository statusRepository;
  private PedidosRepository pedidosRepository;
 
  @Autowired
  public StatusService(StatusRepository statusRepository, PedidosRepository pedidosRepository) {
    this.statusRepository = statusRepository;
    this.pedidosRepository = pedidosRepository;
  }

  public StatusVO create(StatusVO statusVO) {
    Optional<Pedido> pedidoVO = pedidosRepository.findById(statusVO.getIdPedido());
    discoverStatus(statusVO, pedidoVO);
    StatusVO value = StatusVO.create(statusRepository.save(Status.create(statusVO)));
    return value;
  }

  private void discoverStatus(StatusVO statusVO, Optional<Pedido> pedidoVO) {
    if (!pedidoVO.isPresent()) {
      statusVO.setStatus(StatusType.CODIGO_PEDIDO_INVALIDO);
    } else {
      if (statusVO.getStatus().equals(StatusType.APROVADO)) {
        List<Item> itens = pedidoVO.get().getItens();
        int totalQtd = 0;
        for (Item item : itens) {
          totalQtd += item.getQtd();
        }
        int valorTotalPedidos =0;
        for (Item item : itens) {
          valorTotalPedidos += item.getQtd()*item.getPrecoUnitario();
        }
        
        if (statusVO.getValorAprovado() < valorTotalPedidos) {
          statusVO.setStatus(StatusType.APROVADO_VALOR_A_MENOR);
        } else if (statusVO.getItensAprovados() < totalQtd) {
          statusVO.setStatus(StatusType.APROVADO_QTD_A_MENOR);
        } else if (statusVO.getItensAprovados() == totalQtd && statusVO.getValorAprovado() == valorTotalPedidos
            && (statusVO.getItensAprovados() > 0 && statusVO.getItensAprovados() > 0)) {
          statusVO.setStatus(StatusType.APROVADO);
        } else if (statusVO.getValorAprovado() > valorTotalPedidos) {
          statusVO.setStatus(StatusType.APROVADO_VALOR_A_MAIOR);
        } else if (statusVO.getItensAprovados() > totalQtd) {
          statusVO.setStatus(StatusType.APROVADO_QTD_A_MAIOR);
        } 
      } else {
        statusVO.getStatus().equals(StatusType.REPROVADO);
      }
    }
  }
  
}


