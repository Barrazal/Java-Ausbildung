
public class main {

	public static void main(String[] args) {

		System.out.println("While Schleife- Beginn");
		System.out.println(); // Leerzeichen

		// deklariere und initialisiere eine Variable test f�r die berechnung in der
		// Schleife
		int test = 1;

		// �ffnet erste schleife und �berpr�ft die Variable test.
		// Wenn diese kleiner gleich 3 ist, dann soll folgendes ausgef�hrt werden:
		while (test <= 3) {

			// Deklariert und initialisiert eine Variable test2 f�r die Berechnung der
			// Schleife INNERHALB der Schleife:
			int test2 = 1;

			// �ffnet eine weitere Schleife INNERHALB der vorhandenen Schleife und
			// �berpr�ft, ob der wert kleiner 11 ist.
			while (test2 < 11) {

				// Gibt die Variable test und test2, sowie die Summe aus dem wert (test*test2)
				// in der Konsole aus!
				// Achtung! system.out.print(); erzeugt KEINEN!!! Zeilenumbruch!
				System.out.print(test + " x " + test2 + " = " + (test * test2) + "  ");

				// Erh�ht die Variable test2 um den Wert +1
				test2 = test2 + 1;
				
				// Ende der Inneren while Schleife
			}

			// Erh�ht die Variable test um den Wert +1
			test++;

			// F�hrt nach erfolgreichem Durchlauf der While Schleife einen Zeilenumbruch aus
			System.out.println(); // Zeilenumbruch
			System.out.println(); // Leerzeichen

			// Ende der �usseren While SChleife
		}

		
		
//-------------------------------------------------------------------------------------------------
		
		System.out.println(); // Leerzeichen
		System.out.println("Do While Schleife- Beginn");
		System.out.println(); // Leerzeichen

		// deklariere und initialisiere eine Variable dotest
		int dotest = 4;

		// in der �u�eren schleife wird der erste wert des 1x1 um eine Ganzzahl erh�ht,
		// nachdem die innere Schleife durchgelaufen ist.
		// zum Schluss wird die Bedingung �berpr�ft, und falls diese wahr ist, ein
		// weiteres Mal der gesamte Codeblock ab zeile 64 durchlaufen.
		do {

			// Deklariert und initialisiert die variable dotest2, der im inneren
			// Schleifenblock ben�tigt wird.
			// Diese variable kann nur in diesem oder einem untergeordneten Codeblock
			// verwendet werden.
			int dotest2 = 1;

			// Die innere schleife beginnt ab hier. Diese erh�ht den zweiten wert des 1x1 um
			// einen Ganzz�hler,
			// nachdem die Werte dotest, dotest2 sowie eine berechnung aus den beiden in der
			// Console ausgegeben wird.
			do {
				System.out.println(dotest + " * " + dotest2 + " = " + (dotest * dotest2));

				// erh�ht die Variable dotest2 (innere schleife- Rechen variable) um einen
				// Ganzz�hler
				dotest2++;

				// Dies ist die Bedingung, welche angibt, wie oft die innere do-while schleife
				// ausgef�hrt wird
				// Zudem ist dies das ende der inneren Do-While Schleife
			} while (dotest2 <= 10);

			// Erh�ht die Variable dotest (�u�ere Schleife- Rechen bariable) um einen
			// Ganzz�hler.
			dotest++;

			// f�gt eine leere zeile hinzu, wenn der Codeblock einmal durchlaufen ist
			System.out.println();

			// Dies ist die Bedingung, welche angibt, wie oft die �usere do-while schleife
			// ausgef�hrt wird
			// Zudem ist dies das ende der �u�eren Do-While Schleife
		} while (dotest <= 6);

//-------------------------------------------------------------------------------------------------
		
		System.out.println(); // Leerzeichen
		System.out.println("For-Schleife beginn");
		System.out.println(); // Leerzeichen

		// Definiert eine Variable -> i f�r die erste Zahl beim 1x1 /2x1 /2x3 /2x4...
		// und erh�ht nach erfolgtem durchlauf der Bedingung um je 1 Ganzzahl bis zu
		// einer maxzahl von 10
		for (int i = 7; i <= 10; i++) {

			// Definiert eine Variable -> f f�r die zweite Zahl beim 1x1 /1x2 /1x3 /1x4...
			// und erh�ht nach erfolgtem durchlauf der Bedingung um je 1 Ganzzahlbis zu
			// einer maxzahl von 10s
			for (int f = 1; f <= 10; f++) {

				// Gibt die werte der Variablen i und f als Text aus und berechnet den
				// Gesamtwert
				System.out.println(i + " x " + f + " = " + (i * f));

				// Dies ist das Ende der inneren for-Schleife
			}
			System.out.println(); // Leerzeichen

			// Dies ist das Ende der �u�eren For-Schleife
		}

	}

}
