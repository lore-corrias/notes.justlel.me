package it.unica.pr2.pair;

public class OrderedPair<T, S> extends Pair<T, S> {
  public OrderedPair(T firstElement, S secondElement) {
    super(firstElement, secondElement);
  }

  @Override
  public boolean equals(Object orderedPair) {
    if (!(orderedPair instanceof OrderedPair<?, ?>))
      return false;
    OrderedPair<?, ?> orderedPairCasted = (OrderedPair<?, ?>) orderedPair;
    return orderedPairCasted.getFirst().equals(this.getFirst()) &&
        orderedPairCasted.getSecond().equals(this.getSecond());
  }
}
