package it.unica.pr2.interf.veicoli.motori;

public class AutoElettrica extends Auto implements MotoreElettrico {
  private int kw;

  public AutoElettrica(String marca, String modello, int anno, int kw) {
    super(marca, modello, anno);
    this.kw = kw;
  }

  public AutoElettrica() {
    super();
    this.kw = -1;
  }

  public int getKw() {
    return kw;
  }
}
