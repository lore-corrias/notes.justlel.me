public class TestFirstClass {

    public static void main(String[] args) {

        int[] mieiValori = { 17, 21, 5, 78, 123, 960, 200 };

        java.util.function.Predicate<Integer> mioCriterio = i -> i % 5 == 0;

        stampaConCriterio(mieiValori, mioCriterio);
    }

    // static void stampaConCriterio(int[] valori,
    // java.util.function.<interfaccia_funzionale> criterio) {
    static void stampaConCriterio(int[] valori, java.util.function.Predicate<Integer> criterio){
        for (int valoreCorrente : valori) {
            if (criterio.test(valoreCorrente)) {
                System.out.println(valoreCorrente);
            }
        }
    }

}
