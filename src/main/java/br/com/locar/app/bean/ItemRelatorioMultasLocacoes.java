package br.com.locar.app.bean;

import java.io.Serializable;

public class ItemRelatorioMultasLocacoes implements Serializable {

	private static final long serialVersionUID = 1L;

	private String data;
	private String item;
	private String valor;
	private boolean debito;
	
	

	public ItemRelatorioMultasLocacoes(String data, String item, String valor, boolean debito) {
		this.data = data;
		this.item = item;
		this.valor = valor;
		this.debito = debito;
	}
	
	public String getData() {
		return data;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public boolean isDebito() {
		return debito;
	}

	public void setDebito(boolean debito) {
		this.debito = debito;
	}

}
