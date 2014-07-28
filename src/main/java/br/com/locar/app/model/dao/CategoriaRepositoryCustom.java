package br.com.locar.app.model.dao;

import java.util.List;

import br.com.locar.app.model.entity.Categoria;

public interface CategoriaRepositoryCustom {
	
	public List<Categoria> autocomplete(String value);
	
	public void desativar(Categoria categoria);
	
	

}
