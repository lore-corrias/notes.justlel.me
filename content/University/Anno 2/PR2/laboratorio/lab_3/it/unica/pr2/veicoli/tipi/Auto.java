package it.unica.pr2.veicoli.tipi;

public class Auto extends Veicolo {
    private boolean airbags;

    public Auto(String marca, String modello, int anno) {
        super(marca, modello, anno);
    }

    public Auto(Auto altraAuto) {
        super(altraAuto);
    }

    public void hasFourAirbags(boolean airbags) {
        this.airbags = airbags;
    }

    public boolean getAirbags() {
        return airbags;
    }

    @Override
    public String descrizione() {
        return "Auto " + super.descrizione();
    }

    @Override
    public String sicurezza() {
        return "L'auto " + super.descrizione() + (airbags ? " ha 4 airbags, sei abbastanza sicuro!" : " non ha 4 airbags, non sei abbastanza sicuro!");
    }

    @Override
    public boolean equals(Object auto) {
        if(!(auto instanceof Auto)) 
            return false;
        Auto autoCasted = (Auto) auto;
        return super.getModello() == autoCasted.getModello() &&
               super.getMarca() == autoCasted.getMarca() &&
               super.getAnno() == autoCasted.getAnno() &&
               super.getCilindrata() == autoCasted.getCilindrata() &&
               getAirbags() == autoCasted.getAirbags();
    }
}
