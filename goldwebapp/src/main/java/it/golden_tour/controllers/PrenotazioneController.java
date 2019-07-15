package it.golden_tour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.golden_tour.dto.PrenotazioneDto;
import it.golden_tour.protocol.ResponseMessage;
import it.golden_tour.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {
	
	@Autowired(required = true)
	private PrenotazioneService prenotazioneService;
	
	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> getAllPrenotazioniById(@PathVariable("id") long id){
		
		List<PrenotazioneDto> listaPrenotazioni;
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
	
	@RequestMapping(value = "/info/{id_user}", method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> getDettaglioPrenotazione(@PathVariable("id_pren") long id_user, @RequestBody String id_pren){
		ResponseMessage rm = new ResponseMessage();
		try {
			PrenotazioneDto pren_dto = prenotazioneService.getDettaglioPrenotazione(id_user, id_pren);
			rm.setCode("OK");
			rm.setData(pren_dto);
			
		} catch (Exception e) {
			e.printStackTrace();
    		rm.setCode("KO");
    		rm.getErrorMessages().add("Errore di controller; get Dettaglio Prenotazione");
		}
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.OK);
	}

	
}
