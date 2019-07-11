package it.golden_tour.utils;

import it.golden_tour.dto.UtenteDto;
import it.golden_tour.entities.UtenteVo;

public class UtenteUtils {
	
	public static UtenteDto fromVoToDto(UtenteVo vo) {
		
		UtenteDto dto = new UtenteDto();
		dto.setId(vo.getId());
		dto.setTipologia(vo.getTipologia());
		dto.setNome(vo.getNome());
		dto.setCognome(vo.getCognome());
		dto.setUsername(vo.getUsername());
		dto.setPassword(vo.getPassword());
		return dto;
		
	}
	
	public static UtenteVo fromDtoToVo(UtenteDto dto) {
		
		UtenteVo vo = new UtenteVo();
		vo.setId(dto.getId());
		vo.setTipologia(dto.getTipologia());
		vo.setNome(dto.getNome());
		vo.setCognome(dto.getCognome());
		vo.setUsername(dto.getUsername());
		vo.setPassword(dto.getPassword());
		return vo;
		
	}
}
