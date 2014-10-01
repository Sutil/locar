package br.com.locar.app.model.dao;

import static br.com.locar.app.model.entity.QCategoria.categoria;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.bean.CategoriaBean;
import br.com.locar.app.bean.CategoriaFiltro;
import br.com.locar.app.model.entity.Categoria;
import br.com.locar.app.model.entity.QCategoria;

import com.mysema.query.jpa.impl.JPAQuery;

public class CategoriaRepositoryImpl implements CategoriaRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	public void desativar(Categoria categoria) {
		try {
			categoria.desativar();
			entityManager.merge(categoria);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Categoria desativada.", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao desativar categoria.", e.getMessage()));
		}
	}

	@Override
	public void salvar(CategoriaBean bean) {
		try {
			Categoria categoria = Categoria.newIntance(bean);
			salvar(categoria);
			FacesContext.getCurrentInstance().addMessage(
					"",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Salvo com sucesso", ""));
		} 
		catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					"",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao salvar", e.getMessage()));
		}
	}
	
	@Override
	@Transactional
	public Categoria salvar(Categoria categoria) {
		JPAQuery query = new JPAQuery(entityManager);
		query.from(QCategoria.categoria).where(QCategoria.categoria.nome.equalsIgnoreCase(categoria.getNome()));
		List<Categoria> list = query.list(QCategoria.categoria);
		if(!list.isEmpty()){
			throw new RuntimeException("Já existe uma categoria com este nome.");
		}
		return entityManager.merge(categoria);
	}

	@Override
	public List<Categoria> pesquisar(CategoriaFiltro filtro) {
		JPAQuery query = new JPAQuery(entityManager);
		query.from(categoria);
		query.where(filtro.toPredicate());
		return query.list(categoria);
	}

}
