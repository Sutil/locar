package br.com.locar.app.bean;

import java.io.Serializable;

import br.com.locar.app.model.entity.Loja;

public class LojaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	
	public LojaBean(){
	}
	
	public LojaBean(Loja loja){
		this.id = loja.getId();
		this.nome = loja.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
