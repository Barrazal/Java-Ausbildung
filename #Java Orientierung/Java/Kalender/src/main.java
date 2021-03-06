import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// Manual input for scanner
		Scanner scan = new Scanner(System.in);

		// Check first day in Month
		System.out.println("Welcher Tag ist der erste im Monat?");
		System.out.println("Format: Mo, Di, Mi, ...");
		String dayName = scan.next();

		// initialize the Variable day
		int day = 0;

		// Check current month
		System.out.println("Gib bitte den Monat als Zahl ein:");
		int month = scan.nextInt();

		// initializes the variable to later output the days of the month
		int monthDay = 31;

		// Check the actual Year
		System.out.println("Welches Jahr haben wir?");
		int year = scan.nextInt();

		// ----------------------------------------------------------------------------
		// Checks the amount of days of the month, based on the month and leap year

		switch (month) {
		// reads out the variables for the months January, March, May, July, August,
		// October, December
		case 1, 3, 5, 7, 8, 10, 12:
			monthDay = 31;
			break;
		// Calculate February - leap years
		case 2:

			// calculates the rest value from the year to set the value to true or false
			// values from
			// https://www.guter-rat.de/magazin/ratgeber/verbrauchertipps/schaltjahre-berechnen-356
			boolean a = (year % 4) == 0;
			boolean b = (year % 100) == 0;
			boolean c = (year % 400) == 0;

			// if a/4 and b can' t be calculated /100 or c/400, then a leap year is
			if (a && b || c) {
				monthDay = 29;
			}
			// else output 28 days for february
			else {
				monthDay = 28;
			}
			break;

		// reads out the variables for months April, June, Septembre, Novembre
		case 4, 6, 9, 11:
			monthDay = 30;
			break;
		}

		// end amount of days
		// -----------------------------------------------------
		// Defines the day of the week using the string dayNames and writes it into int
		// day

		switch (dayName) {
		case "Mo", "mo", "Montag", "1":
			day = 1;
			break;
		case "Di", "di", "Dienstag", "2":
			day = 2;
			break;
		case "Mi", "mi", "Mittwoch", "3":
			day = 3;
			break;
		case "Do", "do", "Donnerstag", "4":
			day = 4;
			break;
		case "Fr", "fr", "Freitag", "5":
			day = 5;
			break;
		case "Sa", "sa", "Samstag", "6":
			day = 6;
			break;
		case "So", "so", "Sonntag", "7":
			day = 7;
			break;
		}
		// end of define int Day
		// -----------------------------------------------------

		// Create Calendar:
		// Calendar Head
		System.out.println("| MO | DI | MI | DO | FR | SA | SO |");
		System.out.println("------------------------------------");

		int a = 0;
		int firstDay = 1;

		// calculates the days which are not needed using the variable "day" and increases the value of the variable "a" by 1 for each pass
		for (int i = 1; i < day; i++) {
			System.out.print("     ");
			a++; // +2
		}
		// prints the first line of the calendar using the firstDay and "a" variables
		for (int i = a; i < 7; i++) {
			System.out.printf("%s%2d%s", "| ", firstDay, " ");
			firstDay++;
		}
		System.out.println("|");

		// end of first Line
		// ----------------------------------------------------------------------------

		// calculate the remaining days with initialized in the Variable "monthDay"

		// how many lines does the calendar need
		int remDays = monthDay - firstDay;

		// Calculates from the variable "remDays" how often the loop should be repeated without a rest
		for (int i = 0; i < (remDays / 7); i++) {
			// per run the variable "firstDay" is printed once by system.out.printf and increased by one value
			for (int j = 0; j < 7; j++) {

				System.out.printf("%s%2d%s", "| ", firstDay, " ");
				firstDay++;

			}
			System.out.println("|");
		}

		// outputs the rest of the days if there is a rest value at "remDays%7".
		if ((remDays % 7) > 0) {

			// calculates with the formula "remDays%7" how many days are left and outputs them in a For loop. The variable "firstDay" is increased by a value of 1 per run.
			for (int i = 0; i <= (remDays % 7); i++) {
				System.out.print("| " + firstDay + " ");
				firstDay++;
			}
			System.out.println("|");
		}

	}
}
