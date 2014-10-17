package br.com.locar.app.model.dao;

import static br.com.locar.app.model.entity.QCategoria.categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.locar.app.bean.CategoriaBean;
import br.com.locar.app.bean.CategoriaFiltro;
import br.com.locar.app.model.entity.Categoria;
import br.com.locar.app.model.entity.Status;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.BooleanExpression;

public class CategoriaRepositoryImpl implements CategoriaRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void desativar(Categoria categoria) {
		categoria.desativar();
		entityManager.merge(categoria);
	}

	@Override
	public void salvar(CategoriaBean bean) {
		Categoria categoria = Categoria.newInstance(bean);
		salvar(categoria);
	}

	@Override
	public Categoria salvar(Categoria categoriaParaSalvar) {
		JPAQuery query = new JPAQuery(entityManager);
		query.from(categoria);
		BooleanExpression whereArgs = categoria.nome.equalsIgnoreCase(categoriaParaSalvar
						.getNome());
		if(categoriaParaSalvar.getId() != null){
			whereArgs.and(categoria.id.ne(categoriaParaSalvar.getId()));
		}
		query.where(whereArgs);
		
		List<Categoria> list = query.list(categoria);
		if (!list.isEmpty()) {
			throw new RuntimeException("Já existe uma categoria com este nome.");
		}
		return entityManager.merge(categoriaParaSalvar);
	}

	@Override
	public List<Categoria> pesquisar(CategoriaFiltro filtro) {
		JPAQuery query = new JPAQuery(entityManager);
		query.from(categoria);
		query.where(filtro.toPredicate());
		return query.list(categoria);
	}
	
	@Override
	public List<Categoria> findAllActives() {
		return new JPAQuery(entityManager)
		.from(categoria)
		.where(categoria.status.eq(Status.ATIVO))
		.list(categoria);
	}

}
