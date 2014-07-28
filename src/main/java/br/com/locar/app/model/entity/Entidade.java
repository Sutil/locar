package br.com.locar.app.model.entity;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Enumerated(EnumType.STRING)
	protected Status status;
	
	public void desativar(){
		this.status = Status.INATIVO;
	}
	
	public void ativar(){
		this.status = Status.ATIVO;
	}
	
	

}
