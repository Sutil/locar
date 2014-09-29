package br.com.locar.app.model.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.model.entity.Categoria;
import br.com.locar.config.root.SteConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SteConfig.class})
@Transactional
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class CategoriaRepositoryIT {
	
	@Autowired
	private CategoriaRepository repository;

	@Test
	public void test() {
		Categoria categoria = new Categoria(
				new Long(1L), "categoria1", 
				new BigDecimal("50.00"), 
				new BigDecimal("10.00"), 
				null, 
				new BigDecimal("35.00"), 
				new BigDecimal("20.00"), 
				new BigDecimal("27.00"), 
				new BigDecimal("100.00"));
		repository.salvar(categoria);
		
		final List<Categoria> list = repository.findAll();
		assertFalse("A lista de categorias não pode ser vazia", list.isEmpty());
		assertTrue("A lista de categorias deve conter um registro", list.size() == 1);
		
		repository.deleteAll();
		
		List<Categoria> listaVazia = repository.findAll();
		
		assertTrue("A lista de categorias deve estar vazia.", listaVazia.isEmpty());
	}

}
