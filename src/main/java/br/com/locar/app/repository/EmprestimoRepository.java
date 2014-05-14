package br.com.locar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.model.Emprestimo;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>, ListQueryDslPredicateExecutor<Emprestimo> {

}
