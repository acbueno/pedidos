package br.com.acbueno.pedidos.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.acbueno.pedidos.entity.Status;
import br.com.acbueno.pedidos.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@JsonPropertyOrder({"id", "itensAprovado", "valorAprovado", "idPedido"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StatusVO implements Serializable {

  private static final long serialVersionUID = 3107574877247384688L;
  
  @JsonProperty("id")
  private Long id;
  
  @JsonProperty("itensAprovados")
  private int itensAprovados;
  
  @JsonProperty("valorAprovado")
  private int valorAprovado;
  
  @JsonProperty("idPedido")
  private long idPedido;
  
  @JsonProperty("status")
  private StatusType status;
 
  public static StatusVO create(Status status) {
    return new ModelMapper().map(status, StatusVO.class);
  } 


}
