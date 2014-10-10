package br.com.locar.app.bean;

import java.io.Serializable;

import br.com.locar.app.model.entity.Categoria;

public class VeiculoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Categoria categoria;
	private String marca;
	private String modelo;
	private int ano;
	private String placa;
	private String renavam;

	public Long getId() {
		return id;
	}

	public VeiculoBean setId(Long id) {
		this.id = id;
		return this;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public VeiculoBean setCategoria(Categoria categoria) {
		this.categoria = categoria;
		return this;
	}

	public String getMarca() {
		return marca;
	}

	public VeiculoBean setMarca(String marca) {
		this.marca = marca;
		return this;
	}

	public String getModelo() {
		return modelo;
	}

	public VeiculoBean setModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public int getAno() {
		return ano;
	}

	public VeiculoBean setAno(int ano) {
		this.ano = ano;
		return this;
	}

	public String getPlaca() {
		return placa;
	}

	public VeiculoBean setPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public String getRenavam() {
		return renavam;
	}

	public VeiculoBean setRenavam(String renavam) {
		this.renavam = renavam;
		return this;
	}

}
