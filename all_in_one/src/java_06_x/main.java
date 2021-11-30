package java_06_x;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {


//Aufgabe 6.1 - Berrechnung des Maximums
//
//Schreibe ein kleines Programm, welches eine Liste von Zahlen über die Konsole zahlenweise einliest.
// Mit 'q' solltest du die Eingabe beenden können. Errechne dir danach aus der eben eingelesenen Liste das Maximum und gib es auf der Konsole aus.

        Scanner scan = new Scanner(System.in);
        int max = Integer.MIN_VALUE; // deklariert max mit der mindestZahl von integer (-2147483648) um daraus später die höchste Zahl zu ermitteln
        boolean finished = false;

        System.out.println("Gib bitte deine Zahlen ein. Das Programm wird beendet sobald du q eingibst!");
        while (!finished) {
            String input = scan.nextLine();
            String[] s2 = input.split(" "); // Zerlegt input und erstellt den array s2. Das Zeichen " " dient als referenz für einen neuen Eintrag.
            for (int i = 0; i < s2.length; i++) {
                try { //Versuche den Code auszuführen, bis ein Problem auftritt
                    int current = (Integer.parseInt(s2[i]));
                    if (current > max && !finished) { //Wandelt den wert von s2[i] in einen int wert um und vergleicht diesen, ob er größer als der Wert von max ist
                        max = Integer.parseInt(s2[i]);  //Wenn der Wert s2[i] größer als der max wert ist, dann ersetze den max wert mit diesem
                    }
                } catch (Exception NumberFormatException) { //Trifft die Meldung "NumberFormatException" zu, so gib folgendes aus:
                    if (s2[i].equals("q")) {
                        finished = true;
                        System.out.println("Das Programm wurde aufgrund der Eingabe von q beendet!");
                    }
                }
            }
        }
        System.out.println("Maximum: " + max);
    }
}
