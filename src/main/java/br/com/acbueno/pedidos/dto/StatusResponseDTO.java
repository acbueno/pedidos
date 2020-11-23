package br.com.acbueno.pedidos.dto;

import java.io.Serializable;

import br.com.acbueno.pedidos.data.vo.StatusVO;
import br.com.acbueno.pedidos.entity.Status;
import br.com.acbueno.pedidos.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatusResponseDTO implements Serializable {
  
  private static final long serialVersionUID = 3061020876453078537L;
  
  private Long pedido;
  
  private StatusType status;
  
  public static StatusResponseDTO convertEntityToDTO(StatusVO statusVO) {
    return new StatusResponseDTO(statusVO.getIdPedido(), statusVO.getStatus());
  }

}
