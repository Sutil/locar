package br.com.locar.app.model.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.locar.app.bean.CategoriaBean;

import com.google.common.base.Objects;

@Entity
public class Categoria extends Entidade {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private BigDecimal diaria;
	private BigDecimal protecaoParcial;
	private BigDecimal protecaoTotal;
	private BigDecimal protecaoOcupantes;
	private BigDecimal protecaoTerceiros;
	private BigDecimal taxaDevolucaoLojaDiferente;
	private BigDecimal taxaDevolucaoDocumentos;

	public Categoria() {
	}

	public Categoria(Long id, String nome, BigDecimal diaria,
			BigDecimal protecaoParcial, BigDecimal protecaoTotal,
			BigDecimal protecaoOcupantes, BigDecimal protecaoTerceiros,
			BigDecimal taxaDevolucaoLojaDiferente,
			BigDecimal taxaDevolucaoDocumentos) {
		this.id = id;
		this.nome = nome;
		this.diaria = diaria;
		this.protecaoParcial = protecaoParcial;
		this.protecaoTotal = protecaoTotal;
		this.protecaoOcupantes = protecaoOcupantes;
		this.protecaoTerceiros = protecaoTerceiros;
		this.taxaDevolucaoLojaDiferente = taxaDevolucaoLojaDiferente;
		this.taxaDevolucaoDocumentos = taxaDevolucaoDocumentos;
	}
	
	public static Categoria newIntance(CategoriaBean bean){
		return new Categoria(bean.getId(), bean.getNome(), 
				bean.getDiaria(), bean.getProtecaoParcial(), 
				null, bean.getProtecaoOcupantes(), bean.getProtecaoTerceiros(), 
				bean.getTaxaDevolucaoLojaDiferente(), bean.getTaxaDevolucaoDocumentos());
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
	
	public boolean isAtivo(){
		return status == Status.ATIVO;
	}
	
	public Long getId() {
		return id;
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
