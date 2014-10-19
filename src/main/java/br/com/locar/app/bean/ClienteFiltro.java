package br.com.locar.app.bean;

import static br.com.locar.app.model.entity.QCliente.cliente;

import java.io.Serializable;

import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

public class ClienteFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String value;

	public Predicate toPredicate() {
		BooleanBuilder builder = new BooleanBuilder();
		if (!Strings.isNullOrEmpty(value)) {
			builder.or(cliente.nome.containsIgnoreCase(value))
					.or(cliente.cpf.containsIgnoreCase(value))
					.or(cliente.telefone.containsIgnoreCase(value));
		}
		return builder;

	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
