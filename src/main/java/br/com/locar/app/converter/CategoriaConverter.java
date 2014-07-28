package br.com.locar.app.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.google.common.base.Strings;

import br.com.locar.app.model.dao.CategoriaRepository;
import br.com.locar.app.model.entity.Categoria;

@Configurable
@FacesConverter(forClass= Categoria.class, value = "categoriaConverter")
public class CategoriaConverter implements Converter {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(!Strings.isNullOrEmpty(value)){
			Long id = Long.parseLong(value);
			return categoriaRepository.findOne(id);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value != null){
			Categoria c = (Categoria) value;
			return c.getId().toString();
		}
		return null;
	}

}
