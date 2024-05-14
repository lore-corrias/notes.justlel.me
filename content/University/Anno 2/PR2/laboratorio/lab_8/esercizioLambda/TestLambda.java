import java.util.Arrays;

public class TestLambda {

    public static void main(String[] args) {

        Gatto[] gatti = new Gatto[3];
        gatti[0] = new Gatto("Romeo", 30.5);
        gatti[1] = new Gatto("Duchessa", 28.0);
        gatti[2] = new Gatto("Matisse", 20.3);

        System.out.println("I gatti prima dell'ordinamento:");
        System.out.println(Arrays.toString(gatti));

        Arrays.sort(gatti, (g1, g2) -> g1.getNome().compareTo(g2.getNome()));

        System.out.println("\nI gatti ordinati per nome:");
        System.out.println(Arrays.toString(gatti));

        Arrays.sort(gatti, (g1, g2) -> g1.getCoda().compareTo(g2.getCoda()));

        System.out.println("\nI gatti ordinati per lunghezza della coda:");
        System.out.println(Arrays.toString(gatti));

        Arrays.sort(gatti, (g1, g2) -> ((Integer) g1.getNome().length()).compareTo((Integer) g2.getNome().length()));

        System.out.println("\nI gatti ordinati per lunghezza del nome:");
        System.out.println(Arrays.toString(gatti));
    }

}
