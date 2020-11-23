package br.com.acbueno.pedidos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.modelmapper.ModelMapper;
import br.com.acbueno.pedidos.data.vo.StatusVO;
import br.com.acbueno.pedidos.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "status")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Status implements Serializable {
  
  private static final long serialVersionUID = 676356790856962312L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_status_pedido")
  private Long id;
  
  @Column(name = "item_aprovados")
  private int itensAprovados;
  
  @Column(name = "valor_aprovado")
  private int valorAprovado;
  
  @Column(name = "id_pedido")
  private long idPedido;
  
  @Enumerated(EnumType.STRING)
  private  StatusType status;
  
  public static Status create(StatusVO statusVO) {
    return new ModelMapper().map(statusVO, Status.class);
  }
  
}
