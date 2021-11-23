package junit_tictactoe;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintTicTacToeTest {

    @Test
    public void testPrintEmptyTicTacToe() {
        int[] ticTacToeField = {
                0, 0, 0,
                0, 0, 0,
                0, 0, 0
        };
        assertEquals("\n" +
                " | | \n" +
                " | | \n" +
                " | | \n" +
                "\n",
                TicTacToe.asString(ticTacToeField));
    }

    @Test
    public void testPrintTicTacToeAllPlayer1() {
        int[] ticTacToeField = {
                1, 1, 1,
                1, 1, 1,
                1, 1, 1
        };
        assertEquals("\n"+"X|X|X\n"+"X|X|X\n"+"X|X|X\n"+"\n",
                TicTacToe.asString(ticTacToeField));
    }

    @Test
    public void testPrintTicTacToeMixed() {
        int[] ticTacToeField = {
                1, 2, 1,
                1, 2, 1,
                1, 2, 1
        };
        assertEquals("\n" +
                        "X|O|X\n" +
                        "X|O|X\n" +
                        "X|O|X\n" +
                        "\n",
                TicTacToe.asString(ticTacToeField));
    }
}
