
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void testTurnRight() {
        assertEquals(Direction.E, Direction.N.turnRight());
        assertEquals(Direction.S, Direction.E.turnRight());
        assertEquals(Direction.W, Direction.S.turnRight());
        assertEquals(Direction.N, Direction.W.turnRight());
    }

    @Test
    void testTurnLeft() {
        assertEquals(Direction.W, Direction.N.turnLeft());
        assertEquals(Direction.S, Direction.W.turnLeft());
        assertEquals(Direction.E, Direction.S.turnLeft());
        assertEquals(Direction.N, Direction.E.turnLeft());
    }

    @Test
    void testDirectionValues() {
        assertEquals(Direction.N, Direction.valueOf("N"));
        assertEquals(Direction.E, Direction.valueOf("E"));
        assertEquals(Direction.S, Direction.valueOf("S"));
        assertEquals(Direction.W, Direction.valueOf("W"));
    }
}
