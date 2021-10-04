import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {
        try {
            System.out.println(divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Division by Zero!");
        }

        try {
            enterPub();
        } catch(AgeRestriction e) {
            System.out.println(e.getMessage());
        }

        // further code
    }

    public static void enterPub() throws AgeRestriction {
        int age = 0;
        Scanner sc1 = new Scanner(System.in);

        System.out.println("This is the Linz-Pub.");
        System.out.println("How old are you?");
        age = sc1.nextInt();

        if (age < 16) {
            throw new AgeRestriction("You need to be at least 16 years old to enter this pub!");
        } else {
            System.out.println("Welcome to the Pub!");
        }

        try {
            orderSchnaps(age);
        } catch(AgeRestriction e) {
            System.out.println(e.getMessage());
        }
    }

    public static void orderSchnaps(int age) throws AgeRestriction {
        if (age < 18) {
            throw new AgeRestriction("You need to be at least 18 years old to drink Schnaps!");
        } else {
            System.out.println("Prost!");
        }
    }

    /*
    Problematic approach - as the return value is WRONG in case an exception is triggered!
    public static double divide(int numerator, int denominator) {
        double result = 0.0;
        try {
            result = numerator / denominator;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
     */

    // Better approach:
    public static double divide(int numerator, int denominator) throws ArithmeticException {
        double result = 0.0;
        result = numerator / denominator;
        return result;
    }



    /*
    ? ? ?
    ? x ?
    ? ? ?
     */

    /*
    field ( x * x) ... 2-dim Array representing the game-of-life generation
    -> 0 = dead
    -> 1 = alive
    x, y ... coordinates
     */
    public static int getNeighbours(int[][] field, int x, int y) {
        int result = 0;

        for(int i=x-1; i<=x+1; i++) {
            for(int j=y-1; j<=y+1; j++) {
                try {
                    result += field[i][j];
                } catch (IndexOutOfBoundsException e) {
                    result += 0;
                }
            }
        }

        result -= field[x][y];
        return result;
    }
}
