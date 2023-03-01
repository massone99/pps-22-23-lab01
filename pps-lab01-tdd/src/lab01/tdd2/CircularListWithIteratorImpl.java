package lab01.tdd2;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CircularListWithIteratorImpl implements CircularListWithIterator {

    private final CircularIterator<Integer> circularIterator = new CircularIterator<Integer>(new LinkedList<>());

    @Override
    public void add(int element) {
        this.circularIterator.add(element);
    }

    @Override
    public int size() {
        return this.circularIterator.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularIterator.size() == 0;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return this.circularIterator;
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        List<Integer> reversedList = this.circularIterator.getAll();
        Collections.reverse(reversedList);
        return new CircularIterator<>(reversedList);
    }
}
