import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    @DisplayName("Add two Numbers")
    void add() {
        assertEquals(4, Calculator.add(2, 2));
    }

    @Test
    @DisplayName("Multiply two Numbers")
    void multiply() {
        int a = 2;
        int b = 2;

        assertAll(
                () -> assertEquals(4, Calculator.multiply(a, b)),
                () -> assertEquals(-4, Calculator.multiply(2, -2)),
                () -> assertEquals(4, Calculator.multiply(-2, -2)),
                () -> assertEquals(0, Calculator.multiply(1, 0))
        );
    }
    @Test
    @DisplayName("Divide two Numbers")
    void divide(){
        int a = 30;
        int b = 5;

        assertEquals(6, Calculator.divide(a,b));
    }
}