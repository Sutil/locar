package br.com.locar.app.model.dao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.bean.CategoriaBean;
import br.com.locar.app.model.entity.Categoria;
import br.com.locar.config.root.SteConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SteConfig.class })
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class CategoriaRepositoryIT {

	@Autowired
	private CategoriaRepository repository;

	@After
	public void after() {
		repository.deleteAll();
	}

	@Test
	public void testCadastroCategoriaHappyDay() {
		repository.deleteAll();
		
		Categoria categoria = Categoria.newInstance(montaBean("Categoria teste",  new BigDecimal("10.00")));

		repository.salvar(categoria);

		Assert.assertEquals("Deveria conter 1 registros ", 1, repository
				.findAll().size());

		repository.deleteAll();

		Assert.assertTrue("nao deve conter registros", repository.findAll()
				.isEmpty());

	}

	@Test
	public void testValores() {
		Categoria categoria = Categoria.newInstance(montaBean("Categoria teste",new BigDecimal("10.00")));
		

		Categoria saved = repository.salvar(categoria);
		
		assertEquals("Valor da diaria inconsistente.", new BigDecimal("10.00"), saved.getDiaria());
		assertEquals("Valor protecao ocupantes inconsitente", new BigDecimal("10.00"), saved.getProtecaoOcupantes());
		assertEquals("Valor protecao terceiros inconsistente.", new BigDecimal("10.00"), saved.getProtecaoTerceiros());
		assertEquals("Valor taxa devolucao loja deferente inconsistente.", new BigDecimal("10.00"),  saved.getTaxaDevolucaoLojaDiferente());
		assertEquals("Valor reposicao docs inconsistente.", new BigDecimal("10.00"),saved.getTaxaReposicaoDocumentos());
	}
	
	@Test(expected = RuntimeException.class)
	public void testeCategoriasComMesmoNome(){
		repository.deleteAll();
		Categoria categoria1 = Categoria.newInstance(montaBean("Categoria teste", new BigDecimal("10.00")));
		
		Categoria categoria2 = Categoria.newInstance(montaBean("Categoria teste", new BigDecimal("20.00")));
		
		repository.salvar(categoria1);
		Assert.assertTrue(repository.findAll().size() == 1);
		repository.salvar(categoria2);
		
	}
	
	private CategoriaBean montaBean(String nomeCategoria, BigDecimal valorDiaRiaEOutros) {
		CategoriaBean bean = new CategoriaBean();
		bean.setNome(nomeCategoria);
		bean.setDiaria(valorDiaRiaEOutros);
		bean.setProtecaoOcupantes(valorDiaRiaEOutros);
		bean.setProtecaoTerceiros(valorDiaRiaEOutros);
		bean.setTaxaReposicaoDocumentos(valorDiaRiaEOutros);
		bean.setTaxaDevolucaoLojaDiferente(valorDiaRiaEOutros);
		return bean;
	}
	
}
