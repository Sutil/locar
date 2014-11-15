package br.com.locar.app.model.entity;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

import br.com.locar.app.bean.CategoriaBean;
import br.com.locar.app.bean.ReservaBean;
import br.com.locar.app.bean.VeiculoBean;

public class ReservaTest {

	@Test
	public void testNewInstanceHappyDay() {
		Calendar inicio = Calendar.getInstance();
		Calendar fim = Calendar.getInstance();
		
		inicio.add(Calendar.DAY_OF_MONTH, 1);
		fim.add(Calendar.DAY_OF_MONTH, 3);
		
		Reserva reserva = Reserva.newInstance(criaBean(criaCliente(), criaVeiculo(), inicio, fim ));
		assertNotNull("Reserva não pode ser nulo.", reserva);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testReservaInformandoDataMenorQueAtual_erro(){
		Calendar inicio = Calendar.getInstance();
		Calendar fim = Calendar.getInstance();
		
		inicio.add(Calendar.DAY_OF_MONTH, -1);
		fim.add(Calendar.DAY_OF_MONTH, 3);
		
		Reserva.newInstance(criaBean(criaCliente(), criaVeiculo(), inicio, fim ));
	}
	
	private ReservaBean criaBean(Cliente cliente, Veiculo veiculo, Calendar inicio, Calendar fim) {
		ReservaBean b = new ReservaBean();
		b.setCliente(cliente);
		b.setVeiculo(veiculo);
		
		b.setInicio(inicio.getTime());
		b.setFim(fim.getTime());
		return b;
	}
	

	private Cliente criaCliente(){
		return new Cliente("Edu", "99999999999", "Endereco", "99999999");
	}
	
	private Veiculo criaVeiculo(){
		VeiculoBean b = new VeiculoBean();
		b.setAno(2014);
		b.setCategoria(criaCategoria());
		b.setLoja(new Loja());
		b.setMarca("marca");
		b.setModelo("modelo");
		b.setPlaca("AAA8888");
		b.setRenavam("123456789");
		
		return Veiculo.newInstance(b);
	}
	
	private Categoria criaCategoria(){
		CategoriaBean b = new CategoriaBean();
		BigDecimal valor = new BigDecimal("10.00");
		b.setDiaria(valor);
		b.setProtecaoOcupantes(valor);
		b.setProtecaoTerceiros(valor);
		b.setTaxaDevolucaoLojaDiferente(valor);
		b.setTaxaReposicaoDocumentos(valor);
		b.setNome("categoria");
		
		return Categoria.newInstance(b);
		
	}

}
