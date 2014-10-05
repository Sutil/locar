package br.com.locar.app.controller;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.locar.app.bean.CategoriaBean;
import br.com.locar.app.bean.CategoriaFiltro;
import br.com.locar.app.model.dao.CategoriaRepository;
import br.com.locar.app.model.entity.Categoria;

@Controller
public class CategoriaController extends LocarController{

	
	private static final String MSG_ERRO_AO_SALVAR_CATEGORIA = "Erro ao salvar categoria";
	private static final String MSG_CATEGORIA_SALVA_COM_SUCESSO = "Categoria salva com sucesso";
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
		try {
			categoriaRepository.salvar(bean);
			message(SEVERITY_INFO, MSG_CATEGORIA_SALVA_COM_SUCESSO, "");
		} catch (Exception e) {
			message(SEVERITY_ERROR, MSG_ERRO_AO_SALVAR_CATEGORIA, e.getMessage());
		}
		
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
