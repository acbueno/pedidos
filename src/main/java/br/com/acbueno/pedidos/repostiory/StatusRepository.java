package br.com.acbueno.pedidos.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acbueno.pedidos.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
