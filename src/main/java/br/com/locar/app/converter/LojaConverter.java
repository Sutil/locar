package br.com.locar.app.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import br.com.locar.app.model.dao.LojaRepository;
import br.com.locar.app.model.entity.Loja;

@Configurable
@FacesConverter(value = "lojaConverter", forClass=Loja.class)
public class LojaConverter implements Converter {
	
	@Autowired
	private LojaRepository lojaRepository;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value != null){
			Long id = Long.parseLong(value);
			return lojaRepository.findOne(id);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value != null){
			Loja loja = (Loja) value;
			return String.valueOf(loja.getId());
		}
		return null;
	}

}
