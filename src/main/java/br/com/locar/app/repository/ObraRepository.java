package br.com.locar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.model.Obra;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface ObraRepository extends JpaRepository<Obra, Long>, ListQueryDslPredicateExecutor<Obra>{

}
