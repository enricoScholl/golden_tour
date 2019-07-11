package it.golden_tour.repo;

import java.util.List;

import it.golden_tour.entities.PrenotazioneVo;

public interface PrenotazioneRepository {

	void insertPrenotazione(PrenotazioneVo prenotazione) throws Exception;
	
	void deletePrenotazione(PrenotazioneVo prenotazione) throws Exception;
	
	void updatePrenotazione(PrenotazioneVo prenotazione) throws Exception;
	
	List<PrenotazioneVo> getAllPrenotazioniByUser(Long id) throws Exception;
	
	PrenotazioneVo getDettaglioPrenotazione(Long id_user, String id_pren) throws Exception;
}