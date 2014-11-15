package br.com.locar.app.model.dao;

import br.com.locar.app.model.entity.Reserva;

public interface ReservaRepositoryCustom {
	
	Reserva salvar(Reserva reserva);
	Reserva cancelar(Reserva reserva);

}
