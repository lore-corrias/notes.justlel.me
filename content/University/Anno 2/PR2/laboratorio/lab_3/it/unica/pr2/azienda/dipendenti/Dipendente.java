package it.unica.pr2.azienda.dipendenti;

public class Dipendente {
    private String nome;
    private String cognome;
    private int stipendio;
    

    public Dipendente(String nome, String cognome, int stipendio) {
        this.nome = nome;
        this.cognome = cognome;
        this.stipendio = stipendio;
    }

    public void straordinari(int ore, double pagaOraria) {
        stipendio += ore * pagaOraria;
    }

    public double stipendioNetto() {
        return stipendio;
    }
}
