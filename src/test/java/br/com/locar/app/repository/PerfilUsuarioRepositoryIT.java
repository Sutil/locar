package br.com.locar.app.repository;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.IntegrationTestConfig;
import br.com.locar.app.bean.PerfilUsuarioBean;
import br.com.locar.app.login.seguranca.PerfilUsuario;
import br.com.locar.app.login.seguranca.Permissao;
import br.com.locar.app.model.dao.PerfilUsuarioRepository;

public class PerfilUsuarioRepositoryIT extends IntegrationTestConfig{
	
	@Autowired
	private PerfilUsuarioRepository repository;
	
	@After
	public void after(){
		repository.deleteAll();
	}

	@Test
	public void testNewPerfilHappyDay() {
		List<Permissao> permissoes = Arrays.asList(Permissao.values());
		PerfilUsuarioBean bean = new PerfilUsuarioBean(permissoes);
		bean.setNome("new perfil");
		bean.setPermissoes(permissoes);
		PerfilUsuario saved = repository.salvar(bean);
		
		assertEquals("Perfil salvo deve ser igual ao criado", bean.getNome(), saved.getNome());
	}
	
	@Test(expected = RuntimeException.class)
	@Transactional
	public void criaDoisPermissoesComMesmoNome_erro(){
		List<Permissao> permissoes = Arrays.asList(Permissao.values());
		PerfilUsuarioBean bean1 = new PerfilUsuarioBean(permissoes);
		bean1.setNome("perfil 1");
		bean1.setPermissoes(permissoes);
		
		PerfilUsuarioBean bean2 = new PerfilUsuarioBean(permissoes);
		bean2.setNome("perfil 1");
		bean2.setPermissoes(permissoes);
	
		
		repository.salvar(bean1);
		repository.salvar(bean2);
	}

}
