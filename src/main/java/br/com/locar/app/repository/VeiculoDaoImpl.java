package br.com.locar.app.repository;

import br.com.locar.app.model.entity.Veiculo;

public class VeiculoDaoImpl implements VeiculoDaoCustom{

	@Override
	public void salvar(Veiculo veiculo) {
		// TODO Auto-generated method stub
		System.out.println("salvando veiculo");
		
	}

	@Override
	public void inativar() {
		System.out.println("inativando veiculo");
		
	}

}
