
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cars;						//Variable f�r Fahrzeuge
		int drivers;					//Variable f�r Fahrzeuge
		int passenger;					//Variable f�r Mitfahrer
		
		cars= 4;						//anzahl an Fahrzeugen
		drivers= 5;						//anzahl an Fahrer
		passenger=10;					//Anzahl an Mitfahrer
		
		
		
		
		System.out.println("Die Anzahl aller Personen betr�gt: " + (drivers+passenger));		//Berechnung der Anzahl ALLER Personen

		System.out.println("Die Anzahl der Sitzpl�tze (inkl. Fahrer) betr�gt: "+ (cars*5));		//Berechnung der Sitzpl�tze
		
		System.out.println("Freie Fahrer f�r neue Fahrzeuge: "+ (cars-drivers));				//Berechnung der Freien Fahrer
		
		System.out.println("Personen pro Fahrzeug: " + ((drivers+passenger)/(cars)));			//Berechnung der Personen pro Auto
		
		
		
		
		
	}

}
