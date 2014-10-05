package br.com.locar.app.controller;

import static javax.faces.context.FacesContext.getCurrentInstance;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

public class LocarController {
	
	protected void message(Severity severity, String message, String detalhes){
		getCurrentInstance().addMessage(null, new FacesMessage(severity, message, detalhes));
	}

}
