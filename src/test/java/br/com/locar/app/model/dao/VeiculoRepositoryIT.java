package br.com.locar.app.model.dao;

import static org.junit.Assert.fail;

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

import br.com.locar.app.bean.VeiculoBean;
import br.com.locar.app.model.entity.Categoria;
import br.com.locar.app.model.entity.Veiculo;
import br.com.locar.config.root.SteConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SteConfig.class })
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class VeiculoRepositoryIT {

	@Autowired
	private VeiculoRepository repository;

	@After
	public void after() {
		repository.deleteAll();
	}

	@Test
	public void testVeiculoHappyDay() {
		fail();
	}

	public Veiculo criaVeiculoBean(Categoria categoria, String marca,
			String modelo, int ano, String placa, String renavam) {
		VeiculoBean bean = new VeiculoBean();
		bean.setCategoria(categoria);
		bean.setModelo(modelo);
		bean.setMarca(marca);
		bean.setAno(ano);
		bean.setPlaca(placa);
		bean.setRenavam(renavam);
		return Veiculo.newInstance(bean);
	}

}
