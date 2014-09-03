package br.com.locar.app.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.locar.app.model.entity.Categoria;
import br.com.locar.app.model.entity.Veiculo;

public class VeiculoDao {
	
	private static VeiculoDao instance;
	private List<Veiculo> lista = new ArrayList<>();
 	
	public static VeiculoDao getInstance() {
		if(instance == null){
			instance = new VeiculoDao();
		}
		return instance;
	}
	
	
	VeiculoDao(){
		Categoria categoria = new Categoria(null, "Luxo", new BigDecimal("55.00"), new BigDecimal("25.00"), new BigDecimal("80.00"), new BigDecimal("30.00"), new BigDecimal("45.00"), new BigDecimal("40.00"), new BigDecimal("150.00"));
		Veiculo veiculo = new Veiculo(categoria, "Chevrolet", "Vectra", 2014, "AAA-5588", "65498788");
		Veiculo veiculo1 = new Veiculo(categoria, "Chevrolet", "Celta", 2014, "AAA-5588", "65498788");
		Veiculo veiculo2 = new Veiculo(categoria, "Chevrolet", "Prisma", 2014, "AAA-5588", "65498788");
		Veiculo veiculo3 = new Veiculo(categoria, "Chevrolet", "Corsa", 2014, "AAA-5588", "65498788");
		
		
		lista.add(veiculo);
		lista.add(veiculo1);
		lista.add(veiculo2);
		lista.add(veiculo3);
	}
	
	
	public List<Veiculo> getLista() {
		return lista;
	}
	
	public void salvar(Veiculo v){
		if(!lista.contains(v)){
			lista.add(v);
		}
	}
	
	public Veiculo find(String placa){
		for(Veiculo v : lista){
			if(v.getPlaca().toLowerCase().equals(placa.toLowerCase())){
				return v;
			}
		}
		return null;
	}

}
