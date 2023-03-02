package lab01.tdd;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList;

    @BeforeEach
    void setUp() {
        this.circularList = new CircularListImpl();
        this.circularList.add(10);
        this.circularList.add(20);
        this.circularList.add(30);
    }

    @Test
    void testAdd() {
        this.circularList.add(40);
        int size = this.circularList.size();

        assertEquals(4, size);
    }

    @Test
    void testIsEmpty() {
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    void testNext() {
        int firstElement = this.circularList.next().get();
        int secondElement = this.circularList.next().get();
        assertEquals(10, firstElement);
        assertEquals(20, secondElement);
    }

    @Test
    void testPrevious() {
        int elementBeforeFirst = this.circularList.previous().get();
        assertEquals(30, elementBeforeFirst);
    }

    @Test
    void testReset() {
        this.circularList.next();
        this.circularList.reset();
        int firstElement = this.circularList.next().get();
        assertEquals(10, firstElement);
    }
}
