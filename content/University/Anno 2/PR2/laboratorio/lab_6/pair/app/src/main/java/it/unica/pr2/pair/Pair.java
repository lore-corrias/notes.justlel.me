package it.unica.pr2.pair;

public class Pair<T, S> {
  private T firstElement;
  private S secondElement;

  public Pair(T firstElement, S secondElement) {
    this.firstElement = firstElement;
    this.secondElement = secondElement;
  }

  public T getFirst() {
    return firstElement;
  }

  public S getSecond() {
    return secondElement;
  }
}
