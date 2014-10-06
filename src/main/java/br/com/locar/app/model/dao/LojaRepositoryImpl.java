package br.com.locar.app.model.dao;

import static br.com.locar.app.model.entity.QLoja.loja;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.locar.app.bean.LojaBean;
import br.com.locar.app.bean.LojaFiltro;
import br.com.locar.app.model.entity.Loja;

import com.mysema.query.jpa.impl.JPAQuery;

public class LojaRepositoryImpl implements LojaRepositoryCustom{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Loja salvar(LojaBean bean) {
		Loja loja = Loja.newInstance(bean);
		return entityManager.merge(loja);
	}

	@Override
	public void desativar(Loja loja) {
		loja.desativar();
		entityManager.merge(loja);
	}

	@Override
	public List<Loja> pesquisar(LojaFiltro filtro) {
		JPAQuery query = new JPAQuery(entityManager);
		return query.from(loja).where(filtro.toPredicate()).list(loja);
	}

}
