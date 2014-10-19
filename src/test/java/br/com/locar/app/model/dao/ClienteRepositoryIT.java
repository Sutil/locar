package br.com.locar.app.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.locar.app.IntegrationTestConfig;
import br.com.locar.app.model.entity.Cliente;

public class ClienteRepositoryIT extends IntegrationTestConfig {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	public void testSalvar() {
		Cliente cliente = new Cliente("Edu", "1234", "Rua salvador", "3030-4040");
		Cliente clienteSalvo = clienteRepository.salvar(cliente);
		
		assertNotNull("Id do cliente nao pode ser nulo.",clienteSalvo.getId());
		assertEquals("cliente salvo deve ser igual ao cliente criado.", cliente, clienteSalvo);
	}

	@Test
	public void testInativar() {
		Cliente cliente = new Cliente("Edu", "1234", "Rua salvador", "3030-4040");
		Cliente clienteSalvo = clienteRepository.salvar(cliente);
		
		assertTrue("cliente deve estar ativo", clienteSalvo.isAtivo());
		
		Cliente clienteInativo = clienteRepository.inativar(clienteSalvo);
		
		assertFalse("cliente deve estar inativo", clienteInativo.isAtivo());
	}

	@Test
	public void testAtivar() {
		Cliente cliente = new Cliente("Edu", "1234", "Rua salvador", "3030-4040");
		Cliente clienteSalvo = clienteRepository.salvar(cliente);
		
		assertTrue("cliente deve estar ativo", clienteSalvo.isAtivo());
		
		Cliente clienteInativo = clienteRepository.inativar(clienteSalvo);
		
		assertFalse("cliente deve estar inativo", clienteInativo.isAtivo());
		
		Cliente clienteAtivo = clienteRepository.ativar(clienteInativo);
		
		assertTrue("cliente deve estar ativo novamente.", clienteAtivo.isAtivo());
	}



}
