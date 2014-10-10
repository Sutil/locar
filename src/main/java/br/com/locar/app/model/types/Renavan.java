package br.com.locar.app.model.types;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Strings;

public class Renavan implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String regex = "[\\d]+";
	private static final Pattern pattern = Pattern.compile(regex);
	
	private String renavam;
	
	private Renavan(String renavam) {
		this.renavam = renavam;
	}
	
	public static Renavan fromString(String renavam){
		checkArgument(!Strings.isNullOrEmpty(renavam), "Renavan não informado.");
		Matcher matcher = pattern.matcher(renavam);
		checkArgument(matcher.matches(), "Renavan invádo. Informe apenas números");
		return new Renavan(renavam);
	}
	
	@Override
	public String toString() {
		return renavam;
	}
	
	

}
