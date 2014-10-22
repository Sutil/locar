package br.com.locar.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.model.entity.Reserva;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface ReservaRepository extends JpaRepository<Reserva, Long>, 
ListQueryDslPredicateExecutor<Reserva>{

}
