public class TesseraManutentori {
	private String specializzazione;
	private int dataAssunzione;
	private boolean altoRischio;
	
	public TesseraManutentori() {
		super();
		specializzazione = "default specializzazione";
		dataAssunzione = 2024;
		altoRischio = false;
	}
	
	public TesseraManutentori(String nome, String cognome, int eta, int codice, String specializzazione, int dataAssunzione, boolean altoRischio) {
		super(nome, cognome, eta, codice);
		this.specializzazione = specializzazione;
		this.dataAssunzione = dataAssunzione;
		this.altoRischio = altoRischio;
	}
	
	public TesseraManutentori(TesseraManutentori altraTesseraManutentori) {
		if(altraTesseraManutentori != null) {
			this(altraTesseraManutentori.getNome(), altraTesseraManutentori.getCognome(), altraTesseraManutentori.getEta(), altraTesseraManutentori.getCodice(), altraTesseraManutentori.getSpecalizzazione(), altraTesseraManutentori.getDataAssunzione(), altraTesseraManutentori.getAltoRischio());
		}
	}
	
	public String getSpecializzazione() {
		return specializzazione;
	}
	
	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	
	public int getDataAssunzione() {
		return dataAssunzione;
	}
	
	public void setDataAssunzione(int dataAssunzione) {
		if(dataAssunzione > 2024 || dataAssunzione < 1980) {
			System.out.println("La data di assunzione " + dataAssunzione + " non è valida!");
		} else {
			this.dataAssunzione = dataAssunzione;
		}
	}
	
	public boolean isAltoRischio() {
		return altoRischio;
	}
	
	public void setAltoRischio(boolean altoRischio) {
		this.altoRischio = altoRischio;
	}
	
	@Override
	public boolean timbra() {
		super.rinnova();
		super.timbra();
	}
}
