package br.com.locar.app.model.dao;

import static br.com.locar.app.model.entity.QLoja.loja;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.locar.app.bean.LojaBean;
import br.com.locar.app.bean.LojaFiltro;
import br.com.locar.app.model.entity.Loja;

import com.mysema.query.jpa.impl.JPAQuery;

public class LojaRepositoryImpl implements LojaRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Loja salvar(LojaBean bean) {
		verificaSeExisteLojaComMesmoNome(bean);
		Loja loja = Loja.newInstance(bean);
		return entityManager.merge(loja);
	}

	private void verificaSeExisteLojaComMesmoNome(LojaBean bean) {
		JPAQuery query = new JPAQuery(entityManager);
		List<Loja> lojasComMesmoNome = query.from(loja)
				.where(loja.nome.eq(bean.getNome())).list(loja);
		if (!lojasComMesmoNome.isEmpty()) {
			Loja lojaConsultada = lojasComMesmoNome.get(0);
			if (lojaConsultada.getNome().equals(bean.getNome())
					&& !lojaConsultada.getId().equals(bean.getId()))
				throw new RuntimeException("Já existe uma loja com este nome.");
		}
	}

	@Override
	public void desativar(Loja loja) {
		loja.desativar();
		entityManager.merge(loja);
	}
	
	@Override
	public void ativar(Loja loja) {
		loja.ativar();
		entityManager.merge(loja);
	}

	@Override
	public List<Loja> pesquisar(LojaFiltro filtro) {
		JPAQuery query = new JPAQuery(entityManager);
		return query.from(loja).where(filtro.toPredicate()).list(loja);
	}

	
	

}
