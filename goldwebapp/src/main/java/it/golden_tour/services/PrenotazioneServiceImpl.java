package it.golden_tour.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.golden_tour.entities.PrenotazioneVo;
import it.golden_tour.repo.PrenotazioneRepository;

@Service("prenotazioneService")
public class PrenotazioneServiceImpl implements PrenotazioneService {
	
	@Autowired(required = true)
	PrenotazioneRepository prenotazioneRepository;

	@Override
	public List<PrenotazioneVo> getAllPrenotazioniFromId(Long id) throws Exception {
		return prenotazioneRepository.getAllPrenotazioniByUser(id);
	}

}
