import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int zahl1, zahl2, ergebnis;
		
		System.out.println("Erste Zahl eingeben:");		//erste Zahl aus Consolenfeld
		Scanner scannerVariable = new Scanner(System.in);
		zahl1 = scannerVariable.nextInt();
		
		System.out.println("Zweite Zahl eingeben:");		//zweite Zahl aus Consolenfeld
		zahl2 = scannerVariable.nextInt();
		ergebnis = zahl1 + zahl2;
		System.out.println(zahl1 + " + " + zahl2 + " ergibt: " + (zahl1+zahl2));
		
		
	}

}
