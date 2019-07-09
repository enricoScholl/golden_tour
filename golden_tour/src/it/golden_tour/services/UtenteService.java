package it.golden_tour.services;

import java.util.List;

import it.golden_tour.entities.UtenteVo;

public interface UtenteService {
	
	List<UtenteVo> listAllClients() throws Exception;

}
