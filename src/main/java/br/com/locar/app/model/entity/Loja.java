package br.com.locar.app.model.entity;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.locar.app.bean.LojaBean;

import com.google.common.base.Strings;

@Entity
public class Loja extends Entidade {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	public Loja() {
	}

	private Loja(LojaBean bean) {
		this.id = bean.getId();
		this.nome = bean.getNome();
	}

	public static Loja newInstance(LojaBean bean) {
		checkNotNull(bean, "Os dados de entrada estão incorretos.");
		checkArgument(!Strings.isNullOrEmpty(bean.getNome()),
				"Nome da loja não foi informado.");
		return new Loja(bean);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
