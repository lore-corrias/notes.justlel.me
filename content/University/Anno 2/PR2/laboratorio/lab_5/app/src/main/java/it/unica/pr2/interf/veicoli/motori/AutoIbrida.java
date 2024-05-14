package it.unica.pr2.interf.veicoli.motori;

public class AutoIbrida
    extends Auto implements MotoreElettrico, MotoreAScoppio {
  private int kw;
  private double litri100km;

  public AutoIbrida(String marca, String modello, int anno, int kw,
      double litri100km) {
    super(marca, modello, anno);
    this.kw = kw;
    this.litri100km = litri100km;
  }

  public AutoIbrida() {
    super();
  }
}
