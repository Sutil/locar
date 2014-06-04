package br.com.locar.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.common.base.Objects;

public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private BigDecimal diario;
	private BigDecimal protecaoParcial;
	private BigDecimal protecaoTotal;
	private BigDecimal protecaoOcupantes;
	private BigDecimal protecaoTerceiros;
	private BigDecimal taxaDevolucaoLojaDiferente;
	private BigDecimal taxaDevolucaoDocumentos;

	public Categoria() {
	}

	public Categoria(String nome, BigDecimal diario,
			BigDecimal protecaoParcial, BigDecimal protecaoTotal,
			BigDecimal protecaoOcupantes, BigDecimal protecaoTerceiros,
			BigDecimal taxaDevolucaoLojaDiferente,
			BigDecimal taxaDevolucaoDocumentos) {
		this.nome = nome;
		this.diario = diario;
		this.protecaoParcial = protecaoParcial;
		this.protecaoTotal = protecaoTotal;
		this.protecaoOcupantes = protecaoOcupantes;
		this.protecaoTerceiros = protecaoTerceiros;
		this.taxaDevolucaoLojaDiferente = taxaDevolucaoLojaDiferente;
		this.taxaDevolucaoDocumentos = taxaDevolucaoDocumentos;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Categoria){
			Categoria other = (Categoria) obj;
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

	public BigDecimal getDiario() {
		return diario;
	}

	public void setDiario(BigDecimal diario) {
		this.diario = diario;
	}

	public BigDecimal getProtecaoParcial() {
		return protecaoParcial;
	}

	public void setProtecaoParcial(BigDecimal protecaoParcial) {
		this.protecaoParcial = protecaoParcial;
	}

	public BigDecimal getProtecaoTotal() {
		return protecaoTotal;
	}

	public void setProtecaoTotal(BigDecimal protecaoTotal) {
		this.protecaoTotal = protecaoTotal;
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
