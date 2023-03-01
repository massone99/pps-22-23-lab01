package lab01.tdd3;

import lab01.tdd.CircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularListWithFilterTest {

    private CircularListWithFilter circularList;

    @BeforeEach
    void setUp() {
        this.circularList = new CircularListWithFilter();

        this.circularList.add(10);
        this.circularList.add(5);
        this.circularList.add(20);
    }

    @Test
    void testFilter() {
        int result = this.circularList.filteredNext(i -> (i > 10)).get();

        assertEquals(20, result);
    }
}