package br.com.acbueno.pedidos.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.acbueno.pedidos.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StatusOutpuDTO implements Serializable {

  private static final long serialVersionUID = 4644820854774941804L;
  
  @JsonProperty("pedido")
  private Long idPedido;
  
  @JsonProperty("status")
  private StatusType statusType;

}
