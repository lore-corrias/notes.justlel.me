public class Studente extends Persona {
	private int matricola;
	private int annoIscrizione;
	
	public Studente() {
		super();
		matricola = -1;
	}
	
	public Studente(String nome, String cognome, int eta, int matricola, int annoIscrizione) {
		super(nome, cognome, eta);
		this.matricola = matricola;
		this.annoIscrizione = annoIscrizione;
	}
	
	public Studente(Studente altroStudente) {
		super();
		if(altroStudente != null) {
			super.setNome(altroStudente.getNome());
			super.setCognome(altroStudente.getCognome());
			super.setEta(altroStudente.getEta());
			matricola = altroStudente.getMatricola();
			annoIscrizione = altroStudente.getAnnoIscrizione();
		}
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
	public int getAnnoIscrizione() {
		return annoIscrizione;
	}
	
	public void setAnnoIscrizione(int annoIscrizione) {
		this.annoIscrizione = annoIscrizione;
	}
	
	@Override
	public double calcolaCostoBiglietto(double prezzoIntero) {
		if(super.getEta() < 30) {
			return 0;
		} else if(2024 - annoIscrizione < 3) {
			return 0;
		} else {
			return super.calcolaCostoBiglietto(prezzoIntero);
		}
	}
}
