package lab01.tdd3;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;

import java.util.Optional;
import java.util.function.Predicate;

public class CircularListWithFilter implements CircularList {

    private final CircularList circularList = new CircularListImpl();

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return this.circularList.next();
    }

    @Override
    public Optional<Integer> previous() {
        return this.circularList.previous();
    }

    @Override
    public void reset() {
        this.circularList.reset();
    }

    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        if (!isEmpty()) {
            int startingElement = next().get(); // Takes the first element
            int evaluatedElement = next().get(); // Takes the second one
            while (evaluatedElement != startingElement) {
                if (predicate.test(evaluatedElement)) {
                    return Optional.of(evaluatedElement);
                } else {
                    evaluatedElement = next().get();
                }
            }
        }
        return Optional.empty();
    }
}
