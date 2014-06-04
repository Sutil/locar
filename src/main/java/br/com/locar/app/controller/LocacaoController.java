package br.com.locar.app.controller;

import org.springframework.stereotype.Controller;

import br.com.locar.app.model.entity.locacao.LocacaoBean;

@Controller
public class LocacaoController {

	public LocacaoBean novo(){
		return new LocacaoBean();
	}
}
