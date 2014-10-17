package br.com.locar.app.controller;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.locar.app.login.seguranca.Usuario;
import br.com.locar.app.login.seguranca.repository.UsuarioRepository;
import br.com.locar.app.model.dao.LojaRepository;
import br.com.locar.app.model.entity.Loja;

@Controller
public class LocarController {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired UsuarioRepository usuarioRepository;
	
	
	protected void message(Severity severity, String message, String detalhes){
		getCurrentInstance().addMessage(null, new FacesMessage(severity, message, detalhes));
	}
	
	
	/**
	 * 
	 * @return lojas vinculadas ao usuario logado
	 */
	public List<Loja> getLojas(){
		Usuario usuarioLogado = getUsuarioLogado();
		if(usuarioLogado == null)
			return lojaRepository.findAll();
		return usuarioLogado.getLojas();
	}
	
	private Usuario getUsuarioLogado(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String name = request.getUserPrincipal().getName();
		return usuarioRepository.findByName(name);
	}

}
