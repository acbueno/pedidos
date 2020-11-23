package br.com.acbueno.pedidos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
  
  
  private static final long serialVersionUID = -8572770971833827955L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_item")
  private Long id;
  
  @Column(name = "descricao", nullable = false, length = 255)
  private String descricao;
  
  @Column(name = "precoUnitario", nullable = false, length = 10)
  private int precoUnitario;
  
  @Column(name = "qtd", nullable = false, length = 10)
  private int qtd;

}
