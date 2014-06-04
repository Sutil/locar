package br.com.locar.app.model.entity.locacao;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;

import br.com.locar.app.model.entity.Veiculo;

public class LocacaoFactory {
	
	public static Locacao factory(LocacaoBean bean){
		checkNotNull(bean, "Erro ao gerar locacão. Valores estão nulos");
		checkNotNull(bean.getPreposto(), "Erro ao gerar locação. Preposto não foi informado");
		checkNotNull(bean.getVeiculo(), "Erro ao gerar locação. Veículo não informado");
		checkNotNull(bean.getDevolucao(), "Informe a data de devolução");
		checkArgument(bean.getDevolucao().before(new Date()), "Data de devolução não pode ser menor que a data atual");
		return new Locacao(bean);
	}
	


}
