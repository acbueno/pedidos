package br.com.acbueno.pedidos.enums;

public enum StatusType {
  APROVADO, APROVADO_VALOR_A_MENOR, 
  APROVADO_VALOR_A_MAIOR, 
  APROVADO_QTD_A_MAIOR, 
  APROVADO_QTD_A_MENOR,
  REPROVADO, 
  CODIGO_PEDIDO_INVALIDO;
  
  @Override
  public String toString() {
      return String.valueOf(hashCode());
  }
}
