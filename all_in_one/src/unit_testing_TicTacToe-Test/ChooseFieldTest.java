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
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        TicTacToe.choose(1, ticTacToeField);
        assertEquals(1, ticTacToeField[0]);
    }

    @Test
    @DisplayName("When it's the turn of player 2 and that player chooses the field 5, the fifth element in the tictactoe field(with index 4) gets modified to 2")
    public void testChooseField5Successfully() {
        int[] ticTacToeField = {
                0, 0, 0,
                0, 0, 0,
                0, 0, 0
        };
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        TicTacToe.choose(2, ticTacToeField);
        assertEquals(2, ticTacToeField[4]);
    }

    @Test
    @DisplayName("When a field outside the valid range (0, 10, 11) is chosen, the scanner is asked until a valid input (e.g. 1) was given")
    public void testChooseFieldFromInvalidRange() {
        int[] ticTacToeField = {
                0, 2, 1,
                0, 2, 1,
                0, 0, 0
        };
        System.setIn(new ByteArrayInputStream("0 10 11 1".getBytes()));
        TicTacToe.choose(2, ticTacToeField);
        assertEquals(2, ticTacToeField[0]);
    }

    @Test
    @DisplayName("When a field that is already occupied (1 6 5 6 3 4) is chosen, the scanner is asked until a valid input (e.g. 7) was given")
    public void testChooseAlreadyChosenField() {
        int[] ticTacToeField = {
                1, 2, 1,
                1, 2, 1,
                0, 0, 0
        };
        System.setIn(new ByteArrayInputStream("1 6 5 6 3 4 7".getBytes()));
        TicTacToe.choose(2, ticTacToeField);
        assertEquals(2, ticTacToeField[6]);
    }
}
