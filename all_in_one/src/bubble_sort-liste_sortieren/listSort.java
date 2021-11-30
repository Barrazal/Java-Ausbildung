import java.util.ArrayList;
import java.util.Arrays;

public class listSort {

    public static void main(String[] args) {

        //Wähle einen der bereits mit Arrays implementierten Sortieralgorithmus und ändere die Implementation derart, dass statt Arrays Listen verwendet werden. Wichtig: Es
        //soll NICHT die eingebaute Sortierfunktion des Listen Interface, sondern euer eigener Algorithmus verwendet werden

        //Sortier algorithmen
        //Bubble Sort
        //Implementiere einen Bubble Sort Algorithmus!
        //Eine super Visualisierung zu Sortieralgorithmen findest du auf http://sorting.at/. Eine gute Erklärung zur Vorgehensweise des Bubble sort findest du auf Wikipedia: https://de.wikipedia.org/wiki/Bubblesort

        int[] sort1 = {12, 9, 4, 2, 11, 7, 8, 10};
        ArrayList<Integer> arrSort1 = new ArrayList<>();

        for (int i = 0; i < sort1.length; i++) {
            arrSort1.add(i, sort1[i]);
        }


        System.out.println("Array vorher: " + Arrays.toString(sort1));

        //Zähler, damit später jeder durchlauf davon weggerechnet werden kann.
        int zaehler1 = arrSort1.size();

        //Führe die Schleife aus, bis sort1.length erreicht ist!
        for (int h = 0; h < arrSort1.size(); h++) {

            //Führe die Schleife aus, wenn der wert i kleiner als der wert zaehler1 -1 ist  ------------------------zaehler1-1 damit sort1[i+1] keine out of Bounds meldung ausgibt, da i bereits den größten Wert hat!
            for (int i = 0; i < zaehler1 - 1; i++) {
                //Wenn der Wert aus sort1[i] höher als der Wert aus sort1[i+1] ist, dann:
                if (arrSort1.get(i) > arrSort1.get(i+1)) {

                    // Erstellt eine Neue Variable für den Wert sort[i]
                    int highNumb = arrSort1.get(i);

                    // ersetzt den Wert sort1[i] mit dem nächsten Wert von sort1[i+1]  -------------    ersetzt den Niedriegeren Wert mit dem höheren!

                    arrSort1.set(i, arrSort1.get(i+1));

                    // ersetzt den Wert sort[i+1] mti dem Abgespeicherten Wert aus highNumb ----------------- setzt den Höheren Wert an die nächste Stelle!
                    arrSort1.set(i+1, highNumb);

                    // gibt die Aktuelle Operation aus!
                    System.out.println("Tauscht " + highNumb + " mit " + arrSort1.get(i));
                }
            }

            //subtrahiert nach jedem Durchlauf jeweils 1 von zaehler1
            zaehler1--;
        }

        //gibt den Array als String aus
        System.out.println("Array nachher: " + arrSort1);

    }
}
