import java.util.Scanner;

public class divAndConq {
    public static void main(String[] args) {
        int[] sort1 = {3, 7, 1, 8, 2, 5, 9, 4, 6};
        Scanner sc = new Scanner(System.in);
        divAndConq obj = new divAndConq();
    }

    //  3 7 1 8 2 5 9 4 6

    //  3 7 1 8 - 2 5 9 4 6

    //  3 7 - 1 8 - 2 5 - 9 4 6

    //  3 - 7 - 1 - 8 - 2 - 5 - 9 - 4 6
    //                              4 - 6


    // Beispiel: https://studyflix.de/informatik/mergesort-1324



    public static int merge_sort(int[] a) {
        if (a.length > 1) {
            int mitte = (int) a.length / 2;

            int[] l = new int[mitte];

            for (int i = 0; i <= mitte - 1; i++) {
                l[i] = a[i];
            }

            int[] r = new int[a.length - mitte];

            for (int i = mitte; i <= a.length - 1; i++) {
                r[i - mitte] = a[i];
            }

            l = merge_sort(l);
            r = merge_sort(r);
            return  verschmelze(l,r);
        }else{
            {
                return a;
            }
        }

    }
}


