package br.com.locar.app.bean;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import br.com.locar.app.login.seguranca.Usuario;

import com.google.common.base.Strings;

public class AlteracaoDeSenhaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private String senhaAtual;
	private String novaSenha;
	private String confirmacaoNovaSenha;
	
	public AlteracaoDeSenhaBean(Usuario usuario){
		checkNotNull(usuario, "Usuário não informado.");
		this.usuario = usuario;
	}
	
	public void alteraSenha() {
		validaDados();
		usuario.setSenha(novaSenha);
	}
	
	private void validaDados(){
		usuario.validaSenha(senhaAtual);
		validaNovaSenha();
	}
	
	private void validaNovaSenha() {
		if(Strings.isNullOrEmpty(novaSenha) || novaSenha.length() < 5){
			throw new RuntimeException("Nova senha deve ter no mínimo 5 caracteres");
		}
		if(!novaSenha.equals(confirmacaoNovaSenha)){
			throw new RuntimeException("Confirmação de senha não confere.");
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmacaoNovaSenha() {
		return confirmacaoNovaSenha;
	}

	public void setConfirmacaoNovaSenha(String confirmacaoNovaSenha) {
		this.confirmacaoNovaSenha = confirmacaoNovaSenha;
	}

}
