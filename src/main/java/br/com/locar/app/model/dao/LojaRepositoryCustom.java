package br.com.locar.app.model.dao;

import java.util.List;

import br.com.locar.app.bean.LojaBean;
import br.com.locar.app.bean.LojaFiltro;
import br.com.locar.app.model.entity.Loja;

public interface LojaRepositoryCustom {
	
	public Loja salvar(LojaBean bean);
	public void desativar(Loja loja);
	public List<Loja> pesquisar(LojaFiltro filtro);

}
