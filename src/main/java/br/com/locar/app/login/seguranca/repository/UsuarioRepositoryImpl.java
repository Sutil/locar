package br.com.locar.app.login.seguranca.repository;

import static br.com.locar.app.login.seguranca.QUsuario.usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.locar.app.bean.AlteracaoDeSenhaBean;
import br.com.locar.app.login.seguranca.Usuario;

import com.mysema.query.jpa.impl.JPAQuery;

public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Usuario findByName(String nome) {
		JPAQuery query = new JPAQuery(entityManager);
		return query.from(usuario).where(usuario.login.eq(nome)).singleResult(usuario);
	}
	
	@Override
	public void alteraSenha(AlteracaoDeSenhaBean bean) {
		bean.alteraSenha();
		entityManager.merge(bean.getUsuario());
	}
	
	

}
