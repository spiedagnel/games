import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testCoordinate(){
        Coordinate c1 = new Coordinate(10,10);
        Coordinate c2 = new Coordinate(110,110);
        assertEquals(20000, c1.distance2(c2));
        Coordinate c3 = new Coordinate(210,210);
        List<Coordinate> cs = new ArrayList<>();
        cs.add(c2);
        cs.add(c3);
        assertSame(c1.closestTo(cs), c2);
    }



}