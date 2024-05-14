public class TesseraAtleti extends Tessera {
	public String sport;
	public int dataIscrizione;

	public TesseraAtleti() {
		super();
		sport = "default sport";
		dataIscrizione = 2024;
	}
	
	public TesseraAtleti(String nome, String cognome, int eta, long codice, String sport, int dataIscrizione) {
		super(nome, cognome, eta, codice);
		this.sport = sport;
		this.dataIscrizione = dataIscrizione;
	}
	
	public TesseraAtleti(TesseraAtleti altraTesseraAtleta) {
		super();
		if(altraTesseraAtleta != null) {
			this(altraTesseraAtleta.getNome(), altraTesseraAtleta.getCognome(), altraTesseraAtleta.getEta(), altraTesseraAtleta.getCodice()
					altraTesseraAtleta.getSport(), altraTesseraAtleta.getDataIscrizione());
		}
	}
	
	public String getSport() {
		return sport;
	}
	
	public void setSport(String sport) {
		if(sport.length == 0) {
			System.out.println("Lo sport " + sport + " non è valido!");
		} else {
			this.sport = sport;
		}
	}
	
	public int getDataIscrizione() {
		return dataIscrizione;
	}
	
	public void setDataIscrizione(int dataIscrizione) {
		if(dataIscrizione > 2024 || dataIscrizione < 1980) {
			System.out.println("La data " + dataIscrizione + " non è valida!");
		} else {
			this.dataIscrizione = dataIscrizione;
		}
	}
	
	@Override
	public boolean timbra() {
		if(super.getNumeroAccessi() >= 20) {
			return false;		
		}
		super.setNumeroAccessi(super.getNumeroAccessi() + 1);
		return true;
	}
}
