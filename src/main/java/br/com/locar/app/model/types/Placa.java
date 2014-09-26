package br.com.locar.app.model.types;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Strings;

public class Placa implements Serializable{
	
	private static final String regexPlaca = "[a-zA-Z]{3}\\-\\d{4}|[a-zA-Z]{3}\\d{4}";
	private static final String regexLetra = "([a-zA-Z]{3})";
	private static final String regexNumeros = "(\\d{4})";
	private static final Pattern patternPlaca = Pattern.compile(regexPlaca, Pattern.CASE_INSENSITIVE);
	private static final Pattern patternLetas = Pattern.compile(regexLetra, Pattern.CASE_INSENSITIVE);
	private static final Pattern patternNumeros = Pattern.compile(regexNumeros);

	private static final long serialVersionUID = 1L;
	
	private final String letras;
	private final String numeros;
	
	private Placa(String letras, String numeros) {
		this.letras = letras;
		this.numeros = numeros;
	}
	
	public static Placa fromString(String placa){
		checkArgument(!Strings.isNullOrEmpty(placa), "Placa não informada.");
		Matcher m = patternPlaca.matcher(placa);
		checkArgument(m.matches(), "Placa inválida.");
		
		String letras = extrairLetras(placa);
		String numeros = extrairNumeros(placa);
		
		return new Placa(letras, numeros);
	}

	private static String extrairNumeros(String placa) {
		Matcher mNumeros = patternNumeros.matcher(placa);
		mNumeros.find();
		return mNumeros.group();
	}

	private static String extrairLetras(String placa) {
		Matcher mLetras = patternLetas.matcher(placa);
		mLetras.find();
		return mLetras.group();
	}
	
	@Override
	public String toString() {
		return String.format("%s-%s", letras, numeros);
	}

}
