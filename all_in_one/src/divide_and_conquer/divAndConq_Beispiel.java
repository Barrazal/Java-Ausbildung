import java.util.Arrays;
import java.util.Scanner;

public class divAndConq_Beispiel {
    public static void main(String[] args) {
        int[] sort1 = {9, 1, 7, 4, 5, 6, 3, 2, 8};
        System.out.println(Arrays.toString(sort1));
        int[] sort2 = Mergesort(sort1);
        System.out.println(Arrays.toString(sort2));

    }

    // Beispiel: https://studyflix.de/informatik/mergesort-1324


    private static int[] Mergesort(int[] a) {
        if (a.length > 1) {
            int mitte = a.length / 2;

            int[] l = new int[mitte];

            for (int i = 0; i <= mitte - 1; i++) {
                l[i] = a[i];
                System.out.println(Arrays.toString(l) + " l");
            }

            int[] r = new int[a.length - mitte];

            for (int i = mitte; i <= a.length - 1; i++) {
                r[i - mitte] = a[i];
                System.out.println(Arrays.toString(r) + " r");
            }

            l = Mergesort(l);
            System.out.println(Arrays.toString(l) + " left single mergesort output");
            r = Mergesort(r);
            System.out.println(Arrays.toString(r) + " right single mergesort output");
            System.out.println();
            System.out.println(Arrays.toString(l) + " + " + Arrays.toString(r) + "");
            System.out.println();
            return verschmelze(l, r);
        } else {
            {
                return a;
            }
        }

    }

    private static int[] verschmelze(int[] l, int[] r) {
        int[] neul = new int[l.length + r.length];
        int indexl = 0;
        int indexr = 0;
        int indexergebnis = 0;
        while (indexl < l.length && indexr < r.length) {
            if (l[indexl] < r[indexr]) {
                neul[indexergebnis] = l[indexl];
                indexl += 1;
            } else {
                neul[indexergebnis] = r[indexr];
                indexr += 1;
            }
            indexergebnis += 1;
        }
        while (indexl < l.length) {
            neul[indexergebnis] = l[indexl];
            indexl += 1;
            indexergebnis += 1;
        }
        while (indexr < r.length) {
            neul[indexergebnis] = r[indexr];
            indexr += 1;
            indexergebnis += 1;
        }
        return neul;
    }
}


