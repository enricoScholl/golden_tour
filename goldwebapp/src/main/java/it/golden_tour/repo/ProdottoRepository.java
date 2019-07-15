package it.golden_tour.repo;

import java.util.List;

import it.golden_tour.entities.ProdottoVo;

public interface ProdottoRepository {

void insertProdotto(ProdottoVo prodotto) throws Exception;
	
	void deleteProdotto(ProdottoVo prodotto) throws Exception;
	
	void updateProdotto(ProdottoVo prodotto) throws Exception;
	
	List<ProdottoVo> getAllProdotti(Long id) throws Exception;
	
	
}
