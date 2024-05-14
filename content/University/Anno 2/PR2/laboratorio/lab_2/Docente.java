public class Docente extends Persona {
	private String insegnamento;
	
	public Docente() {
		super();
		this.insegnamento = "default insegnamento";
	}
	
	public Docente(String nome, String cognome, int eta, String insegnamento) {
		super(nome, cognome, eta);
		this.insegnamento = insegnamento;
	}
	
	public Docente(Docente altroDocente) {
		super();
		if(altroDocente != null) {
			super.setNome(altroDocente.getNome());
			super.setCognome(altroDocente.getCognome());
			super.setEta(altroDocente.getEta());
			insegnamento = altroDocente.getInsegnamento();
		}	
	}
	
	public String getInsegnamento() {
		return insegnamento;
	}
	
	public void setInsegnamento(String insegnamento) {
		this.insegnamento = insegnamento;
	}
	
	@Override
	public double calcolaCostoBiglietto(double prezzoIntero) {
		return prezzoIntero * 0.1;
	}
}
