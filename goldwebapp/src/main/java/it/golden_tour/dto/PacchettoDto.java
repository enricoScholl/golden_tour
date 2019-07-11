package it.golden_tour.dto;

public class PacchettoDto {

	private Long id;
	private Long idProdotto;
	private String destinazione;
	private float prezzoPacchetto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(Long idProdotto) {
		this.idProdotto = idProdotto;
	}
	public String getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	public float getPrezzoPacchetto() {
		return prezzoPacchetto;
	}
	public void setPrezzoPacchetto(float prezzoPacchetto) {
		this.prezzoPacchetto = prezzoPacchetto;
	}
}
