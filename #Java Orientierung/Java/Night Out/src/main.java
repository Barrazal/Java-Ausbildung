public class main {

	public static void main(String[] args) {

//		Aufgabe 1: - Entweder Aufgabe 1 oder 5 nutzen!
//		int ml; // beinhaltet die Flüssigkeitsmenge in des aktuellen glases
//		ml = 48; // Initialisiert einen Wert für die Flüssigkeitsmenge

		// Aufgabe 2: - Entweder Aufgabe 2 oder 6 nutzen!
//		int pin; // beinhaltet später die generierte Zahl an Pins, die getroffen wurden.
//		pin = 7; // Gibt einen Wert für das Bowlen an
		// Ende Aufgabe 2

		// Aufgabe 3:
		int glass; // beinhaltet die Anzahl aller Getrunkenen Gläser
		glass = 3; // Wieviel gläser getrunken wurden
		// Ende Aufgabe 3

		// Aufgabe 4:
		int max_kekse; // Definiert die maximale anzahl an vorhandenen Kekse
		max_kekse = 10; // Wieviele Kekse sind gesamt vorhanden
		// Ende Aufgabe 4

		// Aufgabe 5: - Entweder Aufgabe 1 oder 5 nutzen!
		// einen Array für den Füllstand ml vergeben:
		int[] ml; // Erstellt einen Array für ganzzahlvariablem des Typ´s integer mit namen "ml"
		ml = new int[4]; // Deklariert für den Array "ml" Einträge des Typs integer mit der länge von 3

		// definiert für jeden index-punkt des Array´s "ml", einen int wert, angefangen
		// beim Index-punkt 0.
		ml[0] = 250;
		ml[1] = 15;
		ml[2] = 170;
		ml[3] = 265;
		// Ende der Initialisierung und Deklarierung des Array´s "ml"
		// Ende Aufgabe 5 - Teil 1

		// Aufgabe 6: - Entweder Aufgabe 2 oder 6 nutzen!
		int[] bowl = { 7, 1, 5, 2, 8, 3, 4, 10, 6, 9 }; // Erstellt und deklariert einen Array für bowl mit der
														// länge von 10
		// Ende Aufgabe 6 -Teil1

		// Anfang Füllstand:
		for (int i : ml) { // foreach-Schleife für Aufgabe 5: führt für jeden Indexpunkt im Array ml einen
							// durchlauf der folgenden Abfrage durch
			// Fragt ab, wie voll das Glas ist und gibt entsprechen eine Rückmeldung!

			if (i == 250) {

				System.out.println("Das Glas ist voll!");
			} else if (i >= 20) {
				System.out.println("Das Glas ist nicht mehr voll!");
			} else {
				System.out.println("Kellner, ein neues Glas!");
			}
		} // ende Foreach schleife von Aufgabe 5
			// Ende Füllstand
//--------------------------------------------------------------------------------------------------------------
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile

		// Start Bowlen wenn weniger als 4 gläser getrunken wurden
		if (glass < 4) {

			// Für Aufgabe 2:
			// Liest die getroffene Anzahl an Pin´s aus
			// switch (pin) {

			// Für Aufgabe 6:
			// Erstellung einer Foreach abfrage für die Variable bowl
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

			// Falls mehr Gläser getrunken wurden:
		} else {
			System.out.println("Du hast zuviel getrunken!");
		}

		// Ende getrunkener Gläser
//--------------------------------------------------------------------------------------------------------------
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile

		// Hier werden Klimmzüge anhand einer for schleife berechnet und mittels
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

		// Ende der Klimmzüge
//--------------------------------------------------------------------------------------------------------------
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile
		System.out.println(); // leerzeile

		// Bettgehen

		// Abends vor dem Bettgehen: fixer String, damit eine Zeilenangabe erspart wird.
		String bett = "Du gehst dich Duschen, deine Zähne putzen und ziehst dir deinen Schlafanzug an.";

		// Anhand der Getrunkenen Gläser wird eine der folgenden Fälle Ausgeführt:
		switch (glass) {

		// wenn 0 oder 1 glas getrunken wurde, soll er den String bett ausgeben.
		case 0, 1:
			System.out.println(bett);
			break;

		// Wenn 2 Gläser getrunken wurden, soll er den String bett ausgeben und Kekse
		// Essen.
		case 2:
			System.out.println(bett);
			System.out.println("Du gehst zum Kühlschrank und isst alle Kekse die du findest");

			// lokaler wert zum Schleifenberechnen:
			//int kekse = 1;

			// Hier beginnt die Keks-Ess-schleifenbedingung!
			for (int i = 1; i <= max_kekse;i++) {
				System.out.println("Keks Nr." + i + " gegessen.");
			}

			// max_kekse bezieht sich auf eine Variable die in Zeile 13 definiert wurde

			
			System.out.println("Du hast alle Kekse gegessen");
			
			break;

		// default= wenn 3 oder mehr gläser getrunken wurde:
		default:
			System.out.println("Du hast " + glass + " Gläser Alkohol getrunken und willst ins Bett.");
			System.out.println("Du versuchst die Stufen zu erklimmen und ...");

			// Lokaler wert, um die Stufenberechnung durchzuführen!
			int stairs = 15;

			// Lokaler wert, um die Stufenberechnung durchzuführen und den letzten print.ln
			// anzugeben!!
			int zaehler = stairs - glass;

			// Schleife für die Stufenberechnung
			for (int i = 1; i < zaehler; i++) {
				System.out.println("... schaffst die " + i + ". Stufe!");
			}
			System.out.println("Bei der " + zaehler + ".Stufe schläfst du ein!");
		}

		// Ende vom Bettgehen!

	}

}
