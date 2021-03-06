package br.com.locar.app.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.google.common.base.Strings;

import br.com.locar.app.model.dao.VeiculoRepository;
import br.com.locar.app.model.entity.Veiculo;

@Configurable
@FacesConverter(forClass = Veiculo.class, value="veiculoConverter")
public class VeiculoConverter implements Converter{

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(!Strings.isNullOrEmpty(value)){
			Long id = Long.parseLong(value);
			return veiculoRepository.findOne(id);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value != null){
			Veiculo veiculo = (Veiculo) value;
			return veiculo.getId().toString();
		}
		return null;
	}

}
