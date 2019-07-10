package it.golden_tour.repo;

import java.util.List;

import it.golden_tour.entities.PacchettoVo;
import it.golden_tour.entities.PrenotazioneVo;

public interface PacchettoRepository {

	void insertPacchetto(PacchettoVo pacchetto) throws Exception;
	
	void deletePacchetto(PacchettoVo pacchetto) throws Exception;
	
	void updatePacchetto(PacchettoVo pacchetto) throws Exception;
	
	List<PacchettoVo> getAllPacchetti(Long id) throws Exception;

	
}
