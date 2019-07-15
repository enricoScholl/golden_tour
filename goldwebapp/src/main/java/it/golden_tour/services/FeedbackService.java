package it.golden_tour.services;

import java.util.List;

import it.golden_tour.dto.FeedbackDto;
import it.golden_tour.entities.FeedbackVo;

public interface FeedbackService {

	List<FeedbackDto> getAllFeedback() throws Exception;

	void insert(FeedbackDto feedback) throws Exception;
	
	 FeedbackVo fromDtoToVo (FeedbackDto feedDto) throws Exception;

}