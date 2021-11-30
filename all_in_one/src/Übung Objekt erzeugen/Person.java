import java.sql.SQLOutput;

public class Person {

    // Klassenvariablen
    public static String lastname;
    public static String firstname;
    public static String addresse;
    public static int age;
    public static String companyAdress;

    //Konstanten
    private static final String CB_FIRMA = "Coders.Bay";
    private static final String CB_ADRESSE = "Peter-Behrens";
    private static final int CB_PLZ = 4020;
    private static final String CB_ORT = "Linz";
    private static final String CB_EMAIL = "info@codersbay.at";

    Person(){
        lastname = "Max";
        firstname = "Mustermann";
        addresse = "Musterstraße 1";
        age = 20;
    }
    Person(String p_lastname, int p_age){
        lastname = p_lastname;
        age = p_age;
    }
    public void printPersonData(){
        System.out.println("Nachname: " + lastname);
        System.out.println("Vorname: " + firstname);
        System.out.println("Adresse: " + addresse);
        System.out.println("Alter: " + age);
        System.out.println("\n");
    }
}
