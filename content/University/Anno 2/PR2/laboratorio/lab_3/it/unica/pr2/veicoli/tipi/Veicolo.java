package it.unica.pr2.veicoli.tipi;

public abstract class Veicolo {
    private String marca;
    private String modello;
    private int anno;
    private int cilindrata;

    public Veicolo(String marca, String modello, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }

    public Veicolo(Veicolo altroVeicolo) {
        if(altroVeicolo != null) {
            this.marca = altroVeicolo.getMarca();
            this.modello = altroVeicolo.getModello();
            this.anno = altroVeicolo.getAnno();
            this.cilindrata = altroVeicolo.getCilindrata();
        }
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }
    
    public int getAnno() {
        return anno;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public String descrizione() {
        return marca + " " + modello + ", " + anno + ", " + cilindrata + "cc";
    }

    public abstract String sicurezza();
}