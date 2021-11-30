import java.sql.SQLOutput;
import java.util.Locale;

public class main {
    public static void main(String[] args) {

        // Exercise 1.1


        String firstName = "Markus";
        String lastName = "Neubacher";
        String gender = "m";
        int age = 33;
        String birthDate = "14. März 1988";
        double avgGrade = 4.5;
        boolean married = false;

        System.out.println("Dein Name ist: " + firstName + " " + lastName + ". Du bist " + age + " Jahre alt und am " + birthDate + " geboren.");
        System.out.println("Dein Notendurchscnitt ist: " + avgGrade + " und du bist " + married + " verheiratet.");


        //Aufgabe 1.2 - Einfache Rechenaufgaben
        //
        //Deklariere zwei numerische Variablen mit beliebigen Werten. Errechne deren Summe, Differenz, Produkt und Quotient und gib die Rechnung mit dem Ergebnis mit System.out.println/System.out.printf auf der Konsole aus. Rechne einmal mit ganzzahligen und einmal mit gebrochenen Zahlen!
        //
        //Bonus: Gib die Kommazahlen schön formatiert auf der Konsole aus.
        //
        //Eine Ausgabe sollte folgendermaßen aussehen:


        System.out.println(".");
        System.out.println(".");
        System.out.println(".");


        double number1 = 63.555;
        double number2 = 1234.484;


        System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
        System.out.printf("%1s %1s %1s %1s %5.3f%n", number1, "+", number2, "=", (number1 + number2));
        System.out.println("");

        System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
        System.out.printf("%1s %1s %1s %1s %5.3f%n", number1, "-", number2, "=", (number1 - number2));
        System.out.println("");

        System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
        System.out.printf("%1s %1s %1s %1s %5.3f%n", number1, "*", number2, "=", (number1 * number2));
        System.out.println("");

        System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
        System.out.printf("%1s %1s %1s %1s %5.3f%n", number1, "/", number2, "=", (number1 / number2));
        System.out.println("");

//Variablen und Datentypen
//Aufgabe 1.3 - Arbeiten mit Strings [🤓 Advanced]
//
//Lege einen String mit dem Inhalt “ Hello World! ” an (enthält vorne und hinten Leerzeichen).
//
//    Gib den String und seine Länge auf der Konsole aus.
//    Gib den String in einigen Abwandlungen auf der Konsole aus:
//        alle Buchstaben in Großbuchstaben
//        alle Buchstaben in Kleinbuchstaben
//        ersetze “World” mit “Codersbay”
//        ohne Leerzeichen zu Beginn des Texts
//    Gib den String 15 mal wiederholt mit einem Zeilenumbruch zum Trennen aus (ohne die Codezeile 15 mal zu kopieren 😉)
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
// https://www.delftstack.com/de/howto/java/java-remove-character-from-string/

        String helloW = " Hello World ";
        System.out.println(helloW);

        System.out.println(helloW.toUpperCase());
        System.out.println(helloW.toLowerCase());
        System.out.println(helloW.replace("World","CodersBay"));
        System.out.println(helloW.replace(" H", "H"));


        StringBuilder helloW2 = new StringBuilder(" Hello World ");
        helloW2 = helloW2.deleteCharAt(0);
        System.out.println(helloW2);
        System.out.println();



        for (int i =0; i < 15; i++){
            System.out.println(i+1);
            System.out.println(helloW);
        }

    }
}
