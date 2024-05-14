package it.unica.pr2.regole;

class Solo extends Regola {
  public Solo(String... args) {
    super(args);
  }

  @Override
  public boolean verifica(String... args) {
    for (String verify : args) {
      if (!super.contains(verify))
        return false;
    }
    return true;
  }
}
