package it.golden_tour.utils;

import it.golden_tour.dto.PrenotazioneDto;
import it.golden_tour.entities.PrenotazioneVo;


public class PrenotazioneUtils {

	public static PrenotazioneDto fromVoToDto(PrenotazioneVo vo) {
		PrenotazioneDto dto = new PrenotazioneDto();
		dto.setId(vo.getId());
		dto.setIdPacchetto(vo.getIdPacchetto());
		dto.setIdUtente(vo.getIdUtente());
		dto.setIdViaggio(vo.getIdViaggio());
		dto.setCostoTotale(vo.getCostoTotale());
		return dto;		
	}
	
	public static PrenotazioneVo fromDtoToVo(PrenotazioneDto dto) {
		PrenotazioneVo vo = new PrenotazioneVo();
		vo.setId(dto.getId());
		vo.setIdPacchetto(dto.getIdPacchetto());
		vo.setIdViaggio(dto.getIdViaggio());
		vo.setIdUtente(dto.getIdUtente());
		vo.setCostoTotale(dto.getCostoTotale());
		return vo;
	}
}
