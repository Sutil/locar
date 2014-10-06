package br.com.locar.app.model.entity;

import static com.google.common.base.Preconditions.checkArgument;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.locar.app.bean.CategoriaBean;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

@Entity
public class Categoria extends Entidade {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String nome;
	private BigDecimal diaria;
	private BigDecimal protecaoOcupantes;
	private BigDecimal protecaoTerceiros;
	private BigDecimal taxaDevolucaoLojaDiferente;
	private BigDecimal taxaReposicaoDocumentos;

	
	public Categoria() {
	}

	private Categoria(Long id, String nome, BigDecimal diaria,
			BigDecimal protecaoOcupantes, BigDecimal protecaoTerceiros,
			BigDecimal taxaDevolucaoLojaDiferente,
			BigDecimal taxaReposicaoDocumentos) {

		this.id = id;
		this.nome = nome;
		this.diaria = diaria;
		this.protecaoOcupantes = protecaoOcupantes;
		this.protecaoTerceiros = protecaoTerceiros;
		this.taxaDevolucaoLojaDiferente = taxaDevolucaoLojaDiferente;
		this.taxaReposicaoDocumentos = taxaReposicaoDocumentos;
	}

	public static Categoria newInstance(CategoriaBean bean) {
		return newInstance(bean.getId(), bean.getNome(), bean.getDiaria(),
				bean.getProtecaoOcupantes(),
				bean.getProtecaoTerceiros(),
				bean.getTaxaDevolucaoLojaDiferente(),
				bean.getTaxaReposicaoDocumentos());
	}

	private static Categoria newInstance(Long id, String nome,
			BigDecimal diaria, BigDecimal protecaoOcupantes,
			BigDecimal protecaoTerceiros,
			BigDecimal taxaDevolucaoLojaDiferente,
			BigDecimal taxaReposicaoDocumentos) {

		checkArgument(!Strings.isNullOrEmpty(nome),
				"Nome da categoria não foi informado.");
		checkArgument(diaria != null && BigDecimal.ZERO.compareTo(diaria) < 0, "Valor da diaria Inválido.");
		checkArgument(protecaoOcupantes != null
				&& BigDecimal.ZERO.compareTo(protecaoOcupantes) < 0, "Valor da porteção de ocupantes inválido");
		checkArgument(protecaoTerceiros != null
				&& BigDecimal.ZERO.compareTo(protecaoTerceiros) < 0, "Valor da proteção de terceiros.");
		checkArgument(taxaDevolucaoLojaDiferente != null
				&& BigDecimal.ZERO.compareTo(taxaDevolucaoLojaDiferente) < 0, "Valor da taxa de devolução em loja diferente é inválido.");
		checkArgument(taxaReposicaoDocumentos != null
				&& BigDecimal.ZERO.compareTo(taxaReposicaoDocumentos) < 0, "Valor da taxa de reposição de documentos é inválido");
		return new Categoria(id, nome, diaria,
				protecaoOcupantes, protecaoTerceiros,
				taxaDevolucaoLojaDiferente, taxaReposicaoDocumentos);

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Categoria) {
			Categoria other = (Categoria) obj;
			return Objects.equal(this.nome, other.nome);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(nome);
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

	public BigDecimal getTaxaReposicaoDocumentos() {
		return taxaReposicaoDocumentos;
	}

	public void setTaxaDevolucaoDocumentos(BigDecimal taxaDevolucaoDocumentos) {
		this.taxaReposicaoDocumentos = taxaDevolucaoDocumentos;
	}

}
