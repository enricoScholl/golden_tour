package it.golden_tour.services;

import java.util.List;

import it.golden_tour.dto.PrenotazioneDto;

public interface PrenotazioneService {

	List<PrenotazioneDto> getAllPrenotazioniFromId(Long id) throws Exception;
	
	public PrenotazioneDto getDettaglioPrenotazione(Long id_user, String id_pren) throws Exception;
}
