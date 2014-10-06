package br.com.locar.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.model.entity.Loja;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface LojaRepository extends JpaRepository<Loja, Long>, ListQueryDslPredicateExecutor<Loja>, LojaRepositoryCustom {

}
