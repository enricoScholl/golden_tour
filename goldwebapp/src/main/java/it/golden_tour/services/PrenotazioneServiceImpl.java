package it.golden_tour.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.golden_tour.dto.PrenotazioneDto;
import it.golden_tour.entities.PrenotazioneVo;
import it.golden_tour.repo.PrenotazioneRepository;
import it.golden_tour.utils.PrenotazioneUtils;

@Service("prenotazioneService")
public class PrenotazioneServiceImpl implements PrenotazioneService {
	
	@Autowired(required = true)
	PrenotazioneRepository prenotazioneRepository;

	@Override
	public List<PrenotazioneDto> getAllPrenotazioniFromId(Long id) throws Exception {
		List<PrenotazioneDto> listaPrenotazioniDto = new ArrayList<PrenotazioneDto>(); 
		List<PrenotazioneVo> listaPrenotazioniVo = prenotazioneRepository.getAllPrenotazioniByUser(id);
		for (PrenotazioneVo vo : listaPrenotazioniVo) {
			PrenotazioneDto dto = PrenotazioneUtils.fromVoToDto(vo);
			listaPrenotazioniDto.add(dto);
		}
		return listaPrenotazioniDto;
	}

}
