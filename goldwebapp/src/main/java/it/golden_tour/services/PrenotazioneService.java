package it.golden_tour.services;

import java.util.List;

import it.golden_tour.entities.PrenotazioneVo;

public interface PrenotazioneService {

	List<PrenotazioneVo> getAllPrenotazioniFromId(Long id) throws Exception;
}
