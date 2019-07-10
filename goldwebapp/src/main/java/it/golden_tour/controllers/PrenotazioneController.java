package it.golden_tour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.golden_tour.entities.PrenotazioneVo;
import it.golden_tour.protocol.ResponseMessage;
import it.golden_tour.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {
	
	@Autowired
	private PrenotazioneService prenotazioneService;
	
	//-------------------Retrieve All Prenotazioni
	
	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> getAllPrenotazioniById(@PathVariable("id") long id){
		
		List<PrenotazioneVo> listaPrenotazioni;
		ResponseMessage rm = new ResponseMessage();
		try {
			listaPrenotazioni = prenotazioneService.getAllPrenotazioniFromId(id);
			
			rm.setCode("OK");
    		rm.setData(listaPrenotazioni);
		} catch (Exception e) {
			e.printStackTrace();
    		rm.setCode("KO");
    		rm.getErrorMessages().add("Errore di controller; Select All Prenotazioni by Id");
		}
		
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.OK);
	}

	
}
