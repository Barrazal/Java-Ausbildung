import java.util.Arrays;
import java.util.HashSet;


public class sumofTwo {
    public static void main(String[] args) {


        int[] a = {2, 7, 6, 9, 12, 4};
        int[] b = {5, 0, 3, 69, 8, 4};
        int v = 8;
        System.out.println(sumOfTwo(a, b, v));
    }

    public static boolean sumOfTwo(int[] a, int[] b, int v) {

        HashSet<Integer> hash1 = new HashSet<Integer>();
        Integer[] b_int = new Integer[b.length];

        //Temporary Count
        int count = 0;


        //bool if Contain or not
        boolean out = false;

        //Write all from int[] b to Integer b_int
        for (int i = 0; i < b.length; i++) {
            b_int[i] = Integer.valueOf(b[i]);
        }

        //Add all from Integer into HashSet:
        hash1.addAll(Arrays.asList(b_int));

        // run
        while (!out && count < hash1.size()) {
            Integer v_int = Integer.valueOf(v);
            Integer a_int = Integer.valueOf(a[count]);
            Integer i = v_int - a_int;

            if (hash1.contains(i)) {
                out = true;
                System.out.println("Needed Runs: " + (count+1));
            }
            count++;
        }
        return out;
    }


    //   public static boolean sumOfTwo_two(int[] a, int[] b, int v){
//
    //       //Create Integer Hashset from int Array
    //       HashSet<Integer> hash1 = new HashSet<Integer>();
    //       HashSet<Integer> hash2 = new HashSet<Integer>();
    //       Integer[] a_int = new Integer[a.length];
    //       Integer[] b_int = new Integer[b.length];
//
    //       //create Integer from int Value
    //       Integer v_int = Integer.valueOf(v);
//
    //       //Integer for Return if contain or not
    //       Integer Output;
//
    //       //bool if Contain
    //       boolean out = false;
//
    //       //Write all from int[] a to Integer a_int
    //       for (int i =0; i < a.length; i++){
    //           a_int[i] = Integer.valueOf(a[i]);
    //       }
    //       //Write all from int[] b to Integer b_int
    //       for (int i =0; i < b.length; i++){
    //           b_int[i] = Integer.valueOf(b[i]);
    //       }
//
    //       //add All Integer to Hashset!
    //       hash1.addAll(Arrays.asList(a_int));
    //       hash2.addAll(Arrays.asList(b_int));
//
    //       for (int i:hash1){
    //           Integer custom = v_int + hash1.(i);
    //       }
//
    //       hash2.contains(Output);
    //       return out;
    //   }
}
