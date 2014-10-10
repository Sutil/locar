package br.com.locar.app.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.locar.app.bean.VeiculoBean;
import br.com.locar.app.model.entity.Veiculo;

public class VeiculoRepositoryImpl implements VeiculoRepositoryCustom{
	
	@PersistenceContext
	private EntityManager entitymanager;

	@Override
	public Veiculo salvar(VeiculoBean bean) {
		return entitymanager.merge(Veiculo.newInstance(bean));
	}

	@Override
	public void inativar() {
		//TODO inativar
	}

}
