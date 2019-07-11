package it.golden_tour.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.golden_tour.dto.FeedbackDto;
import it.golden_tour.entities.FeedbackVo;
import it.golden_tour.repo.FeedbackRepository;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	
	@Override
	public List<FeedbackVo> getAllFeedback() throws Exception {
		return feedbackRepository.getAllFeedback();
	}
	
	@Override
	public void insert(FeedbackVo feedback) throws Exception {
		feedbackRepository.insertFeedback(feedback);
	}
	
	public FeedbackVo fromDtoToVo (FeedbackDto feedDto) throws Exception {
		FeedbackVo feedbackVo = new FeedbackVo(); 
		feedbackVo.setId(feedbackRepository.idFeedback());
		feedbackVo.setIdPrenotazione(feedDto.getIdPrenotazione());
		feedbackVo.setOrganizzazioneViaggio(feedDto.getOrganizzazioneViaggio());
		feedbackVo.setQualitaServizio(feedDto.getQualitaServizio());
		feedbackVo.setSupportoCliente(feedDto.getSupportoCliente());
		return feedbackVo;
	}
	
	public FeedbackDto fromVoToDto (FeedbackVo feedVo) throws Exception{
		FeedbackDto feedbackDto=new FeedbackDto(); 
		feedbackDto.setIdPrenotazione(feedVo.getIdPrenotazione());
		feedbackDto.setOrganizzazioneViaggio(feedVo.getOrganizzazioneViaggio());
		feedbackDto.setQualitaServizio(feedVo.getQualitaServizio());
		feedbackDto.setSupportoCliente(feedVo.getSupportoCliente());
		return feedbackDto;
	}
	
}
