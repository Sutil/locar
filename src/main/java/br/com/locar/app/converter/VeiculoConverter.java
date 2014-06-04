package br.com.locar.app.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.google.common.base.Strings;

import br.com.locar.app.model.entity.Veiculo;
import br.com.locar.app.repository.VeiculoDao;

@FacesConverter(forClass = Veiculo.class, value="veiculoConverter")
public class VeiculoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(!Strings.isNullOrEmpty(value)){
			return VeiculoDao.getInstance().find(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value != null && value instanceof Veiculo){
			Veiculo v = (Veiculo) value;
			return v.getPlaca();
		}
		return null;
	}

}
