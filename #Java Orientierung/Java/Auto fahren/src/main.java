
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cars;						//Variable für Fahrzeuge
		int drivers;					//Variable für Fahrzeuge
		int passenger;					//Variable für Mitfahrer
		
		cars= 4;						//anzahl an Fahrzeugen
		drivers= 5;						//anzahl an Fahrer
		passenger=10;					//Anzahl an Mitfahrer
		
		
		
		
		System.out.println("Die Anzahl aller Personen beträgt: " + (drivers+passenger));		//Berechnung der Anzahl ALLER Personen

		System.out.println("Die Anzahl der Sitzplätze (inkl. Fahrer) beträgt: "+ (cars*5));		//Berechnung der Sitzplätze
		
		System.out.println("Freie Fahrer für neue Fahrzeuge: "+ (cars-drivers));				//Berechnung der Freien Fahrer
		
		System.out.println("Personen pro Fahrzeug: " + ((drivers+passenger)/(cars)));			//Berechnung der Personen pro Auto
		
		
		
		
		
	}

}
