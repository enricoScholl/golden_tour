package it.golden_tour.repo;

import java.util.List;

import it.golden_tour.entities.ProdottoVo;
import it.golden_tour.entities.UtenteVo;

public interface AdminRepository {
	
	boolean isAdmin(Long id) throws Exception;
	
	List<UtenteVo> listaClienti() throws Exception;
	
	void updateCliente(UtenteVo cliente) throws Exception;
	
	void deleteCliente(UtenteVo cliente) throws Exception;
	
	List<ProdottoVo> listaProdotti() throws Exception;
	
	void updateProdotto(ProdottoVo prodotto) throws Exception;
	
	void deleteProdotto(ProdottoVo prodotto) throws Exception;

}
