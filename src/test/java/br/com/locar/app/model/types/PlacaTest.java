package br.com.locar.app.model.types;

import junit.framework.Assert;

import org.junit.Test;

public class PlacaTest {
	
	private static final String placaValida1 = "AAA-0000";
	private static final String placaValida2 = "AAA0000";

	@Test
	public void testFromStringHappyDay() {
		Placa placa1 = Placa.fromString(placaValida1);
		Assert.assertEquals("AAA-0000", placa1.toString());
		
		Placa placa2 = Placa.fromString(placaValida2);
		Assert.assertEquals("AAA-0000", placa2.toString());
		
	}
	
	@Test
	public void testFromStringComLetrasMinusculas(){
		Placa placa1 = Placa.fromString(placaValida1.toLowerCase());
		Assert.assertEquals("AAA-0000", placa1.toString());
		
		Placa placa2 = Placa.fromString(placaValida2.toLowerCase());
		Assert.assertEquals("AAA-0000", placa2.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPlacaNulo_Erro(){
		Placa.fromString(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPlacaInvalidaCom3LetrasETresNumeros_Erro(){
		Placa.fromString("AAA000");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPlacaInvalidaCom3LetrasECincoNumeros_Erro(){
		Placa.fromString("AAA00000");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPlacaInvalidaComDuasLetrasEQuatroNumeros_Erro(){
		Placa.fromString("AA0t000");
	}

	

}
