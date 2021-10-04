import java.util.Arrays;

public class gameOfLive {
    public static void main(String[] args) {


        int tablerow = 5;
        int tablecolumn = 5;
        int gameruns = 5;

        char[][] table = onStartup(tablerow, tablecolumn);
        char[][] table2 = new char[tablerow][tablecolumn];

        //    int neighbours = neighbours(table, actualRow, actualColumn);

        boolean isTabAct = true;
        boolean isTab2Act = false;


        for (int i = 0; i < gameruns; i++) {
            if (isTabAct) {
                for (int column = 0; column < table.length; column++) {
                    for (int row = 0; row < table[column].length; row++) {
                        System.out.print(table[column][row]);

                        int neighbours = neighbours(table, row, column);
                        table2[column][row] = lifeRules(table[column][row],neighbours);
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();
                isTabAct = false;
                isTab2Act = true;


            } else if (isTab2Act) {
                for (int column = 0; column < table2.length; column++) {
                    for (int row = 0; row < table2[column].length; row++) {
                        System.out.print(table2[column][row]);

                        int neighbours = neighbours(table2, row, column);
                        table[column][row] = lifeRules(table2[column][row],neighbours);
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();
                isTab2Act = false;
                isTabAct = true;
            }
        }
    }
//Output in the Console:


    //If the Program is executed at the first Time --- initialize the First complete Overview
    private static char[][] onStartup(int tablerow, int tablecolumn) {
        //erstellt einen zufälligen Zähler, welcher den Multi Array beliebig mit # oder . befüllt
        char[][] startTable = new char[tablerow][tablecolumn];

        int randCell = (int) (Math.random() * ((tablerow * tablecolumn)) - 0);
        for (int i = 0; i < randCell; i++) {
            boolean zaehler1 = false;
            while (!zaehler1) {
                int randTablerow = (int) (Math.random() * tablerow - 0);
                int randTablecolumn = (int) (Math.random() * tablecolumn - 0);
                if (startTable[randTablerow][randTablecolumn] != '@') {
                    startTable[randTablerow][randTablecolumn] = '@';
                    zaehler1 = true;
                }
            }
        }
        for (int i = 0; i < startTable.length; i++) {
            for (int j = 0; j < startTable[i].length; j++) {
                if (startTable[i][j] != '@') {
                    startTable[i][j] = '-';
                }
            }
        }
        return startTable;
    }

    //How much neighbours have a Cell? --- uses per Cell!
    private static int neighbours(char[][] table, int inRow, int inColumn) {
        int neighboursSum = -1;
        try {
            for (int i = inRow; (i - 1) <= (inRow + 1); i++) {
                for (int j = inColumn; (j - 1) <= (inColumn + 1); i++) {
                    if (table[i][j] == '@') {
                        neighboursSum++;
                    }
                }
            }
        } catch (Exception ex) {
       //     System.out.println("Error at private Neighbours: " + ex.getMessage());
        }
        return neighboursSum;
    }

    /* Liferules used an char: --- uses per Cell!*/
    private static char lifeRules(char cell, int neighbours) {
        if (((cell != '@') && neighbours == 3) || ((cell == '@') && (neighbours == 2 || neighbours == 3))) {
            cell = '@';
        } else if ((cell != '@' && neighbours < 2) || (cell != '@' && neighbours > 3)) {
            cell = '-';
        }
        return cell;
    }

    /* Liferules used an Boolean: --- uses per Cell!*/
//    private static char lifeRules(boolean isAlive, int neighbours) {
//
//        // ändere isAlive in einen char Cell!
//
//
//        if ((!isAlive && neighbours == 3) || (isAlive && (neighbours == 2 || neighbours == 3))) {
//            isAlive = true;
//        } else if ((isAlive && neighbours < 2) || (isAlive && neighbours > 3)) {
//            isAlive = false;
//        }
//        return life(isAlive);
//    }
//
//    private static char life(boolean isAlive) {
//        char cell;
//        if (isAlive) {
//            cell = '@';
//        } else {
//            cell = '-';
//        }
//        return cell;
//    }
//
//
}
