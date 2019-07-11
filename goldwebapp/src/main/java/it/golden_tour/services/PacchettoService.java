package it.golden_tour.services;

import java.util.List;

import it.golden_tour.dto.PacchettoDto;

public interface PacchettoService {

	List<PacchettoDto> getAllPacchetti() throws Exception;
}
