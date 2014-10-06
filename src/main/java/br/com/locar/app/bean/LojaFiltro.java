package br.com.locar.app.bean;

import static br.com.locar.app.model.entity.Status.ATIVO;

import java.io.Serializable;

import br.com.locar.app.model.entity.QLoja;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

public class LojaFiltro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean inativo = false;
	
	public Predicate toPredicate(){
		BooleanBuilder builder = new BooleanBuilder();
		if(!inativo){
			builder.and(QLoja.loja.status.eq(ATIVO));
		}
		return builder;
	}
	
	public boolean isInativo() {
		return inativo;
	}
	
	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}
	
	

}
