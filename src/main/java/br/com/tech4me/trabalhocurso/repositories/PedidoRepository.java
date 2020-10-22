package br.com.tech4me.trabalhocurso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.trabalhocurso.domain.Pedido;

@Repository

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
