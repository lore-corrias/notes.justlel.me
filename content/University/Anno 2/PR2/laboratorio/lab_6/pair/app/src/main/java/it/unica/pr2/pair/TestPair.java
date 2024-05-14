package it.unica.pr2.pair;

import static java.lang.System.out;

import it.unica.pr2.pair.*;

public class TestPair {
    public static void main(String[] args) {

        Pair<String, Boolean> myPair = new OrderedPair<>(new String("bello"), true);
        Pair<String, Boolean> myPair2 = new OrderedPair<>("insignificante", false);
        Pair<String, String> myPair3 = new OrderedPair<>("ciao", "hello");
        OrderedPair<String, Boolean> myPair4 = new OrderedPair<String, Boolean>("bello", true);

        /* Prima parte */
        assert myPair.getFirst().equals(new String("be"
                + "l"
                + "lo"));
        out.println("1 di 10 ...OK!");
        assert myPair.getSecond() == true;
        out.println("2 di 10 ...OK!");

        assert !myPair.getSecond().equals(myPair2.getSecond());
        out.println("3 di 10 ...OK!");

        assert myPair.getFirst().equals(myPair4.getFirst());
        out.println("4 di 10 ...OK!");
        assert myPair.getSecond().equals(myPair4.getSecond());
        out.println("5 di 10 ...OK!");

        /* Seconda parte */
        SameTypePair<String> pairS = new SameTypePair<String>("ciao", "hello");
        Pair<String, String> samePair = new SameTypePair<>("hello", "ciao");

        assert pairS.getFirst().equals(samePair.getSecond());
        out.println("6 di 10 ...OK!");

        /* Terza parte */
        UnorderedPair<String, Integer> c1 = new UnorderedPair<>("ciao", 20);
        UnorderedPair<String, Integer> c2 = new UnorderedPair<>("ciao", 20);
        UnorderedPair<Integer, String> c3 = new UnorderedPair<>(20, "ciao");
        UnorderedPair<Integer, Integer> c4 = new UnorderedPair<>(20, 20);

        assert c1.equals(c2);
        out.println("7 di 10 ...OK!");
        assert c1.equals(c3);
        out.println("8 di 10 ...OK!");
        assert c1.getFirst().equals(c3.getSecond());
        out.println("9 di 10 ...OK!");
        assert !c1.equals(c4);
        out.println("10 di 10 ...OK!");

        out.println("Se stai leggendo questo messaggio, il tuo codice ha "
                + "soddisfatto tutti gli assert.");
    }
}
