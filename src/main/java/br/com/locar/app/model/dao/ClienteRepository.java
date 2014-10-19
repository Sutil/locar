package br.com.locar.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.model.entity.Cliente;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface ClienteRepository extends JpaRepository<Cliente, Long>,
		ListQueryDslPredicateExecutor<Cliente>, ClienteRepositoryCustom {

}
