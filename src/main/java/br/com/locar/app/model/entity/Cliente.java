package br.com.locar.app.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.common.base.Objects;

@Entity
public class Cliente extends Entidade{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	
	public Cliente(){
	}

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
			return Objects.equal(this.cpf, other.cpf);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(cpf);
	}
	
	public Object getId() {
		return id;
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

}
