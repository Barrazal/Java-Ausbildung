import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        //Sortier algorithmen
        //Bubble Sort
        //Implementiere einen Bubble Sort Algorithmus!
        //Eine super Visualisierung zu Sortieralgorithmen findest du auf http://sorting.at/. Eine gute Erklärung zur Vorgehensweise des Bubble sort findest du auf Wikipedia: https://de.wikipedia.org/wiki/Bubblesort

        int[] sort1 = {12, 9, 4, 2, 11, 7, 8, 10};
        System.out.println("Array vorher: " + Arrays.toString(sort1));

        //Zähler, damit später jeder durchlauf davon weggerechnet werden kann.
        int zaehler1 = sort1.length;

        //Führe die Schleife aus, bis sort1.length erreicht ist!
        for (int h = 0; h < sort1.length; h++) {

            //Führe die Schleife aus, wenn der wert i kleiner als der wert zaehler1 -1 ist  ------------------------zaehler1-1 damit sort1[i+1] keine out of Bounds meldung ausgibt, da i bereits den größten Wert hat!
            for (int i = 0; i < zaehler1 - 1; i++) {

                //Wenn der Wert aus sort1[i] höher als der Wert aus sort1[i+1] ist, dann:
                if (sort1[i] > sort1[i + 1]) {

                    // Erstellt eine Neue Variable für den Wert sort[i]
                    int highNumb = sort1[i];

                    // ersetzt den Wert sort1[i] mit dem nächsten Wert von sort1[i+1]  -------------    ersetzt den Niedriegeren Wert mit dem höheren!
                    sort1[i] = sort1[i + 1];

                    // ersetzt den Wert sort[i+1] mti dem Abgespeicherten Wert aus highNumb ----------------- setzt den Höheren Wert an die nächste Stelle!
                    sort1[i + 1] = highNumb;

                    // gibt die Aktuelle Operation aus!
                    System.out.println("Tauscht "+ highNumb + " mit " + sort1[i]);
                }
            }

            //subtrahiert nach jedem Durchlauf jeweils 1 von zaehler1
            zaehler1--;
        }

        //gibt den Array als String aus
        System.out.println("Array nachher: " + Arrays.toString(sort1));
    }
}
