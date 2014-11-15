package br.com.locar.app;

import org.junit.Test;

/*
 * Eduardo Sutil - Reserva
 Tuca - Locação
 Marcelo - Veiculo
 Eduardo shibukawa = Relatório de multas x locação!
 */
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.config.root.SteConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SteConfig.class })
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class IntegrationTestConfig {

	@Test
	public void test() {
		System.out.println("setUp profile test");
	}

}
