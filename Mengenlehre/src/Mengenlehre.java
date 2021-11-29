//import java.util.Collections;

import java.util.Arrays;
import java.util.HashSet;

public class Mengenlehre {
    public static void main(String[] args) {
        Integer[] a = {49, 30, 14, 47, 13, 2, 12, 29, 19, 11, 15, 39, 43, 45, 34};
        Integer[] b = {39, 33, 38, 14, 4, 32, 40, 25, 17, 46, 35, 6, 2, 12, 49};
        Integer[] c = {41, 12, 5, 35, 42, 28, 47, 20, 26, 24, 50, 40, 14, 17, 10};

        System.out.println();
        System.out.println("Vereinigungsmenge von 'A u B u C' ist: " + unificationQuantity(a, b, c));
        System.out.println();
        System.out.println("Schnittmengen  von 'A u B u C' ist: " + intersections(a, b, c));
        System.out.println();
        System.out.println("Differenzmenge von (A / B) / C : " + differences(a ,b ,c));
        System.out.println();
        System.out.println("Differenzmenge von (B / C) / A : " + differences(b ,c ,a));
        System.out.println();
        System.out.println("Differenzmenge von (C / B) / A : " + differences(c ,a ,b));
    }

    private static HashSet<Integer> unificationQuantity(Integer[] a, Integer[] b, Integer[] c) {
        HashSet<Integer> mergNum = new HashSet<>();
        mergNum.addAll(Arrays.asList(a));
        mergNum.addAll(Arrays.asList(b));
        mergNum.addAll(Arrays.asList(c));
        return mergNum;
    }
    //private static Set<Integer> unificationQuantity(Integer[] a, Integer[] b, Integer[] c) {
    //    Set<Integer> mergNum = new HashSet<Integer>();
    //    Collections.addAll(mergNum, a);
    //    Collections.addAll(mergNum, b);
    //    Collections.addAll(mergNum, c);
    //    return mergNum;
    //}

    private static HashSet<Integer> intersections(Integer[] a, Integer[] b, Integer[] c) {
        HashSet<Integer> resNumb = new HashSet<>();
        resNumb.addAll(Arrays.asList(a));
        resNumb.retainAll(Arrays.asList(b));
        resNumb.retainAll(Arrays.asList(c));
        return resNumb;
    }


    private static HashSet<Integer> differences(Integer[] one, Integer[] two, Integer[] three) {
        HashSet<Integer> resNumb = new HashSet<>();
        resNumb.addAll(Arrays.asList(one));
        resNumb.removeAll(Arrays.asList(two));
        resNumb.removeAll(Arrays.asList(three));
        return resNumb;
    }
}
