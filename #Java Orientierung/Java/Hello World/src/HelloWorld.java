
public class HelloWorld {

	public static void main(String[] args) {
		String satz = "Hello World";
		System.out.println(satz + " - Guten Tag");

		int number = 1; // eine einfache Zahl
		System.out.println("Eine Zahl:	 " + number);

		String vorname = "Max"; // Vorname
		String nachname = "Mustermann"; // Nachname
		System.out.println(vorname + ", Hier eine Zahl: " + number + ", " + nachname);

		int add = number + 5; // Berechnen von Ganzzahlen
		System.out.println("Berechnete Zahl: " + add);

		double comma = 6.734; // eine Zahl mit Kommata
		System.out.println(comma);

		int number2 = 20;
		double comma2 = comma + number2 - number; // Berechnung von ganzen und kommazahlen
		System.out.println(comma2);

		if (number2 < 20) { // abfrage ob number2 unter oder über 20 liegt
			System.out.println("unter 20");
		} else {
			System.out.println("über 20");
		}

		System.out.println();
		System.out.println();

		// Relationale Operatoren Berechnung:
		byte a = 5;
		byte b = 3;
		boolean c; // vergleiswert

		System.out.println("a=" + a);
		System.out.println("b=" + b);

		c = a == b; // Wertüberprüfung auf Gleichheit
		System.out.println("a==b, Ergebnis: " + c);

		c = a != b; // Wertüberprüfung auf Ungleichheit
		System.out.println("a!=b, Ergebnis: " + c);

		c = a > b; // größer
		System.out.println("a>b, Ergebnis: " + c);

		c = a < b; // kleiner
		System.out.println("a<b, Ergebnis: " + c);

		c = a >= b; // größer gleich
		System.out.println("a>=b, Ergebnis: " + c);

		c = a <= b; // größer gleich
		System.out.println("a<=b, Ergebnis: " + c);

		System.out.println();
		System.out.println();

		// Logische Operatoren:

		boolean d = true;
		boolean e = false;

		System.out.println("d=" + d);
		System.out.println("e=" + e);

		c = d && e; // ist d und e wahr?
		System.out.println("ist d und e gleich? " + c);

		c = d || e; // ist d oder e wahr?
		System.out.println("ist d oder/und e auf true? " + c);

		c = !d; // kehrt d um
		System.out.println("kehrt d um: " + c);

		c = d ^ e; // entweder d oder e wahr, ansonsten false
		System.out.println(c);

	}
}