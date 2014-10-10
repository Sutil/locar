package br.com.locar.app.model.entity;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import br.com.locar.app.bean.VeiculoBean;
import br.com.locar.app.model.types.Placa;
import br.com.locar.app.model.types.Renavan;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

@Entity
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "categoria_fk")
	private Categoria categoria;
	private Loja local;
	private String marca;
	private String modelo;
	private int ano;
	
	@Type(type = "placa")
	private Placa placa;
	
	@Type(type = "renavan")
	private Renavan renavan;

	public Veiculo() {
	}

	private Veiculo(Categoria categoria, Loja loja, String marca, String modelo, int ano,
			String placa, String renavam) {
		this.categoria = categoria;
		this.local = loja;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.placa = Placa.fromString(placa);
		this.renavan = Renavan.fromString(renavam);
	}
	
	public static Veiculo newInstance(VeiculoBean bean){
		checkNotNull(bean.getCategoria(), "Categoria não informada.");
		checkArgument(!Strings.isNullOrEmpty(bean.getMarca()), "Marca não informada.");
		checkArgument(!Strings.isNullOrEmpty(bean.getModelo()), "Modelo não informado.");
		return new Veiculo(bean.getCategoria(), null, bean.getMarca(), bean.getModelo(), bean.getAno(), 
				bean.getPlaca(), bean.getRenavam());
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
	
	public Long getId() {
		return id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAno() {
		return ano;
	}

	public String getPlaca() {
		return placa.toString();
	}

	public String getRenavam() {
		return renavan.toString();
	}
	
	public Loja getLocal() {
		return local;
	}

}
