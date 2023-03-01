package lab01.tdd2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CircularIterator<E> implements Iterator<E> {

    private final List<E> circularList;
    private int listIndex = 0;

    public CircularIterator(List<E> list) {
        this.circularList = new LinkedList<>(list);
    }

    public void add(E element) {
        this.circularList.add(element);
    }

    public int size() {
        return this.circularList.size();
    }

    public List<E> getAll() {
        return this.circularList;
    }

    @Override
    public boolean hasNext() {
        return !this.circularList.isEmpty();
    }

    @Override
    public E next() {
        if (hasNext()) {
            E value = this.circularList.get(this.listIndex);
            incrementListIndex();
            return value;
        } else {
            return null;
        }
    }

    private void incrementListIndex() {
        if (this.listIndex == (this.circularList.size()-1)) {
            this.listIndex = 0;
        } else {
            this.listIndex++;
        }
    }
}
