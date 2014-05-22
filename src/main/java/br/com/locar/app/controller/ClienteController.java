package br.com.locar.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import br.com.locar.app.model.entity.Cliente;

import com.google.common.collect.Lists;

@Controller
public class ClienteController {
	
	public List<Cliente> getClientes(){
		List<Cliente> clientes = Lists.newArrayList();
		Cliente cliente = new Cliente("Antonio", "98765421388", "Avenida Colombo", "(44)9889-9888");
		clientes.add(cliente);
		clientes.add(cliente);
		clientes.add(cliente);
		clientes.add(cliente);
		clientes.add(cliente);
		return clientes;
	}

}
