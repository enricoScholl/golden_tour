package it.golden_tour.repo;

import java.util.List;

import it.golden_tour.entities.FeedbackVo;

public interface FeedbackRepository {

	void insertFeedback(FeedbackVo feedback) throws Exception;

	void deleteFeedback(FeedbackVo feedback) throws Exception;

	void updateFeedback(FeedbackVo feedback) throws Exception;

	List<FeedbackVo> getAllFeedback() throws Exception;

}