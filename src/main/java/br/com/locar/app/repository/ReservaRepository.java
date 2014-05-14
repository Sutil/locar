package br.com.locar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.model.Reserva;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface ReservaRepository extends JpaRepository<Reserva, Long>, ListQueryDslPredicateExecutor<Reserva>{

}
