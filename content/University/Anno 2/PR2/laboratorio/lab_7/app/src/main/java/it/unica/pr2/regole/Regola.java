package it.unica.pr2.regole;

import java.util.HashSet;

class Regola extends HashSet<String> {
  private final HashSet<Regola> regole = new HashSet<Regola>();

  public Regola(String... args) {
    for (String arg : args)
      this.add(arg);
  }

  public boolean verifica(String... args) {
    return true;
  }

  public Regola componi(Regola regola) {
    return new Regola("");
  }
}
