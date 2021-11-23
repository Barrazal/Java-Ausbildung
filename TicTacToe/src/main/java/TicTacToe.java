import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static int activeplayer = 0;      // 0== Spieler, 1 == Computer
    public static int winner;               // contains the Playerwin- int
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Spielregeln:");
        System.out.println("Wenn ein Spieler 3 gleiche in einer Reihe oder diagonal angeordnet hat, so gewinnt er das Spiel!");
        int[] table = new int[9];
        TicTacToe.GameLoop(table);

    }

    // Is it the Player´s or AI´s Turn, or is the Game End
    public static void GameLoop(int[] table) {
        Board(table);
        if (activeplayer == 0) {

            System.out.println("Gibt bitte die Nummer eines Feldes ein! nutze 1-9!");
            int num = scanner.nextInt();
            Player(num, table);
            CheckGameStatus(table);
            GameLoop(table);
        } else if (activeplayer == 1) {
            Random rotation = new Random();
            int num = rotation.nextInt(9 - 1);
            Ai(num, table);
            CheckGameStatus(table);
            GameLoop(table);
        } else if (activeplayer == 3) {
            Finished(table);
        }

    }

    // Display the GameBoard in the Console
    public static int[] Board(int[] table) {
        for (int i = 0; i < table.length; ) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("[" + table[i] + "]");
                i++;
            }
            System.out.println();
        }
        return table;
    }

    // it´s the Player Turn
    public static int[] Player(int num, int[] table) {
        num -= 1;
        if (FieldIsAvilable(num, table)) {
            table[num] = 1;
        } else {
            System.out.println("Du hast leider ein bereits belegtes Feld ausgewählt.");
            TicTacToe.GameLoop(table);
        }
        activeplayer = 1;
        return table;
    }

    // it´s the Ai Turn
    public static int[] Ai(int num, int[] table) {
        // int num = 3;
        num -= 1;

        if (FieldIsAvilable(num, table)) {
            System.out.println("Der Computer wählt nun!");
            table[num] = 2;
        } else {
            TicTacToe.GameLoop(table);
        }
        activeplayer = 0;
        return table;
    }

    // who has won the Game?
    public static void Finished(int[] table) {
        if (winner == 1) {
            System.out.println("Du hast das Spiel gewonnen!");
        } else if (winner == 2) {
            System.out.println("Der Computer hat das Spiel gewonnen!");
        } else if (winner == 3) {
            System.out.println("Das Spiel endet unentschieden!");
        }

        System.out.println("Tippe 1 um nocheinmal zu Spielen!");
        int num = scanner.nextInt();
        if (num == 1) {
            activeplayer = 0;
            winner = 0;
            int[] table_new = new int[9];
            GameLoop(table_new);
        } else {
            System.exit(0);
        }

    }

    public static int CheckGameStatus(int[] table) {
        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < table.length; i++) {
            if (table[i] == 1) {
                p1++;
            } else if (table[i] == 2) {
                p2++;
            }
        }
        //System.out.println("Zähler p1 " + p1 + " , Zähler p2 " + p2);
        if (p1 >= 3 || p2 >= 3) {
            if (//Row:
                    (table[0] == 1 && table[1] == 1 && table[2] == 1) ||
                            (table[3] == 1 && table[4] == 1 && table[5] == 1) ||
                            (table[6] == 1 && table[7] == 1 && table[8] == 1) ||
                            //Column:
                            (table[0] == 1 && table[3] == 1 && table[6] == 1) ||
                            (table[1] == 1 && table[4] == 1 && table[7] == 1) ||
                            (table[2] == 1 && table[5] == 1 && table[8] == 1) ||
                            //Diagonal:
                            (table[0] == 1 && table[4] == 1 && table[8] == 1) ||
                            (table[2] == 1 && table[4] == 1 && table[6] == 1)


            ) {
                activeplayer = 3;
                winner = 1;
            } else {
                if (//Row:
                        (table[0] == 2 && table[1] == 2 && table[2] == 2) ||
                                (table[3] == 2 && table[4] == 2 && table[5] == 2) ||
                                (table[6] == 2 && table[7] == 2 && table[8] == 2) ||
                                //Column:
                                (table[0] == 2 && table[3] == 2 && table[6] == 2) ||
                                (table[1] == 2 && table[4] == 2 && table[7] == 2) ||
                                (table[2] == 2 && table[5] == 2 && table[8] == 2) ||
                                //Diagonal:
                                (table[0] == 2 && table[4] == 2 && table[8] == 2) ||
                                (table[2] == 2 && table[4] == 2 && table[6] == 2)
                ) {
                    activeplayer = 3;
                    winner = 2;
                } else if ((p1 + p2) == 9) {
                    activeplayer = 3;
                    winner = 3;
                }
            }
        }
        int win = winner;
        return win;

    }

    // is the Field at the GameBoard Avilable?
    public static boolean FieldIsAvilable(int num, int[] table) {
        boolean bool = false;
        try {
            if (table[num] == 1 || table[num] == 2) {
                bool = false;
            } else {
                bool = true;
            }

        } catch (Exception ex) {
            System.out.println("Du darfst nur einen Wert zwischen 1 und 9 eingeben!");
            GameLoop(table);
        }
        return bool;
    }

    //Only for Testing!

    public static boolean FieldIsAvilable_test(int num, int[] table) {
        boolean bool = false;
        try {
            if (table[num] == 1 || table[num] == 2) {
                bool = false;
            } else {
                bool = true;
            }

        } catch (Exception ex) {
            System.out.println("Du darfst nur einen Wert zwischen 1 und 9 eingeben!");
        }
        return bool;
    }


}
