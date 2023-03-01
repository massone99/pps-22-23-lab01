package lab01.tdd;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final int FIRST_POSITION = 0;
    private final List<Integer> list = new LinkedList<>();
    private int listIndex = 0;

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> value = Optional.of(this.list.get(listIndex));
        incrementIndex();
        return value;
    }

    private void incrementIndex() {
        if (this.listIndex == (this.list.size() - 1)) {
            this.listIndex = FIRST_POSITION;
        } else {
            this.listIndex++;
        }
    }

    @Override
    public Optional<Integer> previous() {
        decrementIndex();
        return Optional.of(this.list.get(listIndex));
    }

    private void decrementIndex() {
        if (this.listIndex == FIRST_POSITION) {
            this.listIndex = (this.list.size() - 1);
        } else {
            this.listIndex--;
        }
    }

    @Override
    public void reset() {
        this.listIndex = FIRST_POSITION;
    }
}
