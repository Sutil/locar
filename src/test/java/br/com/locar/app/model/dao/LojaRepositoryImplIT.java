package br.com.locar.app.model.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.bean.LojaBean;
import br.com.locar.app.model.entity.Loja;
import br.com.locar.config.root.SteConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SteConfig.class })
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class LojaRepositoryImplIT {

	@Autowired
	private LojaRepository repository;

	@After
	public void after() {
		repository.deleteAll();
	}

	@Test
	public void testNovaLojaHappyDay() {
		LojaBean bean = new LojaBean();
		bean.setNome("Nova loja");
		Loja saved = repository.salvar(bean);

		assertNotNull("A loja salva não pode ser nula.", saved);
		assertNotNull("O id da loja salva não pode ser nulo", saved.getId());
		assertEquals("O nome da loja salva deve ser igual da loja criada",
				bean.getNome(), saved.getNome());
	}

	@Test(expected = RuntimeException.class)
	public void testNovaLojaInformandoNomeNulo_erro() {
		LojaBean bean = new LojaBean();
		bean.setNome(null);
		Loja.newInstance(bean);
	}

	@Test(expected = RuntimeException.class)
	public void testNovaLojaInformandoNomeVazio_erro() {
		LojaBean bean = new LojaBean();
		bean.setNome("");
		Loja.newInstance(bean);
	}

	@Test
	public void testaAlteracaoDeLoja() {
		LojaBean bean = new LojaBean();
		bean.setNome("Loja teste");

		Loja saved = repository.salvar(bean);

		assertNotNull("A loja salva não pode ser nula.", saved);
		assertNotNull("O id da loja salva não pode ser nulo", saved.getId());
		assertEquals("O nome da loja salva deve ser igual da loja criada",
				bean.getNome(), saved.getNome());
		
		LojaBean newBean = new LojaBean(saved);
		
		assertEquals("Nome do bean deve ser igual o nome da loja", saved.getNome(), newBean.getNome());
		assertEquals("Id do bean deve ser igual o nome da loja", saved.getId(), newBean.getId());
		
		newBean.setNome("Novo nome da loja");
		Loja lojaAlterada = Loja.newInstance(newBean);
		Loja lojaAlteradaSalva = repository.save(lojaAlterada);
		
		assertEquals("Nome da loja salva deve ser igual a do bean", "Novo nome da loja", lojaAlteradaSalva.getNome());
	}
	
	@Test
	public void desativarLoja(){
		LojaBean bean = new LojaBean();
		bean.setNome("Loja teste");

		Loja saved = repository.salvar(bean);
		
		assertTrue("loja deve estar ativa", saved.isAtivo());
		
		repository.desativar(saved);
		assertFalse("loja deve estar desativada", saved.isAtivo());
	}

}
