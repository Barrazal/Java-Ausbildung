package caesar_chiffre;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Schreibe ein kleines Programm, welches einen String über die Konsole einliest. Übersetzte den Text dann in Leetspeak - Du darfst dir hier eine beliebige Konfiguration verwenden, falls dir keine einfällt hier ein Vorschlag:
        //Wenn du eine andere verwendest bitte in einer Markdown Datei deine Wahl angeben ;)

        //Nutze StringBuilder!
        Scanner scan = new Scanner(System.in);


        char[] clear = {'A', 'B', 'C', 'E', 'G', 'H', 'I', 'L', 'O', 'S', 'T'};
        char[] clearLow = {'a', 'b', 'c', 'e', 'g', 'h', 'i', 'l', 'o', 's', 't'};
        char[] leet = {'@', '8', '(', '3', '6', '#', '!', '1', '0', '$', '7'};

        System.out.println("Gib bitte deinen text in Klarschrift ein!");
           StringBuilder stringB1 = new StringBuilder(scan.nextLine());
        //   StringBuilder stringB1 = new StringBuilder("Aa Bb Cc Dd Ee Ff Gg Hh Ii Jj Kk Ll Mm Nn Oo Pp Qq Rr Ss Tt Uu Vv Ww Xx Yy Zz");

        for (int i = 0; i < stringB1.length(); i++) {
            boolean found = false;
            int k = 1;

            for (int j = 0; j < clear.length; j++) {
                if (stringB1.charAt(i) == clear[j] || stringB1.charAt(i) == clearLow[j]) {
                    stringB1.setCharAt(i, leet[j]);
                    found = true;
                }
                /*
                else if ((k == clear.length) && (stringB1.charAt(i) != ' ') && !found) {
                    stringB1.setCharAt(i,'-');
                }
                */
                k++;
            }
        }


        /*
        for (int i = 0; i < stringB1.length(); i++) {
            for (int j = 0; j < clear.length; j++) {
                if (stringB1.charAt(i) == clear[j]) {
                    stringB1.setCharAt(i, leet[j]);


                }
            }
        }

        */
        System.out.println();
        System.out.println();
        System.out.println("Hier deine Leetspeak ausgabe:");
        System.out.println(stringB1);

/*
        String scannerIn = "ZYX WVU TSR QPO NML KJI HGF EDC BA";
        scannerIn = scannerIn.toUpperCase();
        StringBuilder stringB1 = new StringBuilder(scannerIn);

        char[] leetText = scannerIn.toCharArray();

        for (int i = 0; i <leetText.length; i++){

            for (int j = 0; j < clear.length; j++){
                if (leetText[i] == clear[j]){
                    leetText[i] = leet[j];
                }
            }
        }
        System.out.println(leetText);
*/
    }
}

