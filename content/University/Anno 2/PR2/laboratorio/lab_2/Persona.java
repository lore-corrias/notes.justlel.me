public class Persona {
	private String nome;
	private String cognome;
	private int eta;
	
	public Persona() {
		this.nome = "default name";
		this.cognome = "default surname";
		this.eta = 0;
	}
	
	public Persona(String nome, String cognome, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	public Persona(Persona altraPersona) {
		this();
		if(altraPersona != null) {
			this.nome = altraPersona.getNome();
			this.cognome = altraPersona.getCognome();
			this.eta = altraPersona.getEta();
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public int getEta() {
		return eta;
	}
	
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	public double calcolaCostoBiglietto(double prezzoIntero) {
		if(eta >= 50) {
			return prezzoIntero * 0.9;
		} else if(eta >= 70) {
			return prezzoIntero * 0.8;
		} else {
			return prezzoIntero;
		}
	}
}
