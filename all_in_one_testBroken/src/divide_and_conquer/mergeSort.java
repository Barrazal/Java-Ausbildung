import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 7, 4, 5, 6, 3, 2, 8, 54, 87, 31, 26, 41, 18, 37, 51, 27, 94, 17, 13, 34, 64, 29, 47};
        System.out.println("Vor der Sortierung: ");
        System.out.println(Arrays.toString(numbers));

        numbers = divide(numbers);

        System.out.println();
        System.out.println("Nach der Sortierung: ");
        System.out.println(Arrays.toString(numbers));
    }


    private static int[] divide(int[] divInt) {
        //Fuehrt solange die Divide methode aus, solange "divInt.length" größer als 1 ist
        if (divInt.length > 1) {
            int half = divInt.length / 2;

            ////Erstellt einen neuen Array mit dem wert "half"
            int[] left = new int[half];
            //jeder wert, der sich im Bereich "half" befindet, soll in left abgesichert werden
            for (int i = 0; i < half; i++) {
                left[i] = divInt[i];
            }

            //Erstellt einen neuen Array mit dem Restwert "divInt.length - half"
            int[] right = new int[divInt.length - half];
            //Für jeden wert der sich zwischen "half" und (divInt.length-1) befindet sollen die Werte in right abgesichert werden
            for (int i = half; i < divInt.length; i++) {

                //nimmt die Variable "i" und rechnet davon den Wert "half" weg, damit beim Index 0 begonnen wird
                right[i - half] = divInt[i];
            }

            //Fuehrt solange die Divide methode aus, wenn die if Bedingung erfolgt ist, ansonsten springt es zum nächsten Punkt
            left = divide(left);

            //Fuehrt solange die Divide methode aus, wenn die if Bedingung erfolgt ist, ansonsten springt es zum nächsten Punkt
            right = divide(right);

            //Fügt die Werte aus left und right innerhalb der Methode "merge" aus
            return merge(left, right);

        } else {
            //Gibt den wert von divInt an den Aufrufer zurück
            return divInt;
        }
    }

    private static int[] merge(int[] left, int[] right) {

        //Erstelle einen neuen IntegerArray mit der Laenge von left und right
        int[] sortInt = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int sumIndex = 0;


        while (leftIndex < left.length && rightIndex < right.length) {

            if (left[leftIndex] < right[rightIndex]) {
                sortInt[sumIndex] = left[leftIndex];
                leftIndex++;

            } else {
                sortInt[sumIndex] = right[rightIndex];
                rightIndex++;

            }
            sumIndex++;
        }

        while (leftIndex < left.length) {
            sortInt[sumIndex] = left[leftIndex];
            leftIndex++;
            sumIndex++;
        }
        while (rightIndex < right.length) {
            sortInt[sumIndex] = right[rightIndex];
            rightIndex++;
            sumIndex++;
        }

        return sortInt;
    }
}
