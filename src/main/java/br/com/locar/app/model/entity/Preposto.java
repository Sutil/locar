package br.com.locar.app.model.entity;

import java.io.Serializable;

import com.google.common.base.Objects;

public class Preposto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cnh;
	private String validadeCnh;
	private Cliente cliente;
	
	public Preposto() {
	}
	
	
	
	public Preposto(String nome, String cnh, String validadeCnh) {
		this.nome = nome;
		this.cnh = cnh;
		this.validadeCnh = validadeCnh;
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Preposto){
			Preposto other = (Preposto) obj;
			return Objects.equal(this.nome, other.nome);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(nome);
	}

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
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

}
