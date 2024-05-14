package it.unica.pr2.pair;

public class SameTypePair<T> extends Pair<T, T> {
  public SameTypePair(T firstElement, T secondElement) {
    super(firstElement, secondElement);
  }
}
