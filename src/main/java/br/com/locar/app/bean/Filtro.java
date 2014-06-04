package br.com.locar.app.bean;

import java.io.Serializable;

import br.com.locar.app.model.entity.Veiculo;

public class Filtro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Veiculo veiculo;
	
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
