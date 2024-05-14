package it.unica.pr2.banca.conti;

public class ContoBancario {
    private String nome;
    private String cognome;
    private int primoVersamento;
    private int percentualeRendimentoAnnuo;
    private static int nConti = 1000;
    private int numeroConto;

    public ContoBancario() {
        this.nome = "undefined";
        this.cognome = "undefined";
        this.numeroConto = ++nConti;
    }

    public ContoBancario(String nome, String cognome, int primoVersamento) {
        this.nome = nome;
        this.cognome = cognome;
        this.primoVersamento = primoVersamento;
        this.numeroConto = ++nConti;
    }

    public int getNumeroConto() {
        return numeroConto;
    }

    public String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    protected void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getPrimoVersamento() {
        return primoVersamento;
    }

    protected void setPrimoVersamento(int primoVersamento) {
        this.primoVersamento = primoVersamento;
    }

    public int getPercentualeRendimentoAnnuo() {
        return percentualeRendimentoAnnuo;
    }

    protected void setPPercentualeRendimentoAnnuo(int percentualeRendimentoAnnuo) {
        this.percentualeRendimentoAnnuo = percentualeRendimentoAnnuo;
    }

    public static double convertiInEuro(double dollari, double tassoConversione) {
        return dollari * tassoConversione;
    }
}
