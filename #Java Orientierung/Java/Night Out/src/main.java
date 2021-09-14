public class main {

	public static void main(String[] args) {

//		Aufgabe 1: - Entweder Aufgabe 1 oder 5 nutzen!
//		int ml; // beinhaltet die Fl�ssigkeitsmenge in des aktuellen glases
//		ml = 48; // Initialisiert einen Wert f�r die Fl�ssigkeitsmenge

		// Aufgabe 2: - Entweder Aufgabe 2 oder 6 nutzen!
//		int pin; // beinhaltet sp�ter die generierte Zahl an Pins, die getroffen wurden.
//		pin = 7; // Gibt einen Wert f�r das Bowlen an
		// Ende Aufgabe 2

		// Aufgabe 3:
		int glass; // beinhaltet die Anzahl aller Getrunkenen Gl�ser
		glass = 3; // Wieviel gl�ser getrunken wurden
		// Ende Aufgabe 3

		// Aufgabe 4:
		int max_kekse; // Definiert die maximale anzahl an vorhandenen Kekse
		max_kekse = 10; // Wieviele Kekse sind gesamt vorhanden
		// Ende Aufgabe 4

		// Aufgabe 5: - Entweder Aufgabe 1 oder 5 nutzen!
		// einen Array f�r den F�llstand ml vergeben:
		int[] ml; // Erstellt einen Array f�r ganzzahlvariablem des Typ�s integer mit namen "ml"
		ml = new int[4]; // Deklariert f�r den Array "ml" Eintr�ge des Typs integer mit der l�nge von 3

		// definiert f�r jeden index-punkt des Array�s "ml", einen int wert, angefangen
		// beim Index-punkt 0.
		ml[0] = 250;
		ml[1] = 15;
		ml[2] = 170;
		ml[3] = 265;
		// Ende der Initialisierung und Deklarierung des Array�s "ml"
		// Ende Aufgabe 5 - Teil 1

		// Aufgabe 6: - Entweder Aufgabe 2 oder 6 nutzen!
		int[] bowl = { 7, 1, 5, 2, 8, 3, 4, 10, 6, 9 }; // Erstellt und deklariert einen Array f�r bowl mit der
														// l�nge von 10
		// Ende Aufgabe 6 -Teil1

		// Anfang F�llstand:
		for (int i : ml) { // foreach-Schleife f�r Aufgabe 5: f�hrt f�r jeden Indexpunkt im Array ml einen
							// durchlauf der folgenden Abfrage durch
			// Fragt ab, wie voll das Glas ist und gibt entsprechen eine R�ckmeldung!

			if (i == 250) {

				System.out.println("Das Glas ist voll!");
			} else if (i >= 20) {
				System.out.println("Das Glas ist nicht mehr voll!");
			} else {
				System.out.println("Kellner, ein neues Glas!");
			}
		} // ende Foreach schleife von Aufgabe 5
			// Ende F�llstand
//--------------------------------------------------------------------------------------------------------------
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile

		// Start Bowlen wenn weniger als 4 gl�ser getrunken wurden
		if (glass < 4) {

			// F�r Aufgabe 2:
			// Liest die getroffene Anzahl an Pin�s aus
			// switch (pin) {

			// F�r Aufgabe 6:
			// Erstellung einer Foreach abfrage f�r die Variable bowl
			for (int i : bowl) {
				switch (i) {

				// gibt aus, was gemacht wereden soll, wenn x Pins getroffen wurden, oder beim
				// Bowlen ein entsprechender Wert ausgegeben wurde.

				case 10:
					System.out.println("X - Strike!!!");
					break;
				case 7, 8, 9:
					System.out.println("Guter Treffer");
					break;
				case 4, 5, 6:
					System.out.println("Normaler Treffer");
					break;
				case 3, 2, 1:
					System.out.println("schwacher Treffer");
					break;
				case 0:
					System.out.println("- Miss");
					break;

				}
			} // Ende der Foreach schleife von Aufgabe 6

			// Falls mehr Gl�ser getrunken wurden:
		} else {
			System.out.println("Du hast zuviel getrunken!");
		}

		// Ende getrunkener Gl�ser
//--------------------------------------------------------------------------------------------------------------
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile

		// Hier werden Klimmz�ge anhand einer for schleife berechnet und mittels
		// if bzw elseif bedingung ausgegeben
		for (int i = 1; i <= 20; i++) {
			System.out.println(" - " + i + " - ");
			if (i == 10) {
				System.out.println("Phu ich hoffe das ist bald vorbei");
			} else if (i == 15) {
				System.out.println("Ich glaub ich schaff das nicht");
			} else if (i == 19) {
				System.out.println("A ICH SCHAFFE ES!!!!!");
			} else if (i == 20) {
				System.out.println("OLEOLEOLEEEEE");
			}
		}

		// Ende der Klimmz�ge
//--------------------------------------------------------------------------------------------------------------
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile

		// Bettgehen

		// Abends vor dem Bettgehen: fixer String, damit eine Zeilenangabe erspart wird.
		String bett = "Du gehst dich Duschen, deine Z�hne putzen und ziehst dir deinen Schlafanzug an.";

		// Anhand der Getrunkenen Gl�ser wird eine der folgenden F�lle Ausgef�hrt:
		switch (glass) {

		// wenn 0 oder 1 glas getrunken wurde, soll er den String bett ausgeben.
		case 0, 1:
			System.out.println(bett);
			break;

		// Wenn 2 Gl�ser getrunken wurden, soll er den String bett ausgeben und Kekse
		// Essen.
		case 2:
			System.out.println(bett);
			System.out.println("Du gehst zum K�hlschrank und isst alle Kekse die du findest");

			// lokaler wert zum Schleifenberechnen:
			//int kekse = 1;

			// Hier beginnt die Keks-Ess-schleifenbedingung!
			for (int i = 1; i <= max_kekse;i++) {
				System.out.println("Keks Nr." + i + " gegessen.");
			}

			// max_kekse bezieht sich auf eine Variable die in Zeile 13 definiert wurde

			
			System.out.println("Du hast alle Kekse gegessen");
			
			break;

		// default= wenn 3 oder mehr gl�ser getrunken wurde:
		default:
			System.out.println("Du hast " + glass + " Gl�ser Alkohol getrunken und willst ins Bett.");
			System.out.println("Du versuchst die Stufen zu erklimmen und ...");

			// Lokaler wert, um die Stufenberechnung durchzuf�hren!
			int stairs = 15;

			// Lokaler wert, um die Stufenberechnung durchzuf�hren und den letzten print.ln
			// anzugeben!!
			int zaehler = stairs - glass;

			// Schleife f�r die Stufenberechnung
			for (int i = 1; i < zaehler; i++) {
				System.out.println("... schaffst die " + i + ". Stufe!");
			}
			System.out.println("Bei der " + zaehler + ".Stufe schl�fst du ein!");
		}

		// Ende vom Bettgehen!

	}

}
