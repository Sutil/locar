package br.com.locar.app.model.entity;

import java.io.Serializable;
import java.util.List;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private List<Preposto> prepostos = Lists.newArrayList();
	

	public Cliente(String nome, String cpf, String endereco, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Cliente){
			Cliente other = (Cliente) obj;
			return Objects.equal(this.nome, other.nome);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(nome);
	}
	
	public void addPreposto(Preposto preposto){
		System.out.println("adicionando preposto");
		this.prepostos.add(preposto);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public List<Preposto> getPrepostos() {
		return prepostos;
	}
	
	public void setPrepostos(List<Preposto> prepostos) {
		this.prepostos = prepostos;
	}

}
