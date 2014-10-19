package br.com.locar.app.controller;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.bean.ClienteFiltro;
import br.com.locar.app.model.dao.ClienteRepository;
import br.com.locar.app.model.entity.Cliente;

@Controller
public class ClienteController extends LocarController{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteFiltro newFiltro(){
		return new ClienteFiltro();
	}

	public Cliente novo() {
		return new Cliente();
	}
	
	@Transactional
	public void salvar(Cliente cliente){
		try{
			clienteRepository.salvar(cliente);
			message(SEVERITY_INFO, "Cliente salvo com sucesso.", "");
		}
		catch(Exception e){
			message(SEVERITY_ERROR, "Erro ao salvar", e.getMessage());
		}
	}
	
	@Transactional
	public void inativar(Cliente cliente){
		try{
			clienteRepository.inativar(cliente);
			message(SEVERITY_INFO, "Cliente excluído com sucesso.", "");
		}
		catch(Exception e){
			message(SEVERITY_ERROR, "Erro ao excluir.", e.getMessage());
		}
	}
	
	@Transactional
	public void ativar(Cliente cliente){
		try{
			clienteRepository.ativar(cliente);
			message(SEVERITY_INFO, "Cliente reativado com sucesso.", "");
		}
		catch(Exception e){
			message(SEVERITY_ERROR, "Erro ao reativar", e.getMessage());
		}
	}

	

	
}
