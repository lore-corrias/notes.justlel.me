package it.unica.pr2.classi;


public class Gatto extends Animale{
  private double lunghezzaCoda;

  public Gatto(String nome, double lunghezzaCoda) {
    super(nome);
    this.lunghezzaCoda = lunghezzaCoda;
  }

  public Double getLunghezzaCoda() {
    return lunghezzaCoda;
  }
}
