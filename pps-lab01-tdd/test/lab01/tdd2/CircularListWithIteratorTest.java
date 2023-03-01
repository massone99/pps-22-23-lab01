package lab01.tdd2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CircularListWithIteratorTest {

    private static final int STARTING_LENGTH = 3;
    private CircularListWithIterator circularList;


    @BeforeEach
    void setUp() {
        this.circularList = new CircularListWithIteratorImpl();

        this.circularList.add(10);
        this.circularList.add(20);
        this.circularList.add(30);
    }

    @Test
    void testSize() {
        int listSize = this.circularList.size();

        assertEquals(STARTING_LENGTH, listSize);
    }

    @Test
    void testAdd() {
        this.circularList.add(40);
        int listSize = this.circularList.size();

        assertEquals((STARTING_LENGTH + 1), listSize);
    }

    @Test
    void testIsEmpty() {
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    void testForwardIterator() {
        Iterator<Integer> forwardIterator = this.circularList.forwardIterator();

        forwardIterator.next();
        int secondElement = forwardIterator.next();
        assertEquals(20, secondElement);
    }

    @Test
    void testBackwardIterator() {
        Iterator<Integer> backwardIterator = this.circularList.backwardIterator();

        int lastElement = backwardIterator.next();
        assertEquals(30, lastElement);
    }
}