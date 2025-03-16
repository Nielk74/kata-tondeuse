import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    private Field field;

    @BeforeEach
    void setUp() {
        field = new Field(5, 5);
    }

    @Test
    void testInitialPosition() {
        Mower mower = new Mower(1, 2, Direction.N, field);
        assertEquals(1, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals(Direction.N, mower.getDirection());
    }

    @Test
    void testTurnRight() {
        Mower mower = new Mower(0, 0, Direction.N, field);
        mower.execute('D');
        assertEquals(Direction.E, mower.getDirection());
        mower.execute('D');
        assertEquals(Direction.S, mower.getDirection());
        mower.execute('D');
        assertEquals(Direction.W, mower.getDirection());
        mower.execute('D');
        assertEquals(Direction.N, mower.getDirection());
    }

    @Test
    void testTurnLeft() {
        Mower mower = new Mower(0, 0, Direction.N, field);
        mower.execute('G');
        assertEquals(Direction.W, mower.getDirection());
        mower.execute('G');
        assertEquals(Direction.S, mower.getDirection());
        mower.execute('G');
        assertEquals(Direction.E, mower.getDirection());
        mower.execute('G');
        assertEquals(Direction.N, mower.getDirection());
    }

    @Test
    void testMoveForward() {
        Mower mower = new Mower(1, 1, Direction.N, field);
        mower.execute('A');
        assertEquals(1, mower.getX());
        assertEquals(2, mower.getY());

        mower.execute('D');
        mower.execute('A');
        assertEquals(2, mower.getX());
        assertEquals(2, mower.getY());

        mower.execute('D');
        mower.execute('A');
        assertEquals(2, mower.getX());
        assertEquals(1, mower.getY());

        mower.execute('D');
        mower.execute('A');
        assertEquals(1, mower.getX());
        assertEquals(1, mower.getY());
    }
}
