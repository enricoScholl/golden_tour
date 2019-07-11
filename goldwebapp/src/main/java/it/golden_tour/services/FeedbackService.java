package it.golden_tour.services;

import java.util.List;

import it.golden_tour.entities.FeedbackVo;

public interface FeedbackService {

	List<FeedbackVo> getAllFeedback() throws Exception;

	void insert(FeedbackVo feedback) throws Exception;

}