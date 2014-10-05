package br.com.locar.app.model.dao;

import br.com.locar.app.bean.VeiculoBean;
import br.com.locar.app.model.entity.Veiculo;

public interface VeiculoRepositoryCustom {
	
	public Veiculo salvar(VeiculoBean veiculo);
	public void inativar();

}
