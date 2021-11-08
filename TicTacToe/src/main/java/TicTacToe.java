import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static int activeplayer =0;      // 0== Spieler, 1 == Computer
    public static int winner;               // contains the Playerwin- int

    public static void main(String[] args) {
        System.out.println("Spielregeln:");
        System.out.println("Wenn ein Spieler 3 gleiche in einer Reihe oder diagonal angeordnet hat, so gewinnt er das Spiel!");
        char[] table = new char[9];
        TicTacToe.GameLoop(table);

    }

    // Is it the Player´s or AI´s Turn, or is the Game End
    private static void GameLoop(char[] table){
        if (activeplayer == 0){
            TicTacToe.Board(table);
            TicTacToe.Player(table);
        } else if (activeplayer ==1){
            TicTacToe.Board(table);
            TicTacToe.AI(table);
        } else if (activeplayer ==3){
            TicTacToe.Finished(table);
        }
        TicTacToe.GameLoop(table);
    }


    // Display the GameBoard in the Console
    private static char[] Board(char[] table) {
        for (int i = 0; i < table.length; ) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("[ " + table[i] + " ] ");
                i++;
            }
            System.out.println();
        }
        return table;
    }

    // it´s the Player Turn
    private static char[] Player(char[] table) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gibt bitte die Nummer eines Feldes ein! nutze 1-9!");
        int num = scanner.nextInt();
        num -= 1;
        if (fieldIsAvilable(num, table)) {
            table[num] = 'X';
        } else {
            System.out.println("Du hast leider ein bereits belegtes Feld ausgewählt.");
            TicTacToe.Player(table);
        }
        activeplayer = 1;
        return table;
    }
    // it´s the Ai Turn
    private static char[] AI(char[] table) {
        Random rotation = new Random();
        int num = rotation.nextInt(9 - 0);
        // int num = 3;
        // num -=1;

        if (fieldIsAvilable(num, table)) {
            System.out.println("Der Computer wählt nun!");
            table[num] = 'o';
        } else {
            TicTacToe.AI(table);
        }
        activeplayer = 0;
        return table;
    }

    // who has won the Game?
    private static void Finished(char[] table){
        if (winner == 0){
            System.out.println("Du hast das Spiel gewonnen!");
        }else if (winner == 1){
            System.out.println("Der Computer hat das Spiel gewonnen!");
        }else if (winner != 1 && winner !=2){
            System.out.println("Das Spiel endet unentschieden!");
        }
    }

    // is the Field at the GameBoard Avilable?
    private static boolean fieldIsAvilable(int num, char[] table) {
        boolean bool;
        if (table[num] == 'X' || table[num] == 'o') {
            bool = false;
        } else {
            bool = true;
        }
        return bool;
    }


}
