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

import it.golden_tour.dto.LoginDto;
import it.golden_tour.dto.UtenteDto;
import it.golden_tour.entities.UtenteVo;
import it.golden_tour.services.AdminService;
import it.golden_tour.services.UtenteService;

@RestController
@RequestMapping("/api")
public class UtenteController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private UtenteService utenteService;
	
	//----------------------------------Login---------------------------------------------------//
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<UtenteVo> login(@RequestBody LoginDto loginDto) {
		try {
			UtenteVo vo = utenteService.login(loginDto.getUsername(), loginDto.getPassword());
			return new ResponseEntity<UtenteVo>(vo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<UtenteVo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//----------------------------------Retrieve All Clients------------------------------------//
	
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<UtenteDto>> listaClienti(@PathVariable("id") Long id) {
		List<UtenteDto> clienti;
		try {
			
			clienti = adminService.listaClienti(id);
			if(clienti.isEmpty()){
    			return new ResponseEntity<List<UtenteDto>>(HttpStatus.NO_CONTENT);
    		}
    		return new ResponseEntity<List<UtenteDto>>(clienti, HttpStatus.OK);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<List<UtenteDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
	}
}
