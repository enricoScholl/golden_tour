package it.golden_tour.repo;

import it.golden_tour.entities.UtenteVo;

public interface UtenteRepository {
	
	void newUser(UtenteVo utente) throws Exception;
	
	UtenteVo login(String username, String password) throws Exception;
	
}
