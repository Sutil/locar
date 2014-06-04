package br.com.locar.app.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.locar.app.model.entity.Cliente;
import br.com.locar.app.model.entity.Preposto;

public class ClienteDao {
	
	private static ClienteDao instance;
	private List<Cliente> lista = new ArrayList<Cliente>();
 	
	public static ClienteDao getInstance() {
		if(instance == null){
			instance = new ClienteDao();
		}
		return instance;
	}
	
	
	ClienteDao(){
		Cliente cliente = new Cliente("Eduardo", "999999999-99", "Avenida Colombo, 488",  "(44)6585-6587");
		Preposto preposto = new Preposto("Eduardo Sutil de Oliveira", "4568745", "10/04/2017");
		cliente.addPreposto(preposto);
		preposto.setCliente(cliente);
		
		lista.add(cliente);
		lista.add(new Cliente("Antnio", "999999999-99", "Avenida Colombo, 488",  "(44)6585-6587"));
		lista.add(new Cliente("Joao", "999999999-99", "Avenida Colombo, 488",  "(44)6585-6587"));
		lista.add(new Cliente("Alex", "999999999-99", "Avenida Colombo, 488",  "(44)6585-6587"));
		lista.add(new Cliente("Felipe", "999999999-99", "Avenida Colombo, 488",  "(44)6585-6587"));
		lista.add(new Cliente("Marcos", "999999999-99", "Avenida Colombo, 488",  "(44)6585-6587"));
		lista.add(new Cliente("Ronaldo", "999999999-99", "Avenida Colombo, 488",  "(44)6585-6587"));
	}
	
	
	public List<Cliente> getLista() {
		return lista;
	}
	
	public void salvar(Cliente cliente){
		if(!lista.contains(cliente)){
			lista.add(cliente);
		}
	}

}
