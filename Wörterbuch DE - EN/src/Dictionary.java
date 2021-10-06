import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String, String>();
        HashMap<String, String> h2 = new HashMap<String, String>();
        onStart(h1, h2);
    }

    public static void onStart(HashMap<String, String> h1, HashMap<String, String> h2) {
        Scanner scan1 = new Scanner(System.in);
        int addDelNumb = 0;
        System.out.println();
        System.out.println("Wähle aus folgenden Optionen:");
        System.out.println("Zum Anzeigen des Aktuellen Inhaltes bestätige mit 0!");
        System.out.println("Füge ein Wort hinzu bestätige mit 1!");
        System.out.println("Soll ein Wort gelöscht werden, bestätige mit 2!");
        System.out.println("Beende das Programm mit dem bestätigen von 3!");
        System.out.println();
        try {
            addDelNumb = scan1.nextInt();
            loop(addDelNumb, h1, h2);
        } catch (Exception ex) {
            System.out.println();
            System.out.println();
            System.out.println("Du hast keine Korrekte Zahl eingegeben!");

            onStart(h1, h2);
        }
    }


    private static void loop(int addDelNumb, HashMap<String, String> h1, HashMap<String, String> h2) {
        Scanner scan1 = new Scanner(System.in);

        if (addDelNumb == 0) {
            System.out.println(h1);
            System.out.println(h2);
            onStart(h1, h2);
        } else if (addDelNumb == 1) {
            System.out.println();
            System.out.println("Trage das Wort ein, welches hinzugefügt werden soll in folgendem Format ein: DEUTSCH,ENGLISCH");
            String[] translate = scan1.next().split(",");
            addTranslation(translate, h1, h2);
            onStart(h1, h2);
        } else if (addDelNumb == 2) {
            System.out.println();
            System.out.println("Trage das Wort ein, welches gelöscht werden soll in folgendem Format ein: DEUTSCH,ENGLISCH");
            String[] translate = scan1.next().split(",");
            removeTranslation(translate, h1, h2);
            onStart(h1, h2);
        } else if (addDelNumb == 3) {
            System.out.println();
            System.out.println("Das Programm wurde beendet!");
        } else {
            System.out.println();
            System.out.println("Es wurde nicht erkannt, ob ein Eintrag hinzugefügt, ausgelesen oder gelöscht werden soll!");
            onStart(h1, h2);
        }


    }


    private static HashMap<String, String> addTranslation(String[] translate, HashMap<String, String> h1, HashMap<String, String> h2) {
        h1.put(translate[0], translate[1]);
        h2.put(translate[1], translate[0]);
        return h1;
    }

    private static HashMap<String, String> removeTranslation(String[] translate, HashMap<String, String> h1, HashMap<String, String> h2) {
        try {
            h1.remove(translate[0], translate[1]);
            h2.remove(translate[1], translate[0]);
            return h1;
        } catch (ArrayIndexOutOfBoundsException ex1) {
            System.out.println("Deine Eingabe war nicht korrekt");
            return h1;
        }
    }
}

/*
Input Frage: soll ein Wort hinzugefügt oder gelöscht werden.
Input Wort: Trage das Wort in folgendem Format ein: Deutsch Englisch





überprüfe ob hinzugefügt oder gelöscht ausgewählt wurde.
wenn hinzugefügt ausgewählt wurde, erstelle in einer Vordefinierten Hashmap einen neuen eintragen mit folgendem Syntax:
erstes Wort/ Eingabe = Key
zweites Wort/Eingabe = Values

Überprüfe ob das Wort korrekt eingegeben wurde.
    falls nicht und es handelt sich um ein Wort, welches hinzugefügt werden soll
        dann gibt eine meldung aus, dass das eingebenen Falsch ist
    falls nicht und es handelt sich um ein Wort, welches gelöscht werden soll
        dann überprüfe, ob das Wort ein Key oder ein Value ist.
    falls ja, dann führe die Operation entsprechend der Methoden aus


hinzufügen:
überprüfe ob der Key bereits vorhanden ist.
    falls ja, dann überprüfe ob das Value gleich dem eingegebenen ist.
        falls ja, gib rückmeldung: diese Übersetzung ist bereits eingetragen.
        falls nein, füge diese Übersetzung als neue Values für einen neuen Key hinzu.
    falls nein, dann erstelle einen Neuen Key mit dem entsprechenden Value.

löschen:
übernimm den Wert der überprüfung ob sie korrekt eingegeben ist und entferne den entsprechenden wert aus der Hashmap

 */
