package it.golden_tour.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.golden_tour.dto.PacchettoDto;
import it.golden_tour.entities.PacchettoVo;
import it.golden_tour.repo.PacchettoRepository;
import it.golden_tour.utils.PacchettoUtils;

@Service("pacchettoService")
public class PacchettoServiceImpl implements PacchettoService {
	
	@Autowired(required = true)
	PacchettoRepository pacchettoRepository;

	@Override
	public List<PacchettoDto> getAllPacchetti() throws Exception {
		List<PacchettoDto> listaPacchettiDto = new ArrayList<PacchettoDto>();
		List<PacchettoVo> listaPacchettiVo = pacchettoRepository.getAllPacchetti();
		for (PacchettoVo vo : listaPacchettiVo) {
			PacchettoDto dto = PacchettoUtils.fromVoToDto(vo);
			listaPacchettiDto.add(dto);			
		}
		return listaPacchettiDto;
	}

}
