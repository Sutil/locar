package br.com.locar.app.model.dao;

import br.com.locar.app.bean.PerfilUsuarioBean;
import br.com.locar.app.login.seguranca.PerfilUsuario;

public interface PerfilUsuariorepositoryCustom {
	
	public PerfilUsuario salvar(PerfilUsuarioBean bean);

}
