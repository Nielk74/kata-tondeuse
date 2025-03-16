import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void testWithinField_ValidPosition() {
        Field field = new Field(5, 5);
        assertTrue(field.isWithinField(0, 0));
        assertTrue(field.isWithinField(5, 5));
        assertTrue(field.isWithinField(3, 2));
    }

    @Test
    void testWithinField_InvalidPosition() {
        Field field = new Field(5, 5);
        assertFalse(field.isWithinField(-1, 0));
        assertFalse(field.isWithinField(0, -1));
        assertFalse(field.isWithinField(6, 5));
        assertFalse(field.isWithinField(5, 6));
    }

    @Test
    void testBoundaryConditions() {
        Field field = new Field(5, 5);
        assertTrue(field.isWithinField(0, 0));
        assertTrue(field.isWithinField(5, 0));
        assertTrue(field.isWithinField(0, 5));
        assertTrue(field.isWithinField(5, 5));
    }

    @Test
    void testNegativeFieldSize() {
        Field field = new Field(-1, -1);
        assertFalse(field.isWithinField(0, 0));
        assertFalse(field.isWithinField(1, 1));
    }
}
