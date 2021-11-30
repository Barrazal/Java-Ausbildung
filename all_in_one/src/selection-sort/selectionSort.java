import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {


        //int[] unsorted = {6, 2, 4, 9, 3, 7};
        int[] unsorted = {62, 24, 49, 92, 31, 70, 38, 15, 76, 19, 71, 28, 16, 17, 29, 78, 98, 52, 61, 54, 32, 18, 47, 64, 56};

        System.out.println("Vor der Sortierung: ");
        System.out.println( Arrays.toString(unsorted));
        System.out.println();


        int safeNumb = 0;
        int sortLength = 0;


        for (int i = sortLength; i < unsorted.length-1; i++) {

            for (int j = i; j < unsorted.length; j++) {

                //Wenn der wert "unsorted[j]" kleiner als der Wert von "unsorted[i]" ist, dann
                if (unsorted[j] < unsorted[i]) {

                    //Speichere den wert von unsorted[i] in "safeNumb" ab
                    safeNumb = unsorted[i];

                    //Ändere den Wert von "unsorted[i]" in den Wert von "unsorted[j]"
                    unsorted[i] = unsorted[j];

                    //Zum schluss lese den wert von "safeNumb" aus und überschreibe damit den wert von "unsorted[j]"
                    unsorted[j] = safeNumb;
                    System.out.println("tausche: "+ unsorted[i]+ " mit "+ unsorted[j]);
                }
            }
            System.out.println(Arrays.toString(unsorted));
            System.out.println();

            //Erhoehe den wert von sortLength um 1, damit der entsprechende Index bei der durchsuchung übersprungen wird (gilt als Sortiert)
            sortLength++;
        }
        System.out.println("Nach der Sortierung: ");
        System.out.println(Arrays.toString(unsorted));
    }



    /*
// siehe https://studyflix.de/informatik/selectionsort-1323


    erstelle neuen Array
    erstelle Variable zum speichern
    erstelle Variable für die Position des zu speichernden wertes

    Führe eine Schleife aus, um den Array zu durchsuchen
    Führe eine Schleife aus, die den Array nach dem kleinsten Wert durchsucht.
    Wenn der durchsuchte Index kleiner als die gespeicherte Variable ist
    dann ersetze diese durch den aktuellen Wert und ändere den aktuellen Index mit dem Alten Wert
    */


}
