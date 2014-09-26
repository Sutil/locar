package br.com.locar.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.locar.app.model.entity.Veiculo;
import br.com.locar.app.repository.VeiculoDao;

@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoDao veiculoDao;
	
	public Veiculo novo(){
		return new Veiculo();
	}
	
	
	public void salvar(Veiculo veiculo){
		veiculoDao.salvar(veiculo);
	}
	
	public void inativar(Veiculo veiculo){
		veiculoDao.inativar();
	}

}
