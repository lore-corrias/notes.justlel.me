package it.unica.pr2.pair;

public class UnorderedPair<T, S> extends Pair<T, S> {
  public UnorderedPair(T firstElement, S secondElement) {
    super(firstElement, secondElement);
  }

  @Override
  public boolean equals(Object unorderedPair) {
    if (!(unorderedPair instanceof UnorderedPair<?, ?>))
      return false;
    UnorderedPair<?, ?> unorderedPairCasted = (UnorderedPair<?, ?>) unorderedPair;
    return (this.getFirst().equals(unorderedPairCasted.getFirst()) ||
        this.getFirst().equals(unorderedPairCasted.getSecond())) &&
        (this.getSecond().equals(unorderedPairCasted.getSecond()) ||
            this.getSecond().equals(unorderedPairCasted.getFirst()));
  }
}
