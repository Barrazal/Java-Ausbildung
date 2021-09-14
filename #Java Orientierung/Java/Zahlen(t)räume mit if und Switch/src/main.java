
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int zahl = 0; // eine definierte und initialisierte Zahl

		if ((zahl >= 1) && (zahl <= 10)) { // Abfrage, ob Zahl größer als 0 ist, aber kleiner gleich 10
			// Ist die zahl kleiner als 6 (1-6) dann gib folgendes aus:
			if (zahl < 6) {
				System.out.println("die Zahl liegt zwischen 1 und 5");
				System.out.println(zahl);
			}
			// Ist die zahl größer als 5 und kleiner als 10 (5-9) dann gib folgendes aus:
			else if ((zahl > 5) && ((zahl < 10))) {
				System.out.println("Die Zahl liegt zwischen 6 und 10");
				System.out.println(zahl);
			}
			// wenn keine Bedingung zutrifft und die Zahl 10 ist, gib folgendes aus:
			else {
				System.out.println("Jackpot--> Wenn die Zahl gleich 10");
				System.out.println(zahl);
			}
		}
		// ist die Zahl kleiner als 0 oder größer als 10, gib folgendes aus:
		else {
			System.out.println("Die Zahl ist zu groß oder klein");
		}
		
		
		switch (zahl) {												//liest den wert zahl aus und vergleiche mit:
		case 0: {													//Wenn der wert 0 ergibt, gib bei der console folgendes aus:
			System.out.println("Die Zahl beträgt 0");break;
		}
		case 1: {													//Wenn der wert 1 ergibt, gib bei der console folgendes aus:
			System.out.println("Die Zahl beträgt 1"); break;
		}
		case 2:{													//Wenn der wert 2 ergibt, gib bei der console folgendes aus:
			System.out.println("Die Zahl beträgt 2"); break;
		}
		case 3:{													//Wenn der wert 3 oder
		}
		case 4:{													//Wenn der wert 4 oder
		}
		case 5:{													//Wenn der wert 5 ergibt, dann gib bei der console folgendes aus:
			System.out.println("Die Zahl beträgt 3, 4 oder 5");break;
		}
		case 6:{													//Wenn der wert 6 ergibt, dann gib bei der console folgendes aus:
			System.out.println("Die Zahl beträgt 5 oder 6");	break;
		}
		case 7:{													//Wenn der wert 7 oder
		}
		case 8:{													//Wenn der wert 8 oder
		}	
		case 9:{													//Wenn der wert 9 ergibt, dann gib bei der console folgendes aus:
			System.out.println("Die Zahl liegt zwischen 7 und 10");	break;
		}	
		case 10:{													//Wenn der wert 10 ergibt, dann gib bei der console folgendes aus:
			System.out.println("Jackpot--> Wenn die Zahl gleich 10");	break;
		}
		default:{													//Wenn der wert nicht zwischen 0 und 10 liegt, dann gib folgendes aus:
			System.out.println("Die Zahl ist zu groß oder klein"); break;
		}
		}
	}

}
