package br.com.locar.app.bean;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

import br.com.locar.app.login.seguranca.PerfilUsuario;
import br.com.locar.app.login.seguranca.Usuario;
import br.com.locar.app.model.entity.Loja;


public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer version;

	private String login;

	private String senha = "123";
	
	private PerfilUsuario perfil;
	
	private List<Loja> lojas = Lists.newArrayList();
	
	public UsuarioBean(){}
	
	private UsuarioBean(Usuario user){
		this.id = user.getId();
		this.version = user.getVersion();
		this.login = user.getLogin();
		this.senha = user.getSenha();
		this.perfil = user.getPerfil();
		this.lojas = user.getLojas();
	}
	
	public static UsuarioBean newInstance(Usuario user){
		checkNotNull(user, "Não é possível criar um bean com o usuári nulo");
		return new UsuarioBean(user);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public PerfilUsuario getPerfil() {
		return perfil;
	}
	
	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil;
	}
	
	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}
	
	public List<Loja> getLojas() {
		return lojas;
	}
	
}
