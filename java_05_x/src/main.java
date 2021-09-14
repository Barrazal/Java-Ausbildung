import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        /*

        //Schleifen
        //Aufgabe 5.1 FizzBuzz
        //
        //FizzBuzz ist ein Spiel um Kindern Division näher zu bringen. Die Regeln sind einfach - Reih um wird beginnend bei der Zahl 1 nach oben gezählt.
        // Ist die Zahl durch drei teilbar, darf die Zahl allerdings nicht genannt werden - man muss Fizz sagen, ist die Zahl durch fünf teilbar muss Buzz gesagt werden.
        // Und - ist die Zahl durch drei und fünf teilbar, muss FizzBuzz gesagt werden.
        //
        //Als Beispiel: “Eins! Zwei! Fizz(3)! Vier! Buzz(5)! Fizz(6)! Sieben! Acht! Fizz(9)! Buzz(10)!”
        //
        //Schreibe ein Programm, dass die Zahlen von 1 - 100 nach diesem Schema ausgibt. Du musst die Zahlen nicht in Wortform ausgeben, numerisch reicht.

        for (int i = 1; i <= 100; i++) {
            if ((i % 3) == 0) {
                System.out.println("Fizz (" + (i) + ")");
            } else if ((i % 5) == 0) {
                System.out.println("Buzz (" + (i) + ")");
            } else {
                System.out.println(i);
            };
        };


        */

        //Aufgabe 5.2 - Das kleine Einmal-Eins
        //
        //Schreibe mit Hilfe von Schleifen das kleine 1 x 1 auf der Konsole aus. Deine Ausgabe sollte in etwa folgendermaßen aussehen:
        //
        //1er Reihe:
        //1 * 1 = 1
        //2 * 1 = 2
        //...
        //10 * 1 = 10
        //2er Reihe:
        //1 * 2 = 2
        //…
        //9 * 10 = 90
        //10 * 10 = 100


        /*
        System.out.println();
        System.out.println("1x1 mit For-Schleife");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(j + " * " + i + " = " + (i * j));
            };
            System.out.println("");
        };

        System.out.println();
        System.out.println("1x1 mit do-While Schleife");
        int j;
        int i = 1;

        do {
            j = 1;
            do {
                System.out.println(j + " * " + i + " = " + (i * j));
                j++;
            } while (j <= 10);
            System.out.println("");
            i++;
        } while (i <= 10);



        System.out.println();
        System.out.println("1x1 mit While Schleife");


        int k = 1;
        while(k<= 10){
            j=1;
            while(j<= 10){
                System.out.println(j + " * " + k + " = " + (j * k));
                j++;
            };
            System.out.println("");
            k++;
        };
*/

        /*
        Aufgabe 5.3 - Caesar Chiffre

        Wir wissen ja, dass jedes Zeichen in Java einen eindeutigen Code hat. Genauergesagt ist die numerische Repräsentation eines Characters/Zeichens der Unicode.
        Die Caesar Chiffre ist ein simpler Verschlüsselungsalgorithmus bei dem alle Buchstaben um einen bestimmten offset X verschoben werden,
         erreichst du das Z solltest du wieder beim A starten, Sonderzeichen werden wir jetzt einmal auslassen.
        Mit einer Caesar Chiffre von 6 würde aus dem Text:
        Ein Charakter namens Caesar!
        folgendes werden:
        Kot Ingxgqzkx tgskty Igkygx!
        wenn wir diesen Text nochmal um 6 verschlüsseln würde aus dem Text:
        Quz Otmdmwfqd zmyqze Omqemd!
        Schreib ein Programm dass von der Konsole einen beliebiglangen Text einliest, danach zufällig einen Schlüssel zwischen 1 und 26 wählt und den verschlüsselten String ausgibt.
        siehe Schrödinger s.84

     int rotation = 6;
        byte letter = 'X';
        System.out.println((char) letter);


        int aStart = 'A';
        int aEnd = 'Z';
        letter -= aStart;
        letter += rotation;
        letter %= 26;
        letter += aStart;


        System.out.println((char) letter);

        letter -= aStart;
        letter -= rotation;
        letter %= 26;
        if (letter < 0) {
            letter += aEnd + 1;
        } else {
            letter += aStart;
        }


        System.out.println((char) letter);

*/


        Scanner scan = new Scanner(System.in);
        System.out.println("Gibt einen Satz ein!");
        String chiffre = scan.nextLine();

        char[] letterArr = chiffre.toCharArray();
        Random num = new Random();
        int rotation = num.nextInt(15 - 1);

        // String chiffre = "Ein Charakter namens Caesar!";
        //int rotation = 2;

        System.out.println();
        System.out.println();
        System.out.println("Original:");
        System.out.println(letterArr);
        System.out.println();
        System.out.println();


        for (int h = 0; h < 2; h++) {


            for (int i = 0; i < letterArr.length; i++) {
                if (letterArr[i] >= 'A' && letterArr[i] <= 'Z') {
                    byte letter = (byte) letterArr[i];
                    int aStart = 'A';
                    letter -= aStart;
                    letter += rotation;
                    letter %= 26;
                    letter += aStart;
                    letterArr[i] = (char) letter;
                } else if (letterArr[i] >= 'a' && letterArr[i] <= 'z') {
                    byte letter = (byte) letterArr[i];
                    int aStart = 'a';
                    letter -= aStart;
                    letter += rotation;
                    letter %= 26;
                    letter += aStart;
                    letterArr[i] = (char) letter;
                }
            }
            System.out.println((h + 1) + ". Chiffrierung");
            System.out.println(letterArr);
            System.out.println();
            System.out.println();
        }

        for (int h = 0; h < 2; h++) {
            for (int i = 0; i < letterArr.length; i++) {
                if (letterArr[i] >= 'A' && letterArr[i] <= 'Z') {
                    byte letter = (byte) letterArr[i];
                    int aStart = 'A';
                    int zEnd = 'Z';
                    letter -= aStart;
                    letter -= rotation;
                    letter %= 26;
                    if (letter < 0) {
                        letter += zEnd + 1;
                    } else {
                        letter += aStart;
                    }
                    letterArr[i] = (char) letter;
                } else if (letterArr[i] >= 'a' && letterArr[i] <= 'z') {
                    byte letter = (byte) letterArr[i];
                    int aStart = 'a';
                    int zEnd = 'z';
                    letter -= aStart;
                    letter -= rotation;
                    letter %= 26;
                    if (letter < 0) {
                        letter += zEnd + 1;
                    } else {
                        letter += aStart;
                    }
                    letterArr[i] = (char) letter;
                }
            }
            System.out.println((h + 1) + ". Dechiffrierung");
            System.out.println(letterArr);
            System.out.println();
            System.out.println();
        }
    }
}

