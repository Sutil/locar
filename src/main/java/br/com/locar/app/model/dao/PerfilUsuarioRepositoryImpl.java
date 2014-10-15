package br.com.locar.app.model.dao;

import static br.com.locar.app.login.seguranca.QPerfilUsuario.perfilUsuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.locar.app.bean.PerfilUsuarioBean;
import br.com.locar.app.login.seguranca.PerfilUsuario;

import com.mysema.query.jpa.impl.JPAQuery;

public class PerfilUsuarioRepositoryImpl implements
		PerfilUsuariorepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public PerfilUsuario salvar(PerfilUsuarioBean bean) {
		PerfilUsuario perfil = PerfilUsuario.newInstance(bean);
		validaSeExistePerfilComMesmoNome(perfil);
		return entityManager.merge(perfil);
	}

	private void validaSeExistePerfilComMesmoNome(PerfilUsuario perfil){
		JPAQuery query = new JPAQuery(entityManager);
		PerfilUsuario perfilPesquisado = query.from(perfilUsuario)
		.where(perfilUsuario.nome.equalsIgnoreCase(perfil.getNome())).singleResult(perfilUsuario);
		
		if(perfilPesquisado != null && !perfilPesquisado.getId().equals(perfil.getId())){
			throw new RuntimeException("Já existe um perfil com este nome.");
		}
	}
}
