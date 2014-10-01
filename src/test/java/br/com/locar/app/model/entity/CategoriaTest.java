package br.com.locar.app.model.entity;

import java.math.BigDecimal;

import org.junit.Test;

public class CategoriaTest {

	@Test(expected = RuntimeException.class)
	public void testNomeCategoriaNulo() {
		Categoria.newInstance(1L, null, new BigDecimal("10.00"),
				new BigDecimal("10.00"), new BigDecimal("50.00"),
				new BigDecimal("10.00"), new BigDecimal("10.00"),
				new BigDecimal("10.00"), new BigDecimal("10.00"));
	}
	
	@Test(expected = RuntimeException.class)
	public void testNomeCategoriaVazio() {
		Categoria.newInstance(1L, "", new BigDecimal("10.00"),
				new BigDecimal("10.00"), new BigDecimal("50.00"),
				new BigDecimal("10.00"), new BigDecimal("10.00"),
				new BigDecimal("10.00"), new BigDecimal("10.00"));

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValoresNulos() {
		Categoria.newInstance(1L, "Minha categoria", null,
				null, null,
				null, null,
				null, null);

	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testValoresNegativos() {
		Categoria.newInstance(1L, "Minha categoria", new BigDecimal("-1.0"),
				new BigDecimal("-1.0"), new BigDecimal("-1.0"),
				new BigDecimal("-1.0"), new BigDecimal("-1.0"),
				new BigDecimal("-1.0"), new BigDecimal("-1.0"));
		
	}

}
