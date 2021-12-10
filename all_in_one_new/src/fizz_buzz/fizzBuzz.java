public class fizzBuzz {
    public static void main(String[] args) {

        //Schleifen
        //Aufgabe 5.1 FizzBuzz
        //
        //FizzBuzz ist ein Spiel um Kindern Division näher zu bringen. Die Regeln sind einfach - Reih um wird beginnend bei der Zahl 1 nach oben gezählt.
        // Ist die Zahl durch drei teilbar, darf die Zahl allerdings nicht genannt werden - man muss Fizz sagen, ist die Zahl durch fünf teilbar muss Buzz gesagt werden.
        // Und - ist die Zahl durch drei und fünf teilbar, muss FizzBuzz gesagt werden.
        //
        //Als Beispiel: “Eins! Zwei! Fizz(3)! Vier! Buzz(5)! Fizz(6)! Sieben! Acht! Fizz(9)! Buzz(10)!”
        //
        //Schreibe ein Programm, dass die Zahlen von 1 - 100 nach diesem Schema ausgibt. Du musst die Zahlen nicht in Wortform ausgeben, numerisch reicht.



        for (int i = 1; i <= 100; i++) {
            if ((i % 3) == 0) {
                System.out.println("Fizz (" + (i) + ")");
            } else if ((i % 5) == 0) {
                System.out.println("Buzz (" + (i) + ")");
            } else {
                System.out.println(i);
            }
        }





        start();


    }

    private static void start() {
        for (int i = 1; i <= 100; i++) {
            if ((i % 3) == 0) {
                fizz(i);
            } else if ((i % 5) == 0) {
                buzz(i);
            } else {
                System.out.println(i);
            }
        }
    }


    private static void fizz(int i) {
        System.out.println("Fizz (" + (i) + ")");
    }

    private static void buzz(int i) {
        System.out.println("Buzz (" + (i) + ")");
    }
}
