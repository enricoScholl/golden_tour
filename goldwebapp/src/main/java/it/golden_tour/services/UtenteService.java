package it.golden_tour.services;

import it.golden_tour.entities.UtenteVo;

public interface UtenteService {
	
	void saveUser(UtenteVo utente) throws Exception;
	UtenteVo login(String username, String password) throws Exception;


}
