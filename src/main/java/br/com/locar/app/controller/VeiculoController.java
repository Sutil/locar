package br.com.locar.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

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

}
