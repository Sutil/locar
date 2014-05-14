package br.com.locar.app.login.seguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locar.app.login.seguranca.Usuario;
import br.com.locar.repository.ListQueryDslPredicateExecutor;

public interface UsuarioRepository extends JpaRepository<Usuario , Long>, ListQueryDslPredicateExecutor<Usuario> {

}
