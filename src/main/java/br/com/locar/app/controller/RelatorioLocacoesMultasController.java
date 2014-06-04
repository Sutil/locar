package br.com.locar.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.google.common.collect.Lists;

import br.com.locar.app.bean.ItemRelatorioMultasLocacoes;

@Controller
public class RelatorioLocacoesMultasController {
	
	public List<ItemRelatorioMultasLocacoes> getRelatorio(){
		List<ItemRelatorioMultasLocacoes> itens = Lists.newArrayList();
		ItemRelatorioMultasLocacoes multa = new ItemRelatorioMultasLocacoes("01/05/2014", "Multa", "195,00", true);
		ItemRelatorioMultasLocacoes multa1 = new ItemRelatorioMultasLocacoes("05/05/2014","Multa", "80,00", true);
		ItemRelatorioMultasLocacoes multa2 = new ItemRelatorioMultasLocacoes("07/05/2014","Multa", "60,00", true);
		ItemRelatorioMultasLocacoes multa5 = new ItemRelatorioMultasLocacoes("20/05/2004","Multa", "93,00", true);
		
		
		ItemRelatorioMultasLocacoes loc = new ItemRelatorioMultasLocacoes("01/05/2014", "Locações", "350,00", false);
		ItemRelatorioMultasLocacoes loc1 = new ItemRelatorioMultasLocacoes("02/05/2014", "Locações", "280,00", false);
		ItemRelatorioMultasLocacoes loc2 = new ItemRelatorioMultasLocacoes("02/05/2014", "Locações", "785,00", false);
		ItemRelatorioMultasLocacoes loc3 = new ItemRelatorioMultasLocacoes("03/05/2014", "Locações", "932,00", false);
		ItemRelatorioMultasLocacoes loc4 = new ItemRelatorioMultasLocacoes("07/05/2014", "Locações", "70,00", false);
		ItemRelatorioMultasLocacoes loc5 = new ItemRelatorioMultasLocacoes("15/05/2014", "Locações", "140,00", false);
		ItemRelatorioMultasLocacoes loc6 = new ItemRelatorioMultasLocacoes("16/05/2014", "Locações", "70,00", false);
		
		itens.add(multa);
		itens.add(loc);
		itens.add(loc1);
		itens.add(loc2);
		itens.add(loc3);
		itens.add(multa1);
		itens.add(multa2);
		itens.add(loc4);
		itens.add(loc5);
		itens.add(loc6);
		itens.add(multa5);
		return itens;
	}

}
