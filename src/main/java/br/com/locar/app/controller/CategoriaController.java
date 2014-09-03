package br.com.locar.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.locar.app.bean.CategoriaBean;
import br.com.locar.app.bean.CategoriaFiltro;
import br.com.locar.app.model.dao.CategoriaRepository;
import br.com.locar.app.model.entity.Categoria;

@Controller
public class CategoriaController {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public CategoriaBean newBean(){
		return new CategoriaBean();
	}
	
	public CategoriaFiltro newFiltro(){
		return new CategoriaFiltro();
	}
	
	public List<Categoria> getCategorias(){
		return categoriaRepository.findAll();
	}
	
	public void salvar(CategoriaBean bean){
		categoriaRepository.salvar(bean);
	}
	
	public void desativar(Categoria categoria){
		categoriaRepository.desativar(categoria);
	}
	
	public List<Categoria> pesquisarPorNome(CategoriaFiltro filtro){
		return categoriaRepository.pesquisar(filtro);
	}
	
	public CategoriaBean selecionar(Categoria categoria){
		return CategoriaBean.newInstance(categoria);
	}
	
	
}
