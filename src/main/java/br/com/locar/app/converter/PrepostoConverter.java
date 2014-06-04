package br.com.locar.app.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.locar.app.model.entity.Cliente;
import br.com.locar.app.model.entity.Preposto;
import br.com.locar.app.repository.ClienteDao;

import com.google.common.base.Strings;

@FacesConverter(forClass = Preposto.class, value="prepostoConverter")
public class PrepostoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(!Strings.isNullOrEmpty(value)){
			List<Cliente> lista = ClienteDao.getInstance().getLista();
			for(Cliente c : lista){
				for(Preposto p : c.getPrepostos()){
					if(value.equals(p.getNome())){
						return p;
					}
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value != null && value instanceof Preposto){
			Preposto p = (Preposto) value;
			return p.getNome();
		}
		return null;
	}

}
