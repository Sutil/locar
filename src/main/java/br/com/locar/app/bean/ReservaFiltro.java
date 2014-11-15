package br.com.locar.app.bean;

import static br.com.locar.app.model.entity.QReserva.reserva;
import static br.com.locar.app.model.entity.Status.ATIVO;

import java.io.Serializable;

import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

public class ReservaFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String value;
	private boolean mostrarCancelados;

	public Predicate toPredicate() {
		BooleanBuilder builder = new BooleanBuilder();
		if (!Strings.isNullOrEmpty(value)) {
			builder.or(reserva.cliente.nome.containsIgnoreCase(value));
			builder.or(reserva.veiculo.modelo.containsIgnoreCase(value));
		}
		if(!mostrarCancelados){
			builder.and(reserva.status.eq(ATIVO));
		}
		return builder;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean isMostrarCancelados() {
		return mostrarCancelados;
	}
	
	public void setMostrarCancelados(boolean mostrarCancelados) {
		this.mostrarCancelados = mostrarCancelados;
	}

}
