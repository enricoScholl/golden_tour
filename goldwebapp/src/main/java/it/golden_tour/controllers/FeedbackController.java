package it.golden_tour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import it.golden_tour.dto.FeedbackDto;
import it.golden_tour.entities.FeedbackVo;
import it.golden_tour.services.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	//--------------Retrieve All Feedbacks---------------------------
	
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	    public ResponseEntity<List<FeedbackVo>> listAllUsers() {
		 List<FeedbackVo> feedbacks;
		 try {
	    		feedbacks = feedbackService.getAllFeedback();
	    		
	    		if(feedbacks.isEmpty()){
	    			return new ResponseEntity< List<FeedbackVo>>(HttpStatus.NO_CONTENT);
	    		}
	    		return new ResponseEntity< List<FeedbackVo>>(feedbacks, HttpStatus.OK);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		return new ResponseEntity<List<FeedbackVo>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	 }
	 
	 
	 
	 //----------------Create a feedback ----------------------------
	 
	// @RequestMapping(value = "/feedback/insert", method = RequestMethod.POST)
	//    public ResponseEntity<Void> createFeedback(@RequestBody FeedbackDto feedback, UriComponentsBuilder ucBuilder) {
	    
		 
	//    }
	 
}


