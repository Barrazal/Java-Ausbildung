import java.util.Scanner; //benoetigt um eingaben über die Console zu tätigen

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String ware1= "Wurst"; //Ware zum kauf String ware2= "Käse"; //Ware zum kauf
		 * String ware3= "Brot"; //Ware zum kauf String ware4= "DVD"; //Ware zum kauf
		 */
		double preis1 = 4.20; // Definieren des Preises für die Wurst
		String preis1_1 = String.format("%5.2f", preis1); // Runden des Wertes preis1 auf 2 nachkommastellen
		double preis2 = 2.30; // Definieren des Preises für den Käse
		String preis2_1 = String.format("%5.2f", preis2); // Runden des Wertes preis2 auf 2 nachkommastellen
		double preis3 = 2.11; // Definieren des Preises für das Brot
		String preis3_1 = String.format("%5.2f", preis3); // Runden des Wertes preis2 auf 2 nachkommastellen
		double preis4 = 12.0; // Definieren des Preises für eine DVD
		String preis4_1 = String.format("%5.2f", preis4); // Runden des Wertes preis2 auf 2 nachkommastellen

		Scanner stueck = new Scanner(System.in); // Handeingabe über Console

		System.out.println("Wieviel Wurst hast du gekauft?");
		System.out.println("aktueller Preis: " + preis1_1 + " EUR");// Preisanzeige für Console
		int piece1 = stueck.nextInt(); // Eingabe der Wurstmenge mittels eingabe über Consolenfeld

		System.out.println("Wieviel Käse hast du gekauft?");
		System.out.println("aktueller Preis: " + preis2_1 + " EUR");// Preisanzeige für Console
		int piece2 = stueck.nextInt(); // Eingabe der Käsemenge mittels eingabe über Consolenfeld

		System.out.println("Wieviel Brot hast du gekauft?");
		System.out.println("aktueller Preis: " + preis3_1 + " EUR");// Preisanzeige für Console
		int piece3 = stueck.nextInt(); // Eingabe der Brotmenge mittels eingabe über Consolenfeld

		System.out.println("Wieviele DVD hast du gekauft?");
		System.out.println("aktueller Preis: " + preis4_1 + " EUR");// Preisanzeige für Console
		int piece4 = stueck.nextInt(); // Eingabe der gekauften DVD mittels eingabe über Consolenfeld

		double wurst = preis1 * piece1; // Berechnet den Gesamtpreis der Wurst
		String wurstpreis = String.format("%5.2f", wurst); // Das runden des Wurst-preises auf 5 Ganzzahlen und 2
															// nachkommastellen mit

		System.out.printf("%-5s %5s %2s %5s %1s%n", "Wurst", piece1, "x", preis1_1, "EUR"); // Gibt anhand eines
																							// Formates an, wieviel
																							// Wurst um welchen preis
																							// gekauft wurde
		System.out.printf("%30s %1s%n", wurstpreis, "EUR"); // Gibt den Gesamten Wurstpreis an.

		double kaese = preis2 * piece2; // Berechnet den Gesamtpreis des Käses
		String kaesepreis = String.format("%5.2f", kaese); // Das runden des Käse-preises auf 5 Ganzzahlen und 2
															// nachkommastellen mit

		System.out.printf("%-5s %5s %2s %5s %1s%n", "Käse", piece2, "x", preis2_1, "EUR"); // Gibt anhand eines Formates
																							// an, wieviel Käse um
																							// welchen preis gekauft
																							// wurde
		System.out.printf("%30s %1s%n", kaesepreis, "EUR"); // Gibt den Gesamten Käsepreis an.

		double brot = preis3 * piece3; // Berechnet den Gesamtpreis des Brotes
		String brotpreis = String.format("%5.2f", brot); // Das runden des Brot-preises auf 5 Ganzzahlen und 2
															// nachkommastellen mit

		System.out.printf("%-5s %5s %2s %5s %1s%n", "Brot", piece3, "x", preis3_1, "EUR"); // Gibt anhand eines Formates
																							// an, wieviel Brot um
																							// welchen preis gekauft
																							// wurde
		System.out.printf("%30s %1s%n", brotpreis, "EUR"); // Gibt den Gesamten Brotpreis an.

		double dvd = preis4 * piece4; // Berechnet den Gesamtpreis der DVD
		String dvdpreis = String.format("%5.2f", dvd); // Das runden der DVD-preises auf 5 Ganzzahlen und 2
														// nachkommastellen mit

		System.out.printf("%-5s %5s %2s %5s %1s%n", "DVD", piece4, "x", preis4_1, "EUR"); // Gibt anhand eines Formates
																							// an, wieviele DVD um
																							// welchen preis gekauft
																							// wurde
		System.out.printf("%30s %1s%n", dvdpreis, "EUR"); // Gibt den Gesamten DVDpreis an.

		System.out.println("----------------------------------"); // Trennlinie am Kassabon

		double gesamt = wurst + kaese + brot + dvd; // Berechnen des Gesamtpreises
		String gesamtpreis = String.format("%5.2f", gesamt); // Runden des Gesamtpreises auf 2 nachkommastellen

		System.out.printf("%-5s %23s %1s %n", "Gesamt", gesamtpreis, "EUR");// Ausgeben des Gesamtpreises

		System.out.println("Geldbetrag zum Bezahlen eingeben:");
		double bag = stueck.nextDouble(); // Eingabe der Geldbetrages aus der Brieftasche mittels Consolenfeld

		String gegeben = String.format("%5.2f", bag); // Runden des Brieftascheninhaltes auf 2 nachkommastellen
		System.out.printf("%-5s %22s %1s %n", "Gegeben", gegeben, "EUR"); // Ausgeben des Brieftascheninhaltes

		if ((bag >= gesamt)) { // Prüfen ob Brieftaschengeld gleich oder höher des Gesamtbetrages ist
			double zurueck = bag - gesamt; // Berechnung für Retourgeld
			String geldzurueck = String.format("%5.2f", zurueck); // Das runden des Retourgeldes auf 5 Ganzzahlen und 2
																	// nachkommastellen mit
			System.out.printf("%-5s %22s %1s %n", "Retourgeld", geldzurueck, "EUR");// Ausgeben des Retourgeldes
		} else {
			System.out.printf("%15s%n", "Nicht genug Geld vorhanden!"); // Ausgeben einer Meldung wegen nicht genug
																		// geldes!
		}
	}
}
