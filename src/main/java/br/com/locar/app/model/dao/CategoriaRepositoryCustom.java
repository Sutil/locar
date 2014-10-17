package br.com.locar.app.model.dao;

import java.util.List;

import br.com.locar.app.bean.CategoriaBean;
import br.com.locar.app.bean.CategoriaFiltro;
import br.com.locar.app.model.entity.Categoria;

public interface CategoriaRepositoryCustom {
	
	
	public void desativar(Categoria categoria);
	public void salvar(CategoriaBean bean);
	public Categoria salvar(Categoria categoria);
	public List<Categoria> pesquisar(CategoriaFiltro filtro);
	List<Categoria> findAllActives();

}
