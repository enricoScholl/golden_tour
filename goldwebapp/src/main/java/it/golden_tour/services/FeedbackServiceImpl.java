package it.golden_tour.services;

import java.util.ArrayList;
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
	public List<FeedbackDto> getAllFeedback() throws Exception {
		List<FeedbackVo> list = feedbackRepository.getAllFeedback();
		List<FeedbackDto> listNew = new ArrayList<FeedbackDto>(); 
		FeedbackDto d = null; 
		for(FeedbackVo f : list) {
			d = fromVoToDto(f);
			listNew.add(d); 
		}
		return listNew;
	}
	
	@Override
	public void insert(FeedbackDto feedback) throws Exception {
		feedbackRepository.insertFeedback(fromDtoToVo(feedback));
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
	
	public FeedbackDto fromVoToDto (FeedbackVo f) throws Exception{
		FeedbackDto feedbackDto=new FeedbackDto(); 
		feedbackDto.setIdPrenotazione(f.getIdPrenotazione());
		feedbackDto.setOrganizzazioneViaggio(f.getOrganizzazioneViaggio());
		feedbackDto.setQualitaServizio(f.getQualitaServizio());
		feedbackDto.setSupportoCliente(f.getSupportoCliente());
		return feedbackDto;
	}
	
}
