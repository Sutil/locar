package br.com.locar.app.model.entity.locacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.locar.app.model.entity.Categoria;
import br.com.locar.app.model.entity.Preposto;
import br.com.locar.app.model.entity.Veiculo;

public class Locacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Preposto preposto;
	private Veiculo veiculo;
	private Date retirada = new Date();
	private Date devolucao;
	private BigDecimal protecaoOcupantes = BigDecimal.ZERO;
	private BigDecimal protecaoTerceiros = BigDecimal.ZERO;

	Locacao(LocacaoBean bean) {
		this.preposto = bean.getPreposto();
		this.veiculo = bean.getVeiculo();
		this.devolucao = bean.getDevolucao();
		instaciarValoresDasProtecoes(veiculo.getCategoria(), bean);
	}
	
	

	private void instaciarValoresDasProtecoes(Categoria c, LocacaoBean bean) {
		this.protecaoOcupantes = bean.isProtecaoOcupantes() ? c
				.getProtecaoOcupantes() : BigDecimal.ZERO;
		this.protecaoTerceiros = bean.isProtecaoTerceiros() ? c
				.getProtecaoTerceiros() : BigDecimal.ZERO;
	}
	

	public Preposto getPreposto() {
		return preposto;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public Date getRetirada() {
		return retirada;
	}

	public BigDecimal getProtecaoOcupantes() {
		return protecaoOcupantes;
	}

	public BigDecimal getProtecaoTerceiros() {
		return protecaoTerceiros;
	}
	
	public Date getDevolucao() {
		return devolucao;
	}

}
