package br.com.locar.app.login.seguranca.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.bean.AlteracaoDeSenhaBean;
import br.com.locar.app.login.seguranca.Usuario;
import br.com.locar.config.root.SteConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SteConfig.class })
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class AlteracaoDeSenhaIT {
	
	private Usuario usuario;
	
	@Autowired
	private UsuarioRepository repository;
	
	@Before
	public void before(){
		usuario = Usuario.newUsuario("Teste");
		repository.save(usuario);
	}
	
	@After
	public void after(){
		repository.deleteAll();
	}

	@Test
	public void testAlteracaoDeSenha() {
		Assert.assertNotNull(usuario);
		Assert.assertEquals("senha inicial deve ser '123'", "123", usuario.getSenha());
		
		AlteracaoDeSenhaBean bean = criaAlteracaoDeSenhaBean(usuario, "123", "12345", "12345");
		repository.alteraSenha(bean);
		
		usuario = repository.findByName(usuario.getLogin());
		
		Assert.assertEquals("Nova senha deveria ser '12345'", "12345", usuario.getSenha());
	}

	
	@Test(expected = RuntimeException.class)
	public void testaAlteracaoDeSenhaInformandoSenhaAtualInvalida_Erro(){
		AlteracaoDeSenhaBean bean = criaAlteracaoDeSenhaBean(usuario, "senhainvalida", "13245", "12345");
		repository.alteraSenha(bean);
	}
	
	
	@Test(expected = RuntimeException.class)
	public void testaAlteracaoDeSenhaInformandoSenhaAtualNulo_Erro(){
		AlteracaoDeSenhaBean bean = criaAlteracaoDeSenhaBean(usuario, null, "12345", "12345");
		repository.alteraSenha(bean);
	}
	
	@Test(expected = RuntimeException.class)
	public void testaAlteracaoDeSenhaInformandoNovaSenhaNulo_Erro(){
		AlteracaoDeSenhaBean bean = criaAlteracaoDeSenhaBean(usuario, "123", null, "12345");
		repository.alteraSenha(bean);
	}
	
	@Test(expected = RuntimeException.class)
	public void testaAlteracaoDeSenhaInformandoNovaSenhaComMenosDeCincoCaracteres_Erro(){
		AlteracaoDeSenhaBean bean = criaAlteracaoDeSenhaBean(usuario, "123", "1234", "1234");
		repository.alteraSenha(bean);
	}
	
	@Test(expected = RuntimeException.class)
	public void testaAlteracaoDeSenhaInformandoConfirmacaoDeSenhaInvalida_Erro(){
		AlteracaoDeSenhaBean bean = criaAlteracaoDeSenhaBean(usuario, "123", "novaSenha", "confirmacaoInvalida");
		repository.alteraSenha(bean);
	}

	private AlteracaoDeSenhaBean criaAlteracaoDeSenhaBean(Usuario user, String senhaAtual,
			String novaSenha, String confirmacaoNovaSenha) {
		AlteracaoDeSenhaBean bean = new AlteracaoDeSenhaBean(user);
		bean.setSenhaAtual(senhaAtual);
		bean.setNovaSenha(novaSenha);
		bean.setConfirmacaoNovaSenha(confirmacaoNovaSenha);
		return bean;
	}

}
