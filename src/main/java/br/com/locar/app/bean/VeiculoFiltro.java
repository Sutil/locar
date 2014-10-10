package br.com.locar.app.bean;

import java.io.Serializable;

import br.com.locar.app.model.entity.Categoria;
import br.com.locar.app.model.types.Renavan;

public class VeiculoFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Categoria categoria;
	private String marca;
	private String modelo;
	private int ano;
	private String placa;
	private Renavan renavam;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Renavan getRenavam() {
		return renavam;
	}

	public void setRenavam(Renavan renavam) {
		this.renavam = renavam;
	}

}
