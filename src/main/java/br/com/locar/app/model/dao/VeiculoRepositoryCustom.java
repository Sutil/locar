package br.com.locar.app.model.dao;

import java.util.List;

import br.com.locar.app.bean.VeiculoBean;
import br.com.locar.app.bean.VeiculoFiltro;
import br.com.locar.app.model.entity.Veiculo;

public interface VeiculoRepositoryCustom {
	
	public Veiculo salvar(VeiculoBean veiculo);
	public void inativar();
	public List<Veiculo> pesquisar(VeiculoFiltro filtro);

}
