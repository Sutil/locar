package br.com.locar.app.controller;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.bean.LojaBean;
import br.com.locar.app.bean.LojaFiltro;
import br.com.locar.app.model.dao.LojaRepository;
import br.com.locar.app.model.entity.Loja;

@Controller
public class LojaController extends LocarController {
	
	@Autowired
	private LojaRepository repository;
	
	public LojaFiltro newFiltro(){
		return new LojaFiltro();
	}
	
	public LojaBean newBean(){
		return new LojaBean();
	}
	
	public LojaBean newBeanParaEdicao(Loja loja){
		return new LojaBean(loja);
	}
	
	public List<Loja> pesquisar(LojaFiltro filtro){
		return repository.pesquisar(filtro);
	}
	
	@Transactional
	public void salvar(LojaBean bean){
		try {
			repository.salvar(bean);
			message(SEVERITY_INFO, "Loja salva com sucesso.", "");
		} catch (Exception e) {
			message(SEVERITY_ERROR, "Erro ao salvar loja.", e.getMessage());
		}
	}

}
