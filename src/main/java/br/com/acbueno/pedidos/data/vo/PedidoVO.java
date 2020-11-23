package br.com.acbueno.pedidos.data.vo;

import java.io.Serializable;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.acbueno.pedidos.entity.Item;
import br.com.acbueno.pedidos.entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder( {"id" ,"itens"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PedidoVO extends RepresentationModel<PedidoVO> implements Serializable  {
  
  private static final long serialVersionUID = 5966990254459533704L;
  
  @JsonProperty("id")
  private Long id;
  
  @JsonProperty("itens")
  private List<Item> itens;
  
  public static PedidoVO create(Pedido pedido) {
    return new ModelMapper().map(pedido, PedidoVO.class);
  }

}
