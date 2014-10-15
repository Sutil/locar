package br.com.locar.app.bean;

import static br.com.locar.app.model.entity.QVeiculo.veiculo;

import java.io.Serializable;

import br.com.locar.app.model.types.Placa;

import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

public class VeiculoFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String value;

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Predicate toPredicate(){
		BooleanBuilder builder = new BooleanBuilder();
		if(Strings.isNullOrEmpty(value)){
			return builder;
		}
		builder.or(veiculo.marca.containsIgnoreCase(value));
		builder.or(veiculo.modelo.containsIgnoreCase(value));
		contaisPlaca(builder);
		return builder;
	}

	private void contaisPlaca(BooleanBuilder builder) {
		try{
			Placa placa = Placa.fromString(value);
			builder.or(veiculo.placa.eq(placa));
		}
		catch(RuntimeException e){
			
		}
	}

	
}
