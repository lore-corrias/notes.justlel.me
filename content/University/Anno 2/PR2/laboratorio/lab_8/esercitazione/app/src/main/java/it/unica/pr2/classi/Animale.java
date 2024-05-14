package it.unica.pr2.classi;

public class Animale implements Comparable<Animale> {
  private String nome;

  public Animale(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }
  
  @Override
  public boolean equals(Object animale) {
    if(animale == null || !(animale instanceof Animale)) {
      return false;
    }
    Animale animaleCasted = (Animale) animale;
    return animaleCasted == this || animaleCasted.getNome().equals(this.getNome());
  }

  @Override
  public String toString() {
    return nome;
  }

  public int compareTo(Animale animale) {
    return animale.getNome().compareTo(nome);
  }
}
