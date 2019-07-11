package it.golden_tour.dto;

public class PrenotazioneDto {

	private String id;
	private Long idPacchetto;
	private Long idViaggio;
	private Long idUtente;
	private float costoTotale;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getIdPacchetto() {
		return idPacchetto;
	}
	public void setIdPacchetto(Long idPacchetto) {
		this.idPacchetto = idPacchetto;
	}
	public Long getIdViaggio() {
		return idViaggio;
	}
	public void setIdViaggio(Long idViaggio) {
		this.idViaggio = idViaggio;
	}
	public Long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}
	public float getCostoTotale() {
		return costoTotale;
	}
	public void setCostoTotale(float costoTotale) {
		this.costoTotale = costoTotale;
	}
}
