import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        //Insertion Sort
        //Implementiere einen Insertion Sort Algorithmus!
        //Eine super Visualisierung zu Sortieralgorithmen findest du auf http://sorting.at/. Eine gute Erklärung zur Vorgehensweise des Insertion sort findest du auf Wikipedia: https://de.wikipedia.org/wiki/Insertionsort


        int[] sort1 = {5, 9, 4, 2, 11, 7, 8, 10, 1, 3, 6, 12};
        System.out.println("Array Vorher: " + Arrays.toString(sort1));

        //Ermittelt die Laenge des Arrays
        for (int i = 0; i < sort1.length; i++) {

            // Deklariert und Initialisiert die Variable sortNumber anhand des aktuellen wertes von sort1[i]
            int sortNumber = sort1[i];

            // erstellt einen Zähler anhand der aktuellen for schleifen position
            int j = i;

            // solange j > als 0 und der Wert von sort1[j-1] größer als sortNumber ist
            while ((j > 0) && (sort1[j - 1] > sortNumber)) {

                //ändere sort1[j] in sort1[j-1]
                sort1[j] = sort1[j - 1];

                //danach ändere j in j-1
                j = j - 1;
            }
            //wenn die while schleife nicht mehr fortgesetzt werden kann, ändere den Inhalt von sort1[j] in sortNumber
            sort1[j] = sortNumber;
        }
        System.out.println("Array nachher: " + Arrays.toString(sort1));

    }
}
