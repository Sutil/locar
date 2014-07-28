package br.com.locar.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.locar.app.bean.CategoriaBean;
import br.com.locar.app.model.dao.CategoriaRepository;
import br.com.locar.app.model.entity.Categoria;

@Controller
public class CategoriaController {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> autocomplete(String value){
		return categoriaRepository.autocomplete(value);
	}
	
	public CategoriaBean newBean(){
		return new CategoriaBean();
	}
	
	public List<Categoria> getCategorias(){
		return categoriaRepository.findAll();
	}
	
	public Categoria salvar(Categoria categoria){
		return categoriaRepository.save(categoria);
	}
	
	public void desativar(Categoria categoria){
		categoriaRepository.desativar(categoria);
	}
	
	
}
