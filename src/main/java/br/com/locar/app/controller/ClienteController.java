package br.com.locar.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import br.com.locar.app.model.entity.Cliente;
import br.com.locar.app.model.entity.Preposto;
import br.com.locar.app.repository.ClienteDao;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

@Controller
public class ClienteController {

	public List<Cliente> getClientes() {
		List<Cliente> clientes = Lists.newArrayList();
		Cliente cliente = new Cliente("Antonio", "98765421388",
				"Avenida Colombo", "(44)9889-9888");
		clientes.add(cliente);
		clientes.add(cliente);
		clientes.add(cliente);
		clientes.add(cliente);
		clientes.add(cliente);
		return clientes;
	}

	

	public Cliente novo() {
		return new Cliente("", "", "", "");
	}

	public Preposto novoPreposto() {
		return new Preposto();
	}

	public List<Preposto> autocompletePreposto(String value) {
		System.out.println(value);
		List<Cliente> lista = ClienteDao.getInstance().getLista();
		List<Preposto> prepostos = Lists.newArrayList();
		List<Preposto> retorno = Lists.newArrayList();
		for (Cliente c : lista) {
			prepostos.addAll(c.getPrepostos());
		}
		if (!Strings.isNullOrEmpty(value)) {
			for (Preposto p : prepostos) {
				if (p.getNome().toUpperCase().contains(value.toUpperCase())) {
					retorno.add(p);
				}
			}
		}
		return retorno;
	}
}
