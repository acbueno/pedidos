package br.com.acbueno.pedidos.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acbueno.pedidos.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
