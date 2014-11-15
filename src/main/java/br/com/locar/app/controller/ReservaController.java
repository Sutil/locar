package br.com.locar.app.controller;

import static br.com.locar.app.model.entity.QCliente.cliente;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.bean.ReservaBean;
import br.com.locar.app.bean.ReservaFiltro;
import br.com.locar.app.model.dao.ClienteRepository;
import br.com.locar.app.model.dao.ReservaRepository;
import br.com.locar.app.model.dao.VeiculoRepository;
import br.com.locar.app.model.entity.Cliente;
import br.com.locar.app.model.entity.QVeiculo;
import br.com.locar.app.model.entity.Reserva;
import br.com.locar.app.model.entity.Veiculo;
import br.com.locar.app.model.types.Placa;

import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;

@Controller
public class ReservaController extends LocarController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private ReservaRepository reservaRepository;

	public ReservaBean newBean() {
		return new ReservaBean();
	}
	
	public ReservaFiltro newFiltro(){
		return new ReservaFiltro();
	}

	public List<Cliente> completeCliente(String query) {
		if (Strings.isNullOrEmpty(query)) {
			return new ArrayList<Cliente>();
		}
		BooleanBuilder builder = queryCliente(query);
		return clienteRepository.findAll(builder);
	}

	private BooleanBuilder queryCliente(String query) {
		BooleanBuilder builder = new BooleanBuilder().or(
				cliente.nome.containsIgnoreCase(query)).or(
				cliente.cpf.containsIgnoreCase(query));
		return builder;
	}

	public List<Veiculo> completeVeiculo(String query) {
		if (Strings.isNullOrEmpty(query)) {
			return new ArrayList<Veiculo>();
		}
		BooleanBuilder builder = queryVeiculo(query);
		return veiculoRepository.findAll(builder);
	}

	private BooleanBuilder queryVeiculo(String query) {
		BooleanBuilder builder = new BooleanBuilder().or(
				QVeiculo.veiculo.modelo.containsIgnoreCase(query)).or(
				QVeiculo.veiculo.marca.containsIgnoreCase(query));
		try {
			Placa placa = Placa.fromString(query);
			builder.or(QVeiculo.veiculo.placa.eq(placa));
		} catch (IllegalArgumentException e) {

		}
		return builder;
	}

	@Transactional
	public void salvar(ReservaBean bean) {
		try {
			Reserva reserva = Reserva.newInstance(bean);
			reservaRepository.save(reserva);
			message(SEVERITY_INFO,"Reserva efetuada com sucesso" , "");
		} catch (Exception e) {
			message(SEVERITY_ERROR, "Erro ao salvar reserva.", e.getMessage());
		}
	}
	
	@Transactional
	public List<Reserva> pesquisar(ReservaFiltro filtro){
		return reservaRepository.findAll(filtro.toPredicate());
	}

}
