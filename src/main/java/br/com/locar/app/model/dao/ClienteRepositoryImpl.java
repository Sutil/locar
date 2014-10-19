package br.com.locar.app.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.locar.app.bean.ClienteFiltro;
import br.com.locar.app.model.entity.Cliente;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Cliente salvar(Cliente cliente) {
		return entityManager.merge(cliente);
	}

	@Override
	public Cliente inativar(Cliente cliente) {
		cliente.desativar();
		return entityManager.merge(cliente);
	}

	@Override
	public Cliente ativar(Cliente cliente) {
		cliente.ativar();
		return entityManager.merge(cliente);
	}

	@Override
	public List<Cliente> pesquisar(ClienteFiltro filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
