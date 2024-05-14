package it.unica.pr2.interf.veicoli.motori;

public class AutoClassica extends Auto implements MotoreAScoppio {
  private double litri100km;

  public AutoClassica(String marca, String modello, int anno,
      double litri100km) {
    super(marca, modello, anno);
    this.litri100km = litri100km;
  }

  public AutoClassica(AutoClassica autoClassica) {
    super();
    if (autoClassica != null) {
      super.setMarca(autoClassica.getMarca());
      super.setModello(autoClassica.getModello());
      super.setAnno(autoClassica.getAnno());
      litri100km = autoClassica.getLitri100km();
    }
  }

  public double getLitri100km() {
    return litri100km;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    else if (object == null)
      return false;
    else if (this.getClass() != object.getClass())
      return false;

    AutoClassica autoClassica = (AutoClassica) object;

    return super.equals(autoClassica) &&
        autoClassica.getLitri100km() == litri100km;
  }
}
