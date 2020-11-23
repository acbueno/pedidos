package br.com.acbueno.pedidos.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.acbueno.pedidos.entity.Status;
import br.com.acbueno.pedidos.enums.StatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "StatusVO")
public class StatusVO implements Serializable {

  private static final long serialVersionUID = 3107574877247384688L;
  
  @JsonProperty("id")
  private Long id;
  
  @ApiModelProperty(value = "itensAprovados", required = true)
  @JsonProperty("itensAprovados")
  private int itensAprovados;
  
  @ApiModelProperty(value = "valorAprovado", required = true)
  @JsonProperty("valorAprovado")
  private int valorAprovado;
  
  
  @ApiModelProperty(value = "idPedido", required = true)
  @JsonProperty("idPedido")
  private long idPedido;
  
  @ApiModelProperty(value = "status", required = true)
  @JsonProperty("status")
  private StatusType status;
 
  public static StatusVO create(Status status) {
    return new ModelMapper().map(status, StatusVO.class);
  } 


}
