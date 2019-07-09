package it.golden_tour.repo;

import it.golden_tour.entities.UtenteVo;

public interface UtenteRepository {
	
	void newUser(UtenteVo utente);
	
	UtenteVo login(String username, String password);
	
	boolean profileType(Long id);

}
