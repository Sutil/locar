package br.com.locar.app.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.locar.app.AmbienteComCategoriaELojaCadastradas;
import br.com.locar.app.IntegrationTestConfig;
import br.com.locar.app.bean.VeiculoBean;
import br.com.locar.app.model.entity.Categoria;
import br.com.locar.app.model.entity.Loja;
import br.com.locar.app.model.entity.Veiculo;

public class VeiculoRepositoryIT extends IntegrationTestConfig {

	@Autowired
	private VeiculoRepository repository;

	@Autowired
	private AmbienteComCategoriaELojaCadastradas ambiente;;

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LojaRepository lojaRepository;

	@Before
	public void beforw() {
		ambiente.setUp();
	}

	@After
	public void nada() {
		repository.deleteAll();
		ambiente.turnDown();
	}

	@Test
	public void testCadastroCarroHappyday() {
		Categoria categoria = categoriaRepository.findAll().get(0);
		Loja loja = lojaRepository.findAll().get(0);
		VeiculoBean bean = criaBean(categoria, loja, "marca", "modelo", 2000,
				"AAA-1010", "123456");

		Veiculo saved = repository.salvar(bean);
		assertNotNull("veiculo salvo não pode ser nulo", saved);
		assertNotNull("Id do veiculo salvo não pode ser nulo.", saved.getId());
		assertEquals("Categoria do veiculo deve ser igual ao do bean",
				bean.getCategoria(), saved.getCategoria());
		assertEquals("Marca de veiculo deve ser igual a do bean",
				bean.getMarca(), saved.getMarca());
		assertEquals("Modelo do veiculo deve ser igual ao do bean",
				bean.getModelo(), saved.getModelo());
		assertEquals("Ano do veiculo deve ser igual ao do bean", bean.getAno(),
				saved.getAno());
		assertEquals("Placa do veiculo deve ser igual a do bean",
				bean.getPlaca(), saved.getPlaca().toString());
		assertEquals("Renavan do veiculo deve ser igual ao do bean",
				bean.getRenavam(), saved.getRenavam());
		
		assertNotNull("Local do veiculo não pode ser nulo ao ser criado.",saved.getLocal());
	}

	public VeiculoBean criaBean(Categoria categoria, Loja loja, String marca,
			String modelo, int ano, String placa, String renavam) {
		VeiculoBean bean = new VeiculoBean();

		bean.setCategoria(categoria);
		bean.setMarca(marca);
		bean.setModelo(modelo);
		bean.setAno(ano);
		bean.setPlaca(placa);
		bean.setRenavam(renavam);
		bean.setLoja(loja);

		return bean;
	}

}
