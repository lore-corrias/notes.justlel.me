package it.unica.pr2.regole;

class Nessuno extends Regola {
  public Nessuno(String... args) {
    super(args);
  }

  @Override
  public boolean verifica(String... args) {
    for (String verify : args) {
      if (super.contains(verify))
        return false;
    }
    return true;
  }
}
