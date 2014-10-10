package br.com.locar.app.login.seguranca.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.locar.app.IntegrationTestConfig;
import br.com.locar.app.bean.UsuarioBean;
import br.com.locar.app.login.seguranca.Usuario;

public class UsuarioRepositoryIT extends IntegrationTestConfig{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	public void testNewUserHappyDay() {
		UsuarioBean bean = new UsuarioBean();
		bean.setLogin("new user");
		
		Usuario user = Usuario.newInstance(bean);
		Usuario saved = usuarioRepository.save(user);
		
		assertEquals("Usuario salvo deve ser igual ao criado", user, saved);
	}

}
