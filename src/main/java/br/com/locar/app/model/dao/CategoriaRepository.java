package br.com.locar.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.model.entity.Categoria;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>, 
ListQueryDslPredicateExecutor<Categoria>, CategoriaRepositoryCustom {

	

}
