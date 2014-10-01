package br.com.locar.app.bean;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.locar.app.model.entity.Categoria;

public class CategoriaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private BigDecimal diaria;
	private BigDecimal protecaoParcial;
	private BigDecimal protecaoOcupantes;
	private BigDecimal protecaoTerceiros;
	private BigDecimal taxaDevolucaoLojaDiferente;
	private BigDecimal taxaDevolucaoDocumentos;
	
	public CategoriaBean() {
	}
	
	private CategoriaBean(Categoria categoria){
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.diaria = categoria.getDiaria();
		this.protecaoParcial = categoria.getProtecaoParcial();
		this.protecaoOcupantes = categoria.getProtecaoOcupantes();
		this.protecaoTerceiros = categoria.getProtecaoTerceiros();
		this.taxaDevolucaoLojaDiferente = categoria.getTaxaDevolucaoLojaDiferente();
		this.taxaDevolucaoDocumentos = categoria.getTaxaReposicaoDocumentos();
	}
	
	public static CategoriaBean newInstance(Categoria categoria){
		checkNotNull(categoria, "Categoria não pode ser nulo. Impossível editar.");
		return new CategoriaBean(categoria);
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

	public BigDecimal getDiaria() {
		return diaria;
	}

	public void setDiaria(BigDecimal diaria) {
		this.diaria = diaria;
	}

	public BigDecimal getProtecaoParcial() {
		return protecaoParcial;
	}

	public void setProtecaoParcial(BigDecimal protecaoParcial) {
		this.protecaoParcial = protecaoParcial;
	}

	public BigDecimal getProtecaoOcupantes() {
		return protecaoOcupantes;
	}

	public void setProtecaoOcupantes(BigDecimal protecaoOcupantes) {
		this.protecaoOcupantes = protecaoOcupantes;
	}

	public BigDecimal getProtecaoTerceiros() {
		return protecaoTerceiros;
	}

	public void setProtecaoTerceiros(BigDecimal protecaoTerceiros) {
		this.protecaoTerceiros = protecaoTerceiros;
	}

	public BigDecimal getTaxaDevolucaoLojaDiferente() {
		return taxaDevolucaoLojaDiferente;
	}

	public void setTaxaDevolucaoLojaDiferente(
			BigDecimal taxaDevolucaoLojaDiferente) {
		this.taxaDevolucaoLojaDiferente = taxaDevolucaoLojaDiferente;
	}

	public BigDecimal getTaxaDevolucaoDocumentos() {
		return taxaDevolucaoDocumentos;
	}

	public void setTaxaDevolucaoDocumentos(BigDecimal taxaDevolucaoDocumentos) {
		this.taxaDevolucaoDocumentos = taxaDevolucaoDocumentos;
	}

}
