package br.com.locar.app.model.dao;

import java.util.List;

import br.com.locar.app.bean.ClienteFiltro;
import br.com.locar.app.model.entity.Cliente;

public interface ClienteRepositoryCustom {
	
	
	Cliente salvar(Cliente cliente);
	Cliente inativar(Cliente cliente);
	Cliente ativar(Cliente cliente);
	List<Cliente> pesquisar(ClienteFiltro filtro);

}
