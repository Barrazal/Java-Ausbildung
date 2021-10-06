import java.util.ArrayList;

public class listSort {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 7, 4, 5, 6, 3, 2, 8, 54, 87, 31, 26, 41, 18, 37, 51, 27, 94, 17, 13, 34, 64, 29, 47, 10, 19, 12, 100, 53, 15, 25, 75};
                ArrayList<Integer> arrNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            arrNumbers.add(numbers[i]);
        }
        System.out.println("Vor der Sortierung: ");
        System.out.println(arrNumbers);

        arrNumbers = divide(arrNumbers);

        System.out.println("Nach der Sortierung: ");
        System.out.println(arrNumbers);
    }


    private static ArrayList<Integer> divide(ArrayList<Integer> divInt) {
        //Fuehrt solange die Divide methode aus, solange "divInt.length" größer als 1 ist
        if (divInt.size() > 1) {
            int half = divInt.size() / 2;

            ArrayList<Integer> left = new ArrayList<>();
            int leftnum = 0;
            //jeder wert, der sich im Bereich "half" befindet, soll in left abgesichert werden
            for (int i = 0; i < half; i++) {
                left.add(leftnum, divInt.get(i));
                System.out.println(left + " l");
            }
            //Erstellt einen neuen Array mit dem Restwert "divInt.length - half"
            ArrayList<Integer> right = new ArrayList<>();
            int rightnum = 0;
            //Für jeden wert der sich zwischen "half" und (divInt.length-1) befindet sollen die Werte in right abgesichert werden
            for (int i = half; i < divInt.size(); i++) {

                //nimmt die Variable "i" und rechnet davon den Wert "half" weg, damit beim Index 0 begonnen wird
                right.add(rightnum, divInt.get(i));
                System.out.println(right + " r");
            }
            //Fuehrt solange die Divide methode aus, wenn die if Bedingung erfolgt ist, ansonsten springt es zum nächsten Punkt
            left = divide(left);
            System.out.println();
            System.out.println(left + " left single mergesort output");

            //Fuehrt solange die Divide methode aus, wenn die if Bedingung erfolgt ist, ansonsten springt es zum nächsten Punkt
            right = divide(right);
            System.out.println();
            System.out.println(right + " right single mergesort output");

            System.out.println();
            System.out.println(left + " + " + right + "");
            System.out.println();

            //Fügt die Werte aus left und right innerhalb der Methode "merge" aus
            return merge(left, right);

        } else {
            //Gibt den wert von divInt an den Aufrufer zurück
            return divInt;
        }
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {

        //Erstelle einen neuen IntegerArray mit der Laenge von left und right
        ArrayList<Integer> sortInt = new ArrayList<>(left.size() + right.size());
        int leftIndex = 0;
        int rightIndex = 0;
        int sumIndex = 0;


        while (leftIndex < left.size() && rightIndex < right.size()) {

            if (left.get(leftIndex) < right.get(rightIndex)) {
                sortInt.add(sumIndex, left.get(leftIndex));
                leftIndex++;

            } else {
                sortInt.add(sumIndex, right.get(rightIndex));
                rightIndex++;

            }
            sumIndex++;
        }

        while (leftIndex < left.size()) {
            sortInt.add(sumIndex, left.get(leftIndex));
            leftIndex++;
            sumIndex++;
        }
        while (rightIndex < right.size()) {
            sortInt.add(sumIndex, right.get(rightIndex));
            rightIndex++;
            sumIndex++;
        }

        return sortInt;
    }
}



