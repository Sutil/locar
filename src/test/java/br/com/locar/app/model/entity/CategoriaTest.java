package br.com.locar.app.model.entity;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.locar.app.bean.CategoriaBean;

public class CategoriaTest {
	
	@Test
	public void categoriaHappyDay(){
		CategoriaBean bean = montaBean(new BigDecimal("1.00"));
		Categoria.newInstance(bean);
	}

	

	@Test(expected = RuntimeException.class)
	public void testNomeCategoriaNulo() {
		CategoriaBean bean = new CategoriaBean();
		bean.setId(1L);
		bean.setNome(null);
		Categoria.newInstance(bean);

	}
	
	@Test(expected = RuntimeException.class)
	public void testNomeCategoriaVazio() {
		CategoriaBean bean = new CategoriaBean();
		bean.setNome("");
		Categoria.newInstance(bean);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValoresNulos() {
		CategoriaBean bean = new CategoriaBean();
		Categoria.newInstance(bean);

	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testValoresNegativos() {
		CategoriaBean bean = montaBean(new BigDecimal("-1.00"));
		
		
		Categoria.newInstance(bean);
	}
	
	private CategoriaBean montaBean(BigDecimal valorDiaRiaEOutros) {
		CategoriaBean bean = new CategoriaBean();
		bean.setNome("Categoria teste");
		bean.setDiaria(valorDiaRiaEOutros);
		bean.setProtecaoOcupantes(valorDiaRiaEOutros);
		bean.setProtecaoTerceiros(valorDiaRiaEOutros);
		bean.setTaxaReposicaoDocumentos(valorDiaRiaEOutros);
		bean.setTaxaDevolucaoLojaDiferente(valorDiaRiaEOutros);
		return bean;
	}

}
