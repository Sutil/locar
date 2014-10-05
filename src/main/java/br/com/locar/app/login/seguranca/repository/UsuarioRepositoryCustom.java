package br.com.locar.app.login.seguranca.repository;

import br.com.locar.app.bean.AlteracaoDeSenhaBean;
import br.com.locar.app.login.seguranca.Usuario;

public interface UsuarioRepositoryCustom {
	
	public Usuario findByName(String nome);
	public void alteraSenha(AlteracaoDeSenhaBean bean);

}
