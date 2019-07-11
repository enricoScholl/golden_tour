package it.golden_tour.services;

import java.util.List;

import it.golden_tour.entities.ProdottoVo;
import it.golden_tour.entities.UtenteVo;

public interface AdminService {
	
	List<UtenteVo> listaClienti(Long id) throws Exception;

    void updateCliente(UtenteVo cliente, Long id) throws Exception;

    void deleteCliente(UtenteVo cliente, Long id) throws Exception;

    List<ProdottoVo> listaProdotti(Long id) throws Exception;

    void updateProdotto(ProdottoVo prodotto, Long id) throws Exception;

    void deleteProdotto(ProdottoVo prodotto, Long id) throws Exception;


}
