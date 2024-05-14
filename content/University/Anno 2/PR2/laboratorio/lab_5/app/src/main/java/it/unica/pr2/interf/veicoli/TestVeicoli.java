package it.unica.pr2.interf.veicoli;

import it.unica.pr2.interf.veicoli.motori.*;

public class TestVeicoli {

    public static void main(String[] args) {

        AutoElettrica ae = new AutoElettrica(
                "Tesla", "Model 3", 2019,
                85); // marca, modello, anno di produzione, kw della batteria

        AutoIbrida ai = new AutoIbrida("Ford", "Focus", 2023, 79,
                4.5); // marca, modello, anno di produzione, kw della
                      // batteria, litri ogni 100 km di consumo

        AutoClassica ac = new AutoClassica(
                "Fiat", "Punto", 2006,
                13.5); // marca, modello, anno di produzione, litri ogni 100 km

        assert (ae instanceof MotoreElettrico);
        assert (ai instanceof MotoreElettrico && ai instanceof MotoreAScoppio);
        assert (ac instanceof MotoreAScoppio);

        Garage g = new Garage("PaoloB"); // nome proprietario,dimensione massima 5 auto
        g.aggiungi(ae);
        g.aggiungi(ai);
        g.aggiungi(ac);

        assert g.numeroAuto() == 3;

        AutoClassica ac2 = new AutoClassica(ac);

        assert ac2.equals(ac);
        g.aggiungi(ac2);

        AutoElettrica ae2 = new AutoElettrica();
        assert ae2.getMarca().equals("not defined");
        assert ae2.getModello().equals("not defined");
        assert ae2.getKw() == -1;

        g.aggiungi(ae2);
        assert g.numeroAuto() == 5;

        assert g.get(0).getMarca().equals("Tesla");

        AutoIbrida ai2 = new AutoIbrida();
        try {
            g.aggiungi(ai2);
        } catch (NumeroAutoEccessivoException e) {
            assert e.getMessage().equals(
                    "Hai già raggiunto il numero massimo di auto nel garage di PaoloB");
        }

        /**/
    }
}
