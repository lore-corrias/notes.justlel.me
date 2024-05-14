package it.unica.pr2.classi;


public class Studente extends Persona {
  private String universita;
  private int votoDiLaurea;

  public Studente(String nome, String cognome, int anno, String universita, int votoDiLaurea) {
    super(nome, cognome, anno);
    this.universita = universita;
    this.votoDiLaurea = votoDiLaurea;
  }

  public String getUniversita() {
    return universita;
  }

  public Integer getVotoDiLaurea() {
    return votoDiLaurea;
  }
}
