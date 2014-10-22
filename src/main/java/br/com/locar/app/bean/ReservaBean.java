package br.com.locar.app.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import br.com.locar.app.model.entity.Cliente;
import br.com.locar.app.model.entity.Veiculo;

public class ReservaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private Veiculo veiculo;
	private Date inicio;
	private Date fim;

	public BigDecimal getValorPreCalculado() {
		if (inicio == null || fim == null)
			return BigDecimal.ZERO;
		int days = getQuantidadeDeDiasReservados();

		return veiculo.getCategoria().getDiaria()
				.multiply(new BigDecimal(days));

	}

	private int getQuantidadeDeDiasReservados() {
		LocalDate ini = LocalDate.fromDateFields(inicio);
		LocalDate fin = LocalDate.fromDateFields(fim);

		int days = Days.daysBetween(ini, fin).getDays()+1;
		return days;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public Date getInicio() {
		return inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public void setInicio(Date incio) {
		this.inicio = incio;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

}
