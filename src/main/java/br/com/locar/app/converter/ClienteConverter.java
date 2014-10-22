package br.com.locar.app.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.google.common.base.Strings;

import br.com.locar.app.model.dao.ClienteRepository;
import br.com.locar.app.model.entity.Cliente;

@Configurable
@FacesConverter(forClass = Cliente.class, value = "clienteConverter")
public class ClienteConverter implements Converter{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(!Strings.isNullOrEmpty(value)){
			long id = Long.parseLong(value);
			return clienteRepository.findOne(id);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value != null){
			Cliente cliente = (Cliente) value;
			return cliente.getId().toString();
		}
		return "";
	}

}
