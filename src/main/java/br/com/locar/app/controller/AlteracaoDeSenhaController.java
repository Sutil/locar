package br.com.locar.app.controller;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.context.FacesContext.getCurrentInstance;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.bean.AlteracaoDeSenhaBean;
import br.com.locar.app.login.seguranca.Usuario;
import br.com.locar.app.login.seguranca.repository.UsuarioRepository;

@Controller
public class AlteracaoDeSenhaController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;


	public AlteracaoDeSenhaBean newBean() {
		String nomeUsuarioLogado = ((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest()).getUserPrincipal()
				.getName();
		Usuario usuario = usuarioRepository.findByName(nomeUsuarioLogado);
		return new AlteracaoDeSenhaBean(usuario);
	}
	
	@Transactional
	public void salvar(AlteracaoDeSenhaBean bean){
		try{
			usuarioRepository.alteraSenha(bean);
			mensagem(FacesMessage.SEVERITY_INFO, "Sucesso!", "Sua senha foi alterada!");
		}
		catch(Exception ex){
			mensagem(SEVERITY_ERROR, "Erro ao alterar senha.", ex.getMessage());
		}
	}

	private void mensagem(Severity severity, String sumary, String message) {
		getCurrentInstance().addMessage(null, new FacesMessage(severity, sumary , message));
	}


}
