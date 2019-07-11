package it.golden_tour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.golden_tour.entities.ProdottoVo;
import it.golden_tour.services.AdminService;

@RestController
@RequestMapping("/api")
public class ProdottoController {
	
	@Autowired
	private AdminService adminService;
	
	//--------------------------------Retrieve All Products------------------------//
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<ProdottoVo>> listaProdotti(@PathVariable("id") Long id) {
		List<ProdottoVo> prodotti;
		try {
			
			prodotti = adminService.listaProdotti(id);
			if(prodotti.isEmpty()){
    			return new ResponseEntity<List<ProdottoVo>>(HttpStatus.NO_CONTENT);
    		}
    		return new ResponseEntity<List<ProdottoVo>>(prodotti, HttpStatus.OK);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<List<ProdottoVo>>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
	}
}
