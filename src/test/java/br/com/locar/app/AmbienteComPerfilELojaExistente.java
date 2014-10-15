package br.com.locar.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.locar.app.bean.LojaBean;
import br.com.locar.app.bean.PerfilUsuarioBean;
import br.com.locar.app.login.seguranca.Permissao;
import br.com.locar.app.model.dao.LojaRepository;
import br.com.locar.app.model.dao.PerfilUsuarioRepository;

@Component
public class AmbienteComPerfilELojaExistente {
	
	@Autowired
	PerfilUsuarioRepository repositoryPerfil;
	
	@Autowired
	LojaRepository repositoryLoja;
	
	public void setUp(){
		criaPerfil();
		criaLoja();
	}

	private void criaLoja() {
		LojaBean beanLoja = new LojaBean();
		beanLoja.setNome("Nova loja");
		repositoryLoja.salvar(beanLoja);
	}

	private void criaPerfil() {
		List<Permissao> permissoes = Arrays.asList(Permissao.values());
		PerfilUsuarioBean bean = new PerfilUsuarioBean(permissoes);
		bean.setNome("new perfil");
		bean.setPermissoes(permissoes);
		repositoryPerfil.salvar(bean);
	}
	
	public void turnDown(){
		repositoryPerfil.deleteAll();
		repositoryLoja.deleteAll();
	}
	
	

}
