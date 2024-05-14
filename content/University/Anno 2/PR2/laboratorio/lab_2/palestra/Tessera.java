public class Tessera {
	private String nome;
	private String cognome;
	private int eta;
	private long codice;
	private int numeroAccessi;
	
	public Tessera() {
		nome = "default name";
		cognome = "default surname";
		eta = 0;
		this.codice = -1;
	}
	
	public Tessera(String nome, String cognome, int eta, int codice) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.codice = codice;
	}
	
	public Tessera(Tessera altraTessera) {
		if(altraTessera != null) {
			nome = altraTessera.getNome();
			cognome = altraTessera.getCognome();
			eta = altraTessera.getEta();
			codice = altraTessera.getCodice();
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public String setNome(String nome) {
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
	
	public long getCodice() {
		return codice;
	}
	
	public void setCodice(long codice) {
		if(codice < 0) {
			System.out.println("Codice " + codice + " invalido!");
		} else {
			this.codice = codice;
		}
	}
	
	public int getNumeroAccessi() {
		return numeroAccessi;
	}
	
	public void setNumeroAccessi(int numeroAccessi) {
		if(numeroAccessi < 0) {
			System.out.println("Il valore di numeroAccessi " + numeroAccessi + " non è valido!");
		} else {
			this.numeroAccessi = numeroAccessi;
		}
	}
	
	public boolean timbra() {
		if(numeroAccessi >= 10) {
			return false;
		}
		numeroAccessi++;
		return true;
	}
	
	public void rinnova() {
		numeroAccessi = 0;
	}
}
