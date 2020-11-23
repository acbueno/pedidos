package br.com.acbueno.pedidos.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.acbueno.pedidos.data.vo.PedidoVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable {

  private static final long serialVersionUID = -5416245356894819860L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_pedido")
  private Long id;
   
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name="id_pedido")
  //@OneToMany(mappedBy = "pedido",targetEntity = Item.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Item> itens;

  public static Pedido create(PedidoVO pedidoVO) {
    return new ModelMapper().map(pedidoVO, Pedido.class);
  }
  
}
