package br.com.locar.app;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.locar.app.bean.CategoriaBean;
import br.com.locar.app.bean.LojaBean;
import br.com.locar.app.model.dao.CategoriaRepository;
import br.com.locar.app.model.dao.LojaRepository;
import br.com.locar.app.model.entity.Categoria;

@Component
public class AmbienteComCategoriaELojaCadastradas {
	
	@Autowired
	protected CategoriaRepository categoriaRepository;
	
	@Autowired
	protected LojaRepository lojaRepository;
	
	public void setUp(){
		Categoria categoria = Categoria.newInstance(montaBean("Categoria teste",  new BigDecimal("10.00")));
		categoriaRepository.salvar(categoria);
		
		lojaRepository.salvar(montaBeanLoja());
	}
	
	public void turnDown(){
		categoriaRepository.deleteAll();
		lojaRepository.deleteAll();
	}
	
	private CategoriaBean montaBean(String nomeCategoria, BigDecimal valorDiaRiaEOutros) {
		CategoriaBean bean = new CategoriaBean();
		bean.setNome(nomeCategoria);
		bean.setDiaria(valorDiaRiaEOutros);
		bean.setProtecaoOcupantes(valorDiaRiaEOutros);
		bean.setProtecaoTerceiros(valorDiaRiaEOutros);
		bean.setTaxaReposicaoDocumentos(valorDiaRiaEOutros);
		bean.setTaxaDevolucaoLojaDiferente(valorDiaRiaEOutros);
		return bean;
	}
	
	private LojaBean montaBeanLoja(){
		LojaBean bean = new LojaBean();
		bean.setNome("loja1");
		return bean;
	}

}
