package it.unica.pr2.classi;


public class Persona implements Comparable<Persona> {
  private String nome;
  private String cognome;
  private int anno;

  public Persona(String nome, String cognome, int anno) {
    this.nome = nome;
    this.cognome = cognome;
    this.anno = anno;
  }

  @Override
  public boolean equals(Object persona) {
    if(persona == null || !(persona instanceof Persona)) {
      return false;
    } 
    Persona personaCasted = (Persona) persona;
    return this == persona || personaCasted.getAnno().equals(this.getAnno());
  }

  @Override
  public String toString() {
    return nome;
  }

  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public Integer getAnno() {
    return anno;
  }

  @Override
  public int compareTo(Persona persona) {
    return persona.getAnno().compareTo(anno);
  }
}
