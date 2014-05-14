package br.com.locar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.model.Autor;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface AutorRepository extends JpaRepository<Autor, Long>, ListQueryDslPredicateExecutor<Autor> {

}
