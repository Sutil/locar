package br.com.locar.app.bean;

import static br.com.locar.app.model.entity.QCategoria.categoria;

import java.io.Serializable;

import br.com.locar.app.model.entity.Status;

import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

public class CategoriaFiltro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nomeCategoria;
	
	private boolean mostraInativos;
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	public boolean isMostraInativos() {
		return mostraInativos;
	}
	
	public void setMostraInativos(boolean mostraInativos) {
		this.mostraInativos = mostraInativos;
	}
	
	public Predicate toPredicate(){
		BooleanBuilder builder = new BooleanBuilder();
		if(!Strings.isNullOrEmpty(nomeCategoria)){
			builder.and(categoria.nome.containsIgnoreCase(nomeCategoria));
		}
		if(!mostraInativos){
			builder.and(categoria.status.eq(Status.ATIVO));
		}
		return builder;
	}

}
