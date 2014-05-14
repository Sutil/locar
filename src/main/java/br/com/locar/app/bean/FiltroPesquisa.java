package br.com.locar.app.bean;

import java.io.Serializable;

import br.com.locar.app.model.QObra;

import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

public class FiltroPesquisa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String busca;
	
	public String getBusca() {
		return busca;
	}
	
	public void setBusca(String busca) {
		this.busca = busca;
	}
	
	
	public Predicate toPredicate(){
		System.out.println("buscando por:"+busca);
		if(!Strings.isNullOrEmpty(busca)){
			BooleanBuilder builder = new BooleanBuilder();
			builder.and(QObra.obra.titulo.containsIgnoreCase(busca));
			return builder;
		}
		return null;
	}

}
