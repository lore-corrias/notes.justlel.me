package it.unica.pr2.comparator;

import it.unica.pr2.classi.Studente;
import java.util.Comparator;


public class VotoLaureaComparator implements Comparator<Studente> {
  public int compare(Studente s1, Studente s2) {
    return s1.getVotoDiLaurea().compareTo(s2.getVotoDiLaurea());
  }
}
