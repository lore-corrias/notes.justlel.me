public class Rettangolo {
  // Implemento correttamente l'incapsulamento
  private double x, y;
  private double altezza;
  private double larghezza;

  public Rettangolo(double x, double y, double larghezza, double altezza) {
    this.x = x;
    this.y = y;
    this.larghezza = larghezza;
    this.altezza = altezza;
  }

  public double area() {
    return larghezza * altezza;
  }

  public void raddoppia() {
    x -= larghezza;
    y -= altezza;
    larghezza *= 2;
    altezza *= 2;
  }
}
