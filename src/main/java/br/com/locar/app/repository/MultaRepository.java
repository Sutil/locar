package br.com.locar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.model.Multa;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface MultaRepository extends JpaRepository<Multa, Long>, ListQueryDslPredicateExecutor<Multa> {

}
