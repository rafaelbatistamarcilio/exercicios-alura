package br.com.caelum.empresa.dao;

import java.util.List;

import br.com.caelum.empresa.modelo.Gasto;

public class GastoDAO {
	
    private BaseDao<Gasto> dao = new BaseDao<Gasto>(Gasto.class);

    //métodos inseridos usando delegate ( ctrl + 3 e procurando por delegate) 
	public void adiciona(Gasto entity) {
		dao.adiciona(entity);
	}

	public Gasto buscaPorId(Long id) {
		return dao.buscaPorId(id);
	}

	public List<Gasto> buscaTodos() {
		return dao.buscaTodos();
	}
	
	

}