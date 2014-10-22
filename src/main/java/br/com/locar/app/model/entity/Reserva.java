package br.com.locar.app.model.entity;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.joda.time.DateMidnight;

import br.com.locar.app.bean.ReservaBean;

@Entity
public class Reserva extends Entidade {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private Cliente cliente;
	private Veiculo veiculo;
	private Date inicio;
	private Date fim;

	Reserva() {
	}

	private Reserva(ReservaBean bean) {
		this.cliente = bean.getCliente();
		this.veiculo = bean.getVeiculo();
		this.inicio = bean.getInicio();
		this.fim = bean.getFim();
	}

	public static Reserva newInstance(ReservaBean bean) {
		checkNotNull(bean, "Dados do formulário não informados");
		checkNotNull(bean.getCliente(), "Informe o cliente");
		checkNotNull(bean.getVeiculo(), "Informe o veículo");
		checkNotNull(bean.getInicio(), "Informe a data da locação.");
		checkNotNull(bean.getFim(), "Informe a data prevista para devolução.");
		DateMidnight fim = new DateMidnight(bean.getFim());
		DateMidnight inicio = new DateMidnight(bean.getInicio());
		checkArgument(inicio.isAfterNow(),
				"A data da reserva não pode ser a menor que a data atual.");
		checkArgument(fim.isEqual(inicio) || fim.isAfter(inicio),
				"A data do fim da resarva deve ser maior ou igual a data de início.");

		return new Reserva(bean);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

}
