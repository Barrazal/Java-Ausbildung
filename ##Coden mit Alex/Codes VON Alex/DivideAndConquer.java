import java.util.Arrays;

public class DivideAndConquer {
    public static void main(String[] args) {
        int[] myArr = { 45, 12, -56, 9, 3, 100, -500 };
        System.out.println("Minimum: "+ findMin(myArr));
    }

    /*
    45 - 12 - -56 - 9 - 3 // split
    45 / 12 / -56 / 9 - 3 // split
                   9 / 3 // split
     */

    private static int findMin(int[] myArr) {
        if (myArr.length > 1) {
            int[] left = Arrays.copyOfRange(myArr, 0, myArr.length/2);
            int[] right = Arrays.copyOfRange(myArr, myArr.length/2, myArr.length);

            int resultLeft = findMin(left);
            int resultRight = findMin(right);
            return (resultLeft < resultRight ? resultLeft : resultRight);
        } else {
            return myArr[0];
        }
    }

}
