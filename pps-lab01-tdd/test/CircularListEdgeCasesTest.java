import lab01.tdd.CircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularListEdgeCasesTest {

    CircularList circularList;

    @BeforeEach
    void setUp() {
        this.circularList = new CircularListImpl();
    }

    @Test
    void testNextSupportsCircularStructure() {
        this.circularList.add(0);
        this.circularList.next();
        int elementAfterFirstOne = this.circularList.next().get();
        assertEquals(0, elementAfterFirstOne);
    }

    @Test
    void testPreviousAfterNext() {
        this.circularList.add(0);
        this.circularList.add(1);
        this.circularList.next();
        int value = this.circularList.previous().get();

        assertEquals(0, value);
    }

    @Test
    void testNextAfterPrevious() {
        this.circularList.add(0);
        this.circularList.add(1);
        this.circularList.previous();
        int value = this.circularList.next().get();

        assertEquals(1, value);
    }

}
