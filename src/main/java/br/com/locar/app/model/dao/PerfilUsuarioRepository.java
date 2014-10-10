package br.com.locar.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.login.seguranca.PerfilUsuario;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface PerfilUsuarioRepository extends
		JpaRepository<PerfilUsuario, Long>,
		ListQueryDslPredicateExecutor<PerfilUsuario>,
		PerfilUsuariorepositoryCustom {

}
