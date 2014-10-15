package br.com.locar.app.login.seguranca.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.locar.app.AmbienteComPerfilELojaExistente;
import br.com.locar.app.IntegrationTestConfig;
import br.com.locar.app.bean.UsuarioBean;
import br.com.locar.app.login.seguranca.PerfilUsuario;
import br.com.locar.app.login.seguranca.Usuario;
import br.com.locar.app.model.dao.LojaRepository;
import br.com.locar.app.model.dao.PerfilUsuarioRepository;
import br.com.locar.app.model.entity.Loja;

public class UsuarioRepositoryIT extends IntegrationTestConfig{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AmbienteComPerfilELojaExistente ambiente;
	
	@Autowired
	private PerfilUsuarioRepository repositoryPerfil;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Before
	public void before(){
		ambiente.setUp();
	}
	
	@After
	public void after(){
		usuarioRepository.deleteAll();
		ambiente.turnDown();
	}

	@Test
	public void testNewUserHappyDay() {
		List<Loja> lojas = lojaRepository.findAll();
		PerfilUsuario perfilUsuario = repositoryPerfil.findAll().get(0);
		
		UsuarioBean bean = new UsuarioBean();
		bean.setLogin("new user");
		bean.setPerfil(perfilUsuario);
		bean.setLojas(lojas);
		Usuario saved = usuarioRepository.salvar(bean);
		
		assertEquals("Usuario salvo deve ser igual ao criado", bean.getLogin(), saved.getLogin());
	}
	
	@Test(expected = RuntimeException.class)
	public void criaDoisUsuariosComMesmoNome_erro(){
		List<Loja> lojas = lojaRepository.findAll();
		PerfilUsuario perfilUsuario = repositoryPerfil.findAll().get(0);
		UsuarioBean bean = new UsuarioBean();
		bean.setLogin("new user");
		bean.setPerfil(perfilUsuario);
		bean.setLojas(lojas);
		
		UsuarioBean bean2 = new UsuarioBean();
		bean2.setLogin("new user");
		bean2.setPerfil(perfilUsuario);
		bean2.setLojas(lojas);
		
		usuarioRepository.salvar(bean);
		usuarioRepository.salvar(bean2);
	}
	
	@Test(expected = RuntimeException.class)
	public void criaUsuarioSemLojaVinculada_erro(){
		PerfilUsuario perfilUsuario = repositoryPerfil.findAll().get(0);
		UsuarioBean bean = new UsuarioBean();
		bean.setLogin("new user");
		bean.setPerfil(perfilUsuario);
		usuarioRepository.salvar(bean);
	}
	

}
