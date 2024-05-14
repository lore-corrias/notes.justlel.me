package it.unica.pr2.mesi;

public class TestMesi {

    public static void main(String[] args) {
        for (Mesi mese : Mesi.values()) {
            String nomeMese = mese.name().substring(0, 1) + mese.name().substring(1).toLowerCase();
            int giorni = mese.getGiorni();
            String stagione = mese.getStagione();

            System.out.println("A " + nomeMese + " ci sono " + giorni +
                    " giorni ed è " + stagione + ".");
        }
    }
}
