package it.unica.pr2.azienda.dipendenti;

public class DipendenteIndeterminato extends Dipendente {
    private String mansione;

    public DipendenteIndeterminato(String nome, String cognome, int stipendio, String mansione) {
        super(nome, cognome, stipendio);
        this.mansione = mansione;
    }

    public String getMansione() {
        return mansione;
    }
}
