import java.util.Scanner; //benoetigt um eingaben �ber die Console zu t�tigen

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Handeingabe �ber Console
		Scanner scan = new Scanner(System.in);

		// Fragt nach dem Alter der Person �ber die Console
		System.out.println("Gib bitte dein Alter ein!");
		int age = scan.nextInt();

		// Fragt nach einer VIP karte und wandelt es in einen Boolean um!
		System.out.println("Hast du eine Vip karte?");
		String card = scan.next();
		boolean vip = (card.equals("Ja") || card.equals("J") || card.equals("ja") || card.equals("j"));

		// Armbandabfrage wo das Alter, die VIP Karte und die Begleitperson abgefagt
		// wird

		// Wenn das Alter �ber 4 jahre betr�gt dann...

		//
		if (age >= 4) {
			// Wenn das Alter 18 oder dar�ber liegt
			if (age >= 18) {
				System.out.println("Du bekommst ein gr�nes Armband und darfst alles Trinken!");

			} else if (age >= 16) { // Wenn das Alter zwischen 16 und 18
				System.out.println(
						"Du bekommst ein gelbes Armband und darfst nur leicht Alkoholische Getr�nke konsumieren!");
				// Wenn das Alter zwischen 4 und 16 betr�gt, dann Fragt nach einer
				// Aufsichtsperson
			} else {
				System.out.println("Hast du eine Aufsichtsperson mit?" + " Antworte mit ja oder nein");
				String supervisor = scan.next(); // Speichert in die Variable, ob eine Aufsichtsperson vorhanden ist

				/*
				 * Fragt ab, ob der wert Supervisor gleich den werten Ja,J,ja oder j ist. falls
				 * korrekt: der wert variable.equals() vergleicht den variablenwert mit dem Wert
				 * in () und gibt true oder false aus! *
				 */
				if (supervisor.equals("Ja") || supervisor.equals("J") || supervisor.equals("ja")
						|| supervisor.equals("j")) {
					System.out.println(
							"Da du in Begleitung bist, darfst du eintreten und du bekommst ein rotes Armband!");
				}
				// Falls der Wert supervisior false ist dann...
				else {
					System.out.println("Da du alleine bist, gibt es keinen Einlass");
				}
			}
			// Wenn das Alter unter 4 betr�gt
		} else
			System.out.println("Du darfst leider nicht eintreten!");
		
		// Wenn du ein VIP Ticket hast dann...
		if (vip) {
			System.out.println("VIP-Ticket: Du bekommst ein goldenes Armband und darfst in den Backstage Bereich!");
		}
	}

}
