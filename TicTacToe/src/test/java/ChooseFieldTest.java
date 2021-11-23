import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChooseFieldTest {

    @Test
    @DisplayName("When it's the turn of player 1 and that player chooses the field 1, the first element in the tictactoe field(with index 0) gets modified to 1")
    public void testChooseField1Successfully() {
        int[] ticTacToeField = {
                0, 0, 0,
                0, 0, 0,
                0, 0, 0
        };
        assertEquals(1, TicTacToe.Player(1, ticTacToeField)[0]);
    }

    @Test
    @DisplayName("When it's the turn of player 2 and that player chooses the field 5, the fifth element in the tictactoe field(with index 4) gets modified to 2")
    public void testChooseField5Successfully() {
        int[] ticTacToeField = {
                0, 0, 0,
                0, 0, 0,
                0, 0, 0
        };
        assertEquals(2, TicTacToe.Ai(5, ticTacToeField)[4]);
    }
    @Test
    @DisplayName("When a field inside the valid range (1,2,3,4,5,6,7,8,9 is chosen and is empty, the Output should be true")
    public void testChooseFieldFromCorrectRange() {
        int[] ticTacToeField = {
                0, 2, 1,
                0, 2, 1,
                0, 0, 0
        };
        System.setIn(new ByteArrayInputStream("0 10 11 1".getBytes()));

        int i = 3;
        assertEquals(true, TicTacToe.FieldIsAvilable_test(i, ticTacToeField));
    }


    @Test
    @DisplayName("When a field outside the valid range (0, 10, 11) is chosen, the scanner is asked until a valid input (e.g. 1) was given")
    public void testChooseFieldFromInvalidRange() {
        int[] ticTacToeField = {
                0, 2, 1,
                0, 2, 1,
                0, 0, 0
        };

        int i = 10;
        assertEquals(false, TicTacToe.FieldIsAvilable_test(i, ticTacToeField));
    }

    @Test
    @DisplayName("When a field that is already occupied (1 6 5 6 3 4) is chosen, the scanner is asked until a valid input (e.g. 7) was given")
    public void testChooseAlreadyChosenField() {
        int[] ticTacToeField = {
                1, 2, 1,
                1, 2, 1,
                0, 0, 0
        };
        int i = 2;
        assertEquals(false, TicTacToe.FieldIsAvilable_test(i, ticTacToeField));
    }
}
