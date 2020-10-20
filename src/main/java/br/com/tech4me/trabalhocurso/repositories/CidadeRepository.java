package br.com.tech4me.trabalhocurso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.tech4me.trabalhocurso.domain.Cidade;

@Repository
@EnableJpaRepositories
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
