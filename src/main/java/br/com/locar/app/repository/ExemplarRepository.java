package br.com.locar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.model.Exemplar;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long>, ListQueryDslPredicateExecutor<Exemplar> {

}
