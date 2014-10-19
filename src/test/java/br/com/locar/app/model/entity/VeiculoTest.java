package br.com.locar.app.model.entity;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.locar.app.bean.CategoriaBean;
import br.com.locar.app.bean.VeiculoBean;

public class VeiculoTest {
	
	private Categoria categoria;
	
	@Before
	public void before(){
		BigDecimal valorDiaRiaEOutros = new BigDecimal("10.00");
		CategoriaBean bean = new CategoriaBean();
		bean.setNome("Categoria teste");
		bean.setDiaria(valorDiaRiaEOutros);
		bean.setProtecaoOcupantes(valorDiaRiaEOutros);
		bean.setProtecaoTerceiros(valorDiaRiaEOutros);
		bean.setTaxaReposicaoDocumentos(valorDiaRiaEOutros);
		bean.setTaxaDevolucaoLojaDiferente(valorDiaRiaEOutros);
		categoria = Categoria.newInstance(bean);
	}

	@Test
	public void testVeiculoHappyDay() {
		Veiculo veiculo = Veiculo.newInstance(criaVeiculoBean(categoria, "marca", "modelo", 2000, "AAA-1111", "98745632"));
		Assert.assertNotNull(veiculo);
	}
	
	
	@Test(expected = NullPointerException.class)
	public void criaVeiculoInformandoCategoriaNulo() {
		Veiculo.newInstance(criaVeiculoBean(null, "marca", "modelo", 2000, "AAA-1111", "98745632"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void criaVeiculoInformandoMarcaInvalida(){
		Veiculo.newInstance(criaVeiculoBean(categoria, null, "modelo", 2000, "AAA-1111", "98745632"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void criaVeiculoInformandoModeloInvalido(){
		Veiculo.newInstance(criaVeiculoBean(categoria, "marca", null, 2000, "AAA-1111", "98745632"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void criaVeiculoInformandoPlacaNulo(){
		Veiculo.newInstance(criaVeiculoBean(categoria, "marca", "modelo", 2000, null, "98745632"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void criaVeiculoInformandoPlacaVaziat(){
		Veiculo.newInstance(criaVeiculoBean(categoria, "marca", "modelo", 2000, null, "98745632"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void criaVeiculoInformandoPlacaInvalida(){
		Veiculo.newInstance(criaVeiculoBean(categoria, "marca", "modelo", 2000, "A1324", "98745632"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void criaVeiculoInformandoRenavamNulo(){
		Veiculo.newInstance(criaVeiculoBean(categoria, "marca", "modelo", 2000, "AAA-1234", null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void criaVeiculoInformandoRenavamVazio(){
		Veiculo.newInstance(criaVeiculoBean(categoria, "marca", "modelo", 2000, "AAA-1234", ""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void criaVeiculoInformandoRenavamInvalido(){
		Veiculo.newInstance(criaVeiculoBean(categoria, "marca", "modelo", 2000, "AAA-1234", "ACB5S"));
	}
	
	public VeiculoBean criaVeiculoBean(Categoria categoria, 
			String marca, String modelo, int ano, String placa, String renavam){
		Loja loja = Mockito.mock(Loja.class);
		
		VeiculoBean bean = new VeiculoBean();
		bean.setCategoria(categoria);
		bean.setModelo(modelo);
		bean.setMarca(marca);
		bean.setAno(ano);
		bean.setPlaca(placa);
		bean.setRenavam(renavam);
		bean.setLoja(loja);
		return bean;
	}

}
