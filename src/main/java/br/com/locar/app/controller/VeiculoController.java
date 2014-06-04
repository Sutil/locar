package br.com.locar.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import br.com.locar.app.bean.Filtro;
import br.com.locar.app.model.entity.Veiculo;
import br.com.locar.app.repository.VeiculoDao;

import com.google.common.collect.Lists;

@Controller
public class VeiculoController {
	
	public List<String> getVeiculos(){
		List<String> veiculos = Lists.newArrayList();
		veiculos.add("");
		veiculos.add("");
		veiculos.add("");
		veiculos.add("");
		veiculos.add("");
		return veiculos;
	}
	
	public List<Veiculo> autocompleteVeiculo(String value){
		return VeiculoDao.getInstance().getLista();
	}
	
	public Filtro getFiltro(){
		return new Filtro();
	}

}
