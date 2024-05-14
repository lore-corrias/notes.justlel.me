package it.unica.pr2.azienda.dipendenti;

public class DipendenteTemporaneo extends Dipendente {
    private int scadenzaContratto;

    public DipendenteTemporaneo(String nome, String cognome, int stipendio, int scadenzaContratto) {
        super(nome, cognome, stipendio);
        this.scadenzaContratto = scadenzaContratto;
    }
}
