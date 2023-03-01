package lab01.tdd2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class CircularIteratorTest {

    private CircularIterator<Integer> circularIterator;

    @BeforeEach
    void setUp() {
        this.circularIterator = new CircularIterator<Integer>(new LinkedList<>());
    }

    @Test
    void add() {
        this.circularIterator.add(10);
        int size = this.circularIterator.size();

        assertEquals(1, size);
    }

    @Test
    void size() {
        assertEquals(0, this.circularIterator.size());
    }

    @Test
    void hasNext() {
        assertFalse(this.circularIterator.hasNext());
        this.circularIterator.add(10);
        assertTrue(this.circularIterator.hasNext());
    }

    @Test
    void next() {
        this.circularIterator.add(10);

        int value = this.circularIterator.next();
        assertEquals(10, value);
    }
}