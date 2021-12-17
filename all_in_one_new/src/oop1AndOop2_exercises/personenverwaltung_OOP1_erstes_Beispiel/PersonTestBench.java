package oop1AndOop2_exercises.personenverwaltung_OOP1_erstes_Beispiel;

public class PersonTestBench {
    public static void main(String[] args) {


        String first_name = "Markus";
        String last_name = "Neubacher";
        String birthdate = "12.34.5678";
        String gender = "male";
        String address = "Peter-Behrens-Platz 5 4020 Linz";


        PersonManagement firstPerson = new PersonManagement();
        firstPerson.createPerson(new Person(first_name,last_name));
        System.out.println(firstPerson);

        Person secondPerson = new Person(first_name,last_name,birthdate,gender,address);

        //Die Daten von secondPerson für die println ausgabe kommen von toString!
        System.out.println(secondPerson);
    }
}