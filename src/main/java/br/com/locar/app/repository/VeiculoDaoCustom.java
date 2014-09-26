package br.com.locar.app.repository;

import br.com.locar.app.model.entity.Veiculo;

public interface VeiculoDaoCustom {
	
	public void salvar(Veiculo veiculo);
	public void inativar();

}
