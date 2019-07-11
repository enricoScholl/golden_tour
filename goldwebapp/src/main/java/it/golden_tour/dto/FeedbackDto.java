package it.golden_tour.dto;

public class FeedbackDto {
	
	private String idPrenotazione;
	private int organizzazioneViaggio;
	private int supportoCliente;
	private int qualitaServizio;
	
	public String getIdPrenotazione() {
		return idPrenotazione;
	}
	public void setIdPrenotazione(String idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	public int getOrganizzazioneViaggio() {
		return organizzazioneViaggio;
	}
	public void setOrganizzazioneViaggio(int organizzazioneViaggio) {
		this.organizzazioneViaggio = organizzazioneViaggio;
	}
	public int getSupportoCliente() {
		return supportoCliente;
	}
	public void setSupportoCliente(int supportoCliente) {
		this.supportoCliente = supportoCliente;
	}
	public int getQualitaServizio() {
		return qualitaServizio;
	}
	public void setQualitaServizio(int qualitaServizio) {
		this.qualitaServizio = qualitaServizio;
	}
	

}
