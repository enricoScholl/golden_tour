package it.golden_tour.entities;

public class ProdottoVo {

	private Long id;
	private String descrizione;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public ProdottoVo() {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}
	
}
