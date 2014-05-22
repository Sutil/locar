package br.com.locar.app.model.entity;

import java.io.Serializable;

public class Preposto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cnh;
	private String validadeCnh;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getValidadeCnh() {
		return validadeCnh;
	}

	public void setValidadeCnh(String validadeCnh) {
		this.validadeCnh = validadeCnh;
	}

}
