@TypeDefs({
	@TypeDef(name="placa", defaultForType=Placa.class, typeClass = PlacaUserType.class),
	@TypeDef(name="renavan", defaultForType=Renavan.class, typeClass=RenavamUserType.class)
})




package br.com.locar.app.userType;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import br.com.locar.app.model.types.Placa;
import br.com.locar.app.model.types.Renavan;

