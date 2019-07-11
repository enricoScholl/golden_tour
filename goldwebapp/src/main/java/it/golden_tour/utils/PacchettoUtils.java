package it.golden_tour.utils;

import it.golden_tour.dto.PacchettoDto;
import it.golden_tour.entities.PacchettoVo;

public class PacchettoUtils {

	public static PacchettoDto fromVoToDto(PacchettoVo vo) {
		PacchettoDto dto = new PacchettoDto();
		dto.setId(vo.getId());
		dto.setDestinazione(vo.getDestinazione());
		dto.setIdProdotto(vo.getIdProdotto());
		dto.setPrezzoPacchetto(vo.getPrezzoPacchetto());
		return dto;		
	}
	
	public static PacchettoVo fromDtoToVo(PacchettoDto dto) {
		PacchettoVo vo = new PacchettoVo();
		vo.setId(dto.getId());
		vo.setIdProdotto(dto.getIdProdotto());
		vo.setDestinazione(dto.getDestinazione());
		vo.setPrezzoPacchetto(dto.getPrezzoPacchetto());
		return vo;
	}
}
