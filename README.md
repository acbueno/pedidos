# Pedidos
Projeto Exemplo API Rest utlizando framework Spring Boot, H2.
Documentação da Api no Swagger.

1) Start projeto Spring

2) Acesso o endpoint http://localhost:8080/api/pedidos/

2.1) Crie Post:

{
      "itens": [
  {
    "descricao": "Item A",
    "precoUnitario": 10,
    "qtd": 8
  },
  {
    "descricao": "Item B",
    "precoUnitario": 5,
    "qtd": 2
  }
  ]
}

3) Acesse o endpoint http://localhost:8080/api/status

3.1) Crie um post 

{
  "status":"APROVADO",
  "itensAprovados": 8,
  "valorAprovado": 2,
  "idPedido":1
}

