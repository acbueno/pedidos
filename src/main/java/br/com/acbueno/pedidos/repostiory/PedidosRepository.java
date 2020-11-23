package br.com.acbueno.pedidos.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.acbueno.pedidos.entity.Pedido;

@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Long> {

}
