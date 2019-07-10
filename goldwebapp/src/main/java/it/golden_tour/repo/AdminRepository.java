package it.golden_tour.repo;

import java.util.List;

import it.golden_tour.entities.ProdottoVo;
import it.golden_tour.entities.UtenteVo;

public interface AdminRepository {
	
	boolean isAdmin(Long id);
	
	List<UtenteVo> listaClienti(Long id);
	
	void updateCliente(UtenteVo cliente);
	
	void deleteCliente(UtenteVo cliente);
	
	List<ProdottoVo> listaProdotti();
	
	void updateProdotto(ProdottoVo prodotto);
	
	void deleteProdotto(ProdottoVo prodotto);

}
