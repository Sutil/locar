package br.com.locar.app.model.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;

import br.com.locar.app.model.entity.Categoria;
import br.com.locar.app.model.entity.QCategoria;

public class CategoriaRepositoryImpl implements CategoriaRepositoryCustom{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Categoria> autocomplete(String value) {
		JPAQuery query = new JPAQuery(entityManager);
		query.from(QCategoria.categoria);
		if(!Strings.isNullOrEmpty(value)){
			BooleanBuilder builder = new BooleanBuilder();
			builder.and(QCategoria.categoria.nome.containsIgnoreCase(value));
			query.where(builder);
		}
		return query.orderBy(QCategoria.categoria.nome.asc()).list(QCategoria.categoria);
	}
	
	@Override
	public void desativar(Categoria categoria) {
		try{
			categoria.desativar();
			entityManager.merge(categoria);
		}
		catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao desativar categoria.", e.getMessage()));
		}
		
	}
	
	

}
