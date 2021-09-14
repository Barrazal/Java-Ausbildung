import java.util.Scanner;

public class index {
    public static void main(String[] args) {

        //Zuweisungs- und logische Operatoren
        //Aufgabe 2.2 Eigenschaften einer Zahl
        //
        //Schreibe ein Programm, dass von der Konsole eine Zahl einliest und ausgibt:
        //
        //ob es sich um eine runde Zahl handelt
        //ob die Zahl gerade ist
        //ob die Zahl deiner Glückszahl entspricht (denk dir hierfür einfach eine eigene Glückszahl aus und gib sie zu Beginn des Programms auf der Konsole aus
        //ob die Zahl zweistellig ist
        // Tipp: Für die ersten beiden Punkte wirst du die Modulo Funktion brauchen.
        Scanner scan = new Scanner(System.in);

        System.out.println("Gib bitte eine Zahl ein!");
        int number1 = scan.nextInt();

        //ln = Lucky Number
        int ln = 338;

        if (number1 == ln) {
            System.out.println("Die Zahl entspricht der Glückszahl!");
        } else {
            System.out.println("Die Zahl ist nicht die Glückszahl!");
        }


        if ((number1 % 2) == 0) {
            System.out.println("Die eingegebene Zahl ist eine GERADE Zahl!");
        } else {
            System.out.println("Die eingegebene Zahl ist KEINE gerade Zahl");
        }

        if (number1 >= 10 || number1 <= -10) {
            System.out.println("Die eingegebene Zahl ist zweistellig!");
        }


        //Aufgabe 2.3 Arbeits- oder Freizeit?
        //
        //In der CODERS.BAY arbeiten wir von 8 bis 16 Uhr. Schreibe ein Programm, dass eine Zahl von der Konsole einliest und ausgibt ob die Stunde in der Arbeitszeit liegt oder nicht.
        //
        //Bonus: von 12 bis 13 Uhr ist immer Mittagspause, gib also in der Zeit aus, dass Mittag ist.

        System.out.println("Welche Tages-Stunde haben wir?");
        int hour = scan.nextInt();

        if (hour >= 8 && hour <= 16) {
            System.out.println("Du befindest dich in der regulären Arbeitszeit!");
            if (hour == 12) {
                System.out.println("Du befindest dich gerade in der Mittagspause!");
            } else if (hour < 12) {
                System.out.println("Die Pause beginnt um 12 Uhr!");
            } else {
                System.out.println("Die Pause ist bereits vorbei!");
            }
        } else if (hour < 8) {
            System.out.println("Beeil dich, du fängst bald mit der arbeit an!");
        } else {
            System.out.println("Du machst gerade Gratis Überstunden!");
        }


        //Noten übersetzen
        //
        //Schreibe ein Programm, dass eine Schulnote in numerischer Form (1-5) in seine textuelle Form übersetzt:
        //
        //    Bei einer 1 wird "Sehr gut" auf die Konsole geschrieben
        //    Bei einer 2 wird "Gut" auf die Konsole geschrieben
        //    Bei einer 3 wird "efriedigend" auf die Konsole geschrieben
        //    Bei einer 4 wird "Genügend" auf die Konsole geschrieben
        //    Bei einer 5 wird "Nicht Gengügend" auf die Konsole geschrieben

        int note = 3;

        switch (note) {
            case 1:
                System.out.println("Du hast ein Sehr gut");
                break;
            case 2:
                System.out.println("Du hast ein Gut");
                break;
            case 3:
                System.out.println("Du hast ein efriedigend");
                break;
            case 4:
                System.out.println("Du hast ein Genügend");
                break;
            case 5:
                System.out.println("Du hast ein Nicht Gengügend");
                break;


        }
    }
}
