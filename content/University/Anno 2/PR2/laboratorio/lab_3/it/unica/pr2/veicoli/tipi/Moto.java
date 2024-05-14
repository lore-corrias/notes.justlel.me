package it.unica.pr2.veicoli.tipi;

public class Moto extends Veicolo {
    private boolean abs;

    public Moto(String marca, String modello, int anno) {
        super(marca, modello, anno);
    }
    
    public Moto(Moto altraMoto) {
        super(altraMoto);
    }

    public void hasABS(boolean abs) {
        this.abs = abs;
    }

    @Override
    public String descrizione() {
        return "Moto " + super.descrizione();
    }

    @Override
    public String sicurezza() {
        return "La moto " + super.descrizione() + (abs ? " ha ABS, sei abbastanza sicuro!" : " non ha ABS, non sei abbastanza sicuro!");
    }
}
