package br.com.locar.app.model.entity.locacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.locar.app.model.entity.Categoria;
import br.com.locar.app.model.entity.Preposto;
import br.com.locar.app.model.entity.Veiculo;

public class LocacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Preposto preposto;
	private Veiculo veiculo;
	private Date devolucao;

	private boolean protecaoParcial;
	private boolean protecaoOcupantes;
	private boolean protecaoTerceiros;

	public boolean isProtecaoTotal() {
		return protecaoOcupantes && protecaoParcial && protecaoTerceiros;
	}

	public void setProtecaoTotal(boolean protecaoTotal) {
		if (protecaoTotal) {
			this.protecaoOcupantes = true;
			this.protecaoParcial = true;
			this.protecaoTerceiros = true;
		}
	}

	public BigDecimal getValor() {
		Categoria c = veiculo.getCategoria();
		BigDecimal valor = c.getDiaria();
		valor = valor.add(protecaoOcupantes ? c.getProtecaoOcupantes()
				: BigDecimal.ZERO);
		valor = valor.add(protecaoParcial ? c.getProtecaoParcial()
				: BigDecimal.ZERO);
		valor = valor.add(protecaoTerceiros ? c.getProtecaoTerceiros()
				: BigDecimal.ZERO);
		return valor;
	}

	public void checkDate() {
		System.out.println("escolher data");
		System.out.println(devolucao);
		if (devolucao != null) {
			Calendar hoje = Calendar.getInstance();
			hoje.set(Calendar.HOUR_OF_DAY, 0);
			hoje.set(Calendar.MINUTE, 0);
			hoje.set(Calendar.SECOND, 0);
			hoje.set(Calendar.MILLISECOND, 0);
			
			int days = Days.daysBetween(new DateTime(hoje.getTime()),
					new DateTime(devolucao)).getDays();
			if (days < 1 || days > 30) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Data inváliida",
								"o veiculo não pode ser locado por " + days
										+ " dias."));
				devolucao = null;
			}
		}
	}

	public boolean isProtecaoParcial() {
		return protecaoParcial;
	}

	public void setProtecaoParcial(boolean protecaoParcial) {
		this.protecaoParcial = protecaoParcial;
	}

	public boolean isProtecaoOcupantes() {
		return protecaoOcupantes;
	}

	public void setProtecaoOcupantes(boolean protecaoOcupantes) {
		this.protecaoOcupantes = protecaoOcupantes;
	}

	public boolean isProtecaoTerceiros() {
		return protecaoTerceiros;
	}

	public void setProtecaoTerceiros(boolean protecaoTerceiros) {
		this.protecaoTerceiros = protecaoTerceiros;
	}

	public Preposto getPreposto() {
		return preposto;
	}

	public void setPreposto(Preposto preposto) {
		this.preposto = preposto;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}

}
