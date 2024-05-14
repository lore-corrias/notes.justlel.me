package it.unica.pr2.banca.conti;

public class ContoCorrente extends ContoBancario {
    private int saldo;
    private int percentualeRendimentoAnnuo;

    public ContoCorrente() {
        super();
    }

    public ContoCorrente(String nome, String cognome, int primoVersamento, int percentualeRendimentoAnnuo) {
        super(nome, cognome, primoVersamento);
        this.percentualeRendimentoAnnuo = percentualeRendimentoAnnuo;
    }

    public ContoCorrente(ContoCorrente contoCorrente) {
        this();
        if(contoCorrente != null) {
            super.setNome(contoCorrente.getNome());
            super.setCognome(contoCorrente.getCognome());
            super.setPrimoVersamento(contoCorrente.getPrimoVersamento());
            this.saldo = contoCorrente.getSaldo();
            this.percentualeRendimentoAnnuo = contoCorrente.getPercentualeRendimentoAnnuo();
        }
    }

    public int getSaldo() {
        return saldo;
    }

    public void preleva(int prelievo) {
        if(prelievo < 0) {
            throw new IllegalArgumentException("Argomento non valido");
        } else if(prelievo > saldo) {
            throw new InsufficientFundsException();
        } else {

        }
    }

    @Override
    public boolean equals(Object contoCorrente) {
        if(!(contoCorrente instanceof ContoCorrente))
            return false;
        ContoCorrente contoCorrenteCasted = (ContoCorrente) contoCorrente;
        return
            super.getNome().equals(contoCorrenteCasted.getNome()) &&
            super.getCognome().equals(contoCorrenteCasted.getCognome()) &&
            super.getPrimoVersamento() == contoCorrenteCasted.getPrimoVersamento() &&
            super.getPercentualeRendimentoAnnuo() == contoCorrenteCasted.getPercentualeRendimentoAnnuo() &&
            getSaldo() == contoCorrenteCasted.getSaldo();
    }
}