package it.unica.pr2.interf.veicoli.motori;

import java.util.ArrayList;

public class Garage {
  private String nomeProprietario;
  private final int maxAuto = 5;
  private final ArrayList<Auto> auto = new ArrayList<Auto>();

  public Garage(String nomeProprietario) {
    this.nomeProprietario = nomeProprietario;
  }

  public void aggiungi(Auto auto) throws NumeroAutoEccessivoException {
    if (this.auto.size() >= maxAuto)
      throw new NumeroAutoEccessivoException(
          "Hai già raggiunto il numero massimo di auto nel garage di " +
              nomeProprietario);
    this.auto.add(auto);
  }

  public int numeroAuto() {
    return auto.size();
  }

  public Auto get(int i) {
    return auto.get(i);
  }
}
