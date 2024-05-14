public class Quadrato extends Rettangolo {
  public Quadrato(double x, double y, double lato) {
    super(x, y, lato, lato);
  }

  public static void main(String[] args) {
    Quadrato quadrato = new Quadrato(0, 0, 100);

    System.out.println("Area del quadrato: " + quadrato.area());
    quadrato.raddoppia();
    System.out.println("Area del quadrato con il lato raddoppiato: " + quadrato.area());
  }
}
