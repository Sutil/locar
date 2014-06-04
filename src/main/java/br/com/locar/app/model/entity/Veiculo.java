package br.com.locar.app.model.entity;

import java.io.Serializable;

import com.google.common.base.Objects;

public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Categoria categoria;
	private String marca;
	private String modelo;
	private int ano;
	private String placa;
	private String renavam;

	public Veiculo() {
		// TODO Auto-generated constructor stub
	}

	public Veiculo(Categoria categoria, String marca, String modelo, int ano,
			String placa, String renavam) {
		this.categoria = categoria;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
		this.renavam = renavam;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Veiculo){
			Veiculo other = (Veiculo) obj;
			return Objects.equal(this.placa, other.placa);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(placa);
	}

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

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

}
