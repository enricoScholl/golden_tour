package it.golden_tour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.golden_tour.entities.UtenteVo;
import it.golden_tour.services.AdminService;

@RestController
@RequestMapping("/api")
public class UtenteController {
	
	@Autowired
	private AdminService adminService;
	
	//----------------------------------Retrieve All Clients------------------------------------//
	
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<UtenteVo>> listaClienti(@PathVariable("id") Long id) {
		List<UtenteVo> clienti;
		try {
			
			clienti = adminService.listaClienti(id);
			if(clienti.isEmpty()){
    			return new ResponseEntity<List<UtenteVo>>(HttpStatus.NO_CONTENT);
    		}
    		return new ResponseEntity<List<UtenteVo>>(clienti, HttpStatus.OK);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<List<UtenteVo>>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
	}
}
