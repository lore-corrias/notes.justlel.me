package it.unica.pr2.comparator;

import it.unica.pr2.classi.Gatto;
import java.util.Comparator;


public class CodaComparator implements Comparator<Gatto> {
  @Override
  public int compare(Gatto g1, Gatto g2) {
    return g1.getLunghezzaCoda().compareTo(g2.getLunghezzaCoda());
  }
}
