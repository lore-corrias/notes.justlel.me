public class TesseraSegretari {
	public int giorniLavorativi;
	
	public TesseraSegretari() {
		super();
		giorniLavorativi = 0;
	}
	
	public TesseraSegretari(String nome, String cognome, int eta, int codice, int giorniLavorativi) {
		super(nome, cognome, eta, codice);
		this.giorniLavorativi = giorniLavorativi;
	}
	
	public TesseraSegretari(TesseraSegretari altraTesseraSegretario) {
		super(altraTesseraSegretario.getNome(), altraTesseraSegretario.getCognome(), altraTesseraSegretario.getEta(), altraTesseraSegretario.getCodice(), altraTesseraSegretario.getGiorniLavorativi());
	}
	
	public int giorniLavorativi() {
		return giorniLavorativi;
	}
	
	public void setGiorniLavorativi(int giorniLavorativi) {
		if(giorniLavorativi < 0 || giorniLavorativi > 5) {
			System.out.println("Il valore di giorniLavorativi " + giorniLavorativi + " non è valido!");
		} else {
			this.giorniLavorativi = giorniLavorativi;
		}
	}
}
