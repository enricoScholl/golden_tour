package it.golden_tour.entities;

public class ViaggioVo {

	private Long id;
	private String tipologiaMezzo;
	private String dataInizio;
	private String dataFine;
	private String nomeViaggiatore;
	private String cognomeViaggiatore;
	private int numeroPosti;
	private float costoViaggio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipologiaMezzo() {
		return tipologiaMezzo;
	}
	public void setTipologiaMezzo(String tipologiaMezzo) {
		this.tipologiaMezzo = tipologiaMezzo;
	}
	public String getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	public String getDataFine() {
		return dataFine;
	}
	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}
	public String getNomeViaggiatore() {
		return nomeViaggiatore;
	}
	public void setNomeViaggiatore(String nomeViaggiatore) {
		this.nomeViaggiatore = nomeViaggiatore;
	}
	public String getCognomeViaggiatore() {
		return cognomeViaggiatore;
	}
	public void setCognomeViaggiatore(String cognomeViaggiatore) {
		this.cognomeViaggiatore = cognomeViaggiatore;
	}
	public int getNumeroPosti() {
		return numeroPosti;
	}
	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	public float getCostoViaggio() {
		return costoViaggio;
	}
	public void setCostoViaggio(float costoViaggio) {
		this.costoViaggio = costoViaggio;
	}
	
}
