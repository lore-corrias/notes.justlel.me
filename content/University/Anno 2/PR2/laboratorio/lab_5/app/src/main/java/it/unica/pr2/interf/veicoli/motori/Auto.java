package it.unica.pr2.interf.veicoli.motori;

public class Auto {
  private String marca;
  private String modello;
  private int anno;

  public Auto() {
    this.marca = "not defined";
    this.modello = "not defined";
  }

  public Auto(String marca, String modello, int anno) {
    this.marca = marca;
    this.modello = modello;
    this.anno = anno;
  }

  public String getMarca() {
    return marca;
  }

  public String getModello() {
    return modello;
  }

  public int getAnno() {
    return anno;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setModello(String modello) {
    this.modello = modello;
  }

  public void setAnno(int anno) {
    this.anno = anno;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    else if (object == null)
      return false;
    else if (this.getClass() != object.getClass())
      return false;

    Auto auto = (Auto) object;

    return auto.getAnno() == anno && auto.getMarca() == marca &&
        auto.getModello() == modello;
  }
}
