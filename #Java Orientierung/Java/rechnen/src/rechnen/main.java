package rechnen;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1, number2, ergebnis;
		number1=16;
		number2=3;
		ergebnis=number1 + number2;											// Addieren mit 2 Werten und ergebnis
		System.out.println(number1+ " + " + number2 +" ergibt: " + ergebnis); 
		ergebnis=number1 - number2;											// Subtrahieren von 2 Werten und ergebnis
		System.out.println(number1+ " - " + number2 +" ergibt: " + ergebnis); 
		ergebnis=number1 * number2;											// Multiplikation von 2 Werten und ergebnis
		System.out.println(number1+ " * " + number2 +" ergibt: " + ergebnis); 
		ergebnis=number1 / number2;											// Division von 2 Werten und ergebnis
		System.out.println(number1+ " / " + number2 +" ergibt: " + ergebnis); 
		ergebnis= number1%number2;											//Restberechnung
		System.out.println(number1+ " % " + number2 +" ergibt: " + ergebnis + " Rest"); 
			
		
		number1--;															//Verringert number1 und number2 um je einen zähler									
		number2--;
		System.out.println("verringert die werte um 1" + number1 + " und " + number2 );  
		number1++;															//zuruecksetzen auf ursprungswert
		number2++;															//zuruecksetzen auf ursprungswert
		
		
		number1++;															//Erhöht number1 und number2 um je einen zähler
		number2++;
		System.out.println("erhoeht die werte um 1" + number1 + " und " + number2 ); 
		
		number1--;															//zuruecksetzen auf ursprungswert
		number2--;															//zuruecksetzen auf ursprungswert
		
		System.out.println();												//Leerzeile
		System.out.println();												//Leerzeile
		
		System.out.println(number1 + " + " + number2 + " ergibt: " + (number1 + number2));//Test
		
		System.out.println();												//Leerzeile
		System.out.println(number1);
		number1*=5;
		System.out.println(number1);
	}

}
