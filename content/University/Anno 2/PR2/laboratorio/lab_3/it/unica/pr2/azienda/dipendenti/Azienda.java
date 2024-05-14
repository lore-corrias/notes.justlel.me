package it.unica.pr2.azienda.dipendenti;

public class Azienda {
    private String nome;
    private String sedeLegale;
    private String citta;
    private int nDipendenti = 0;
    private Dipendente dipendenti[] = new Dipendente[5];

    public Azienda(String nome, String sedeLegale, String citta) {
        this.nome = nome;
        this.sedeLegale = sedeLegale;
        this.citta = citta;
    }

    public void assumi(Dipendente dipendente) {
        if(nDipendenti < 5) {
            dipendenti[nDipendenti] = dipendente;
            nDipendenti++;
        }
    }

    public double totaleStipendi() {
        int totale = 0;

        for(int i = 0; i < nDipendenti; i++) {
            totale += dipendenti[i].stipendioNetto();
        }
        return totale;
    }

    public int totaleDipendenti() {
        return nDipendenti;
    }

    public boolean lavoraQui(Dipendente dipendente) {
        for(int i = 0; i < nDipendenti; i++) {
            if(dipendenti[i].equals(dipendente))
                return true;
        }
        return false;
    }

    private int contaDipendentiConMansione(String mansione) {
        int nDipendentiMansione = 0;
        for(int i = 0; i < nDipendenti; i++) {
            if(dipendenti[i] instanceof DipendenteIndeterminato && ((DipendenteIndeterminato) dipendenti[i]).getMansione().equals(mansione))
                nDipendentiMansione++;
        }
        return nDipendentiMansione;
    }

    public int contaManager() {
        return contaDipendentiConMansione("Manager");
    }

    public int contaSegretari() {
        return contaDipendentiConMansione("Segretario");
    }

    public int contaDipendentiTemporanei() {
        int nDipendentiTemporanei = 0;
        for(int i = 0; i < nDipendenti; i++) {
            if(dipendenti[i] instanceof DipendenteTemporaneo)
                nDipendentiTemporanei++;
        }
        return nDipendentiTemporanei;
    }

    public int contaDipendentiIndeterminati() {
        int nDipendentiIndeterminati = 0;
        for(int i = 0; i < nDipendenti; i++) {
            if(dipendenti[i] instanceof DipendenteIndeterminato)
                 nDipendentiIndeterminati++;
        }
        return nDipendentiIndeterminati;
    }
}
