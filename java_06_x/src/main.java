import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {


//Aufgabe 6.1 - Berrechnung des Maximums
//
//Schreibe ein kleines Programm, welches eine Liste von Zahlen über die Konsole zahlenweise einliest.
// Mit 'q' solltest du die Eingabe beenden können. Errechne dir danach aus der eben eingelesenen Liste das Maximum und gib es auf der Konsole aus.


        //https://www.w3schools.com/java/java_arraylist.asp
        Scanner scan = new Scanner(System.in);
//Erstellt eine ArrayList, welche sämtliche Consoleneingaben des Scanner übernimmt

        ArrayList arr1 = new ArrayList();
        arr1.add(scan.nextLine());

//Gibt die ArrayList aus
        System.out.println(arr1);


    }
}
