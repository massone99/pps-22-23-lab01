package lab01.tdd2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularListWithIteratorEdgeCasesTest {

    private static final int STARTING_LENGTH = 3;
    private CircularListWithIterator circularList;


    @BeforeEach
    void setUp() {
        this.circularList = new CircularListWithIteratorImpl();
    }

    @Test
    void testElementAfterLastOne() {
        this.circularList.add(10);
        this.circularList.add(20);

        Iterator<Integer> forwardIterator = this.circularList.forwardIterator();
        forwardIterator.next();
        forwardIterator.next();
        int elementAfterLastOne = forwardIterator.next();

        assertEquals(10, elementAfterLastOne);
    }

}
