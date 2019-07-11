package it.golden_tour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.golden_tour.dto.PacchettoDto;
import it.golden_tour.protocol.ResponseMessage;
import it.golden_tour.services.PacchettoService;

@RestController
@RequestMapping("/pacchetto")
public class PacchettoController {
	
	@Autowired
	PacchettoService pacchettoService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> getAllPacchetti(){
		
		List<PacchettoDto> listaPacchetti;
		ResponseMessage rm = new ResponseMessage();
		try {
			listaPacchetti = pacchettoService.getAllPacchetti();
			rm.setCode("OK");
			rm.setData(listaPacchetti);
		} catch (Exception e) {
			e.printStackTrace();
			rm.setCode("KO");
			rm.getErrorMessages().add("Errore di controller; Select all Pacchetti");
		}
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.OK);
	}

}
