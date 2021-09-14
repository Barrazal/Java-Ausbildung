
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String vorname;		//Vorname
		String nachname;	//Nachname
		int alter;			//Alter
		char gender;		//Geschlecht
		boolean married;		//verheiratet
		double cash;		//Verdienst 
		String born;		//geboren
		vorname = "Markus";
		nachname = "Neubacher";
		alter = 33;
		gender = 'M';
		married = false;
		cash = 15.54;
		born = "Steyr";
		
		System.out.println("Dein Name ist " + vorname + " " + nachname + ".");
		System.out.println("Dein Geschlecht ist " + gender + " und du bist " + alter + " Jahre alt.");
		System.out.println("Du bist in " + born + " geboren.");
		System.out.println("und dein Heiratsstatus ist " + married);
		System.out.println("Dein aktuelles Gehalt ist: " + cash + "€/h.");
		
	}

}
