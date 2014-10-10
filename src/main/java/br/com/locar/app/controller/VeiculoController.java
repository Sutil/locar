package br.com.locar.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.locar.app.bean.VeiculoBean;
import br.com.locar.app.model.dao.VeiculoRepository;
import br.com.locar.app.model.entity.Veiculo;

@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public VeiculoBean novo(){
		return new VeiculoBean();
	}
	
	public void salvar(VeiculoBean bean){
		veiculoRepository.salvar(bean);
	}
	
	public void inativar(Veiculo veiculo){
		veiculoRepository.inativar();
	}

}
