package br.com.locar.app.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.locar.app.bean.ObraBean;
import br.com.locar.app.model.Autor;
import br.com.locar.app.model.Categoria;
import br.com.locar.app.model.DisposicaoParaEmprestimo;
import br.com.locar.app.model.Exemplar;
import br.com.locar.app.model.Obra;
import br.com.locar.app.model.QAutor;
import br.com.locar.app.repository.AutorRepository;
import br.com.locar.app.repository.ExemplarRepository;
import br.com.locar.app.repository.ObraRepository;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.mysema.query.BooleanBuilder;

@Controller
public class ObraController {

	@Autowired
	private ObraRepository obraRepository;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private ExemplarRepository exemplarRepository;

	public ObraBean novo() {
		return new ObraBean();
	}

	public List<Categoria> getCategorias() {
		return new ArrayList<Categoria>(Categoria.getMapvalues().values());
	}

	public List<DisposicaoParaEmprestimo> getDisposicoes() {
		return new ArrayList<DisposicaoParaEmprestimo>(DisposicaoParaEmprestimo.getMapValues().values());
	}

	public List<Autor> completeAutores(String value) {
		List<Autor> autores = Lists.newLinkedList();
		if (!Strings.isNullOrEmpty(value)) {
			BooleanBuilder builderBusca = new BooleanBuilder();
			builderBusca.or(QAutor.autor.nome.containsIgnoreCase(value));
			builderBusca.or(QAutor.autor.sobrenome.containsIgnoreCase(value));
			BooleanBuilder builder = new BooleanBuilder();
			builder.and(builderBusca);
			autores = autorRepository.findAll(builder);
		}
		return autores;
	}

	public List<Obra> pesquisar() {
		return obraRepository.findAll();
	}

	public List<Exemplar> addExemplar(DataModel<Exemplar> model) {
		Iterator<Exemplar> iterator = model.iterator();
		List<Exemplar> exemplares = Lists.newArrayList();
		while (iterator.hasNext()) {
			exemplares.add(iterator.next());
		}
		Exemplar exemplar = new Exemplar();
		exemplar.setIdentificador(geraCodigo(exemplares));
		exemplares.add(exemplar);
		return exemplares;
	}

	private Integer geraCodigo(List<Exemplar> exemplares) {
		Integer codigo = 1;
		for (Exemplar e : exemplares) {
			if (e != null && e.getIdentificador().compareTo(codigo) >= 0) {
				codigo = e.getIdentificador() + 1;
			}
		}
		return codigo;
	}

	@Transactional
	public void save(ObraBean bean, DataModel<Exemplar> model) {
		try {
			Iterator<Exemplar> i = model.iterator();
			List<Exemplar> exemplares = Lists.newArrayList();
			while (i.hasNext()) {
				exemplares.add(i.next());
			}
			bean.setExemplares(exemplares);
			Obra obra = Obra.newInstance(bean);
			Obra saved = obraRepository.save(obra);
			if(saved != null){
				addMessageInfo("Salvo com sucesso", "obra salva com id "+saved.getId());
			}
			else{
				addMessageError("Erro", "Não foi possível salvar obra");
			}
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("Erro ao salvar obra", e.getMessage());
		}
	}
	
	public ObraBean editarObra(Obra obra){
		try{
			return new ObraBean(obra);
		}
		catch(Exception e){
			addMessageError("Erro", e.getMessage());
			return new ObraBean();
		}
	}
	
	public void deletarObra(Obra obra){
		try{
			obraRepository.delete(obra);
			addMessageInfo("Obra deletada", "");
		}
		catch(Exception e){
			addMessageError("Erro ao deletar obra", e.getMessage());
		}
	}

	private void addMessageError(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));
	}

	private void addMessageInfo(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));
	}

}
