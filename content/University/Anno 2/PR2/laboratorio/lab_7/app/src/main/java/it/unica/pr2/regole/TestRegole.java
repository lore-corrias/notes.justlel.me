package it.unica.pr2.regole;

import java.util.Set;

public class TestRegole {

    public static void main(String[] args) {

        Regola ricettaSemplice = new Tutti("spaghetti", "olio", "aglio"); // varargs
        Regola vegano = new Nessuno("tonno", "carne", "uova"); // varargs
        Regola vocali = new Solo("a", "b", "c", "d", "e"); // varargs e aggiungiamo solo le stringhe di lunghezza 1

        assert ricettaSemplice instanceof Set;
        String elemento = ricettaSemplice.iterator().next(); // hint: questo metodo non va implementato direttamente ma
                                                             // ereditato
        assert ricettaSemplice.size() == 3;

        assert ricettaSemplice.verifica("olio", "spaghetti", "aglio", "tonno"); // tutti presenti quelli richiesti
        assert !ricettaSemplice.verifica("spaghetti", "aglio", "tonno"); // manca olio

        assert vegano.verifica("spaghetti", "aglio", "prezzemolo"); // ok
        assert !vegano.verifica("spaghetti", "aglio", "tonno"); // nessun elemento deve essere presente, invece c'e'
                                                                // tonno

        assert vocali.verifica("a", "e");
        assert !vocali.verifica("a", "f");

        Regola r = ricettaSemplice.componi(vegano); // componi deve funzionare per tutte le tipologie di regole
        assert !r.verifica("spaghetti", "aglio"); // manca olio
        assert !r.verifica("tonno"); // contiene tonno, non e' vegana
        assert r.verifica("spaghetti", "aglio", "olio"); // ok
        assert r.verifica("spaghetti", "aglio", "olio", "prezzemolo"); // ok
        assert !r.verifica("spaghetti", "aglio", "olio", "prezzemolo", "tonno"); // c'e' tonno
        //
        System.out.println(":D");
        /**/
    }
}
