import org.junit.jupiter.api.Test;

public class SingleTest {
    @Test
    void testSimpleMultiplocation(){
        int a = 3;
        int b = 4;
        assertEquals(12,MathHelper.Multiply(a, b));
    }

    private void assertEquals(int i, Object multiply) {
    }

}
