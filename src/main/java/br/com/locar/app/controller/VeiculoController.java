package br.com.locar.app.controller;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.bean.VeiculoBean;
import br.com.locar.app.bean.VeiculoFiltro;
import br.com.locar.app.model.dao.CategoriaRepository;
import br.com.locar.app.model.dao.VeiculoRepository;
import br.com.locar.app.model.entity.Categoria;
import br.com.locar.app.model.entity.Veiculo;

@Controller
public class VeiculoController extends LocarController {

	private static final String MSG_VEÍCULO_SALVO_COM_SUCESSO = "Veículo salvo com sucesso.";
	private static final String MSG_ERRO_AO_SALVAR_VEÍCULO = "Erro ao salvar veículo";
	private static final String MSG_ERRO_AO_EXCLUIR_VEÍCULO = "Erro ao excluir veículo";
	private static final String MSG_VEÍCULO_EXCLUÍDO_COM_SUCESSO = "Veículo excluído com sucesso.";
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public VeiculoFiltro newFiltro() {
		return new VeiculoFiltro();
	}

	public VeiculoBean newBean() {
		return new VeiculoBean();
	}

	public List<Categoria> getCategoriasAtivas() {
		return categoriaRepository.findAllActives();
	}

	@Transactional
	public void salvar(VeiculoBean bean) {
		System.out.println("salvando");
		try {
			veiculoRepository.salvar(bean);
			message(SEVERITY_INFO, MSG_VEÍCULO_SALVO_COM_SUCESSO, "");
		} catch (Exception e) {
			message(SEVERITY_ERROR, MSG_ERRO_AO_SALVAR_VEÍCULO, e.getMessage());
		}
	}

	@Transactional
	public void inativar(Veiculo veiculo) {
		try {
			veiculoRepository.inativar(veiculo);
			message(SEVERITY_INFO, MSG_VEÍCULO_EXCLUÍDO_COM_SUCESSO, "");
		} catch (Exception e) {
			message(SEVERITY_ERROR, MSG_ERRO_AO_EXCLUIR_VEÍCULO, e.getMessage());
		}
	}
	

}
