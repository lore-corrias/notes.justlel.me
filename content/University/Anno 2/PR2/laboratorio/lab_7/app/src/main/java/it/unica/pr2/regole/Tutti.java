package it.unica.pr2.regole;

import java.util.Arrays;

class Tutti extends Regola {
  public Tutti(String... args) {
    super(args);
  }

  @Override
  public boolean verifica(String... args) {
    return super.containsAll(Arrays.asList(args));
  }
}
