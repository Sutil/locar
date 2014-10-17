package br.com.locar.app.model.dao;

import static br.com.locar.app.model.entity.QVeiculo.veiculo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.locar.app.bean.VeiculoBean;
import br.com.locar.app.bean.VeiculoFiltro;
import br.com.locar.app.model.entity.Veiculo;

import com.mysema.query.jpa.impl.JPAQuery;

public class VeiculoRepositoryImpl implements VeiculoRepositoryCustom{
	
	@PersistenceContext
	private EntityManager entitymanager;

	@Override
	public Veiculo salvar(VeiculoBean bean) {
		return entitymanager.merge(Veiculo.newInstance(bean));
	}

	@Override
	public Veiculo inativar(Veiculo veiculo) {
		veiculo.desativar();
		return entitymanager.merge(veiculo);
	}
	
	@Override
	public List<Veiculo> pesquisar(VeiculoFiltro filtro) {
		JPAQuery query = new JPAQuery(entitymanager);
		return query.from(veiculo).where(filtro.toPredicate()).list(veiculo);
	}

}
