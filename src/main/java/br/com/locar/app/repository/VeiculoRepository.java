package br.com.locar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.model.entity.Veiculo;
import br.com.locar.repository.ListQueryDslPredicateExecutor;


public interface VeiculoRepository extends JpaRepository<Veiculo, Long>, ListQueryDslPredicateExecutor<Veiculo>, VeiculoRepositoryCustom {
	

}
