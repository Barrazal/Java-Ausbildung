public class personenverwaltung {
    personenverwaltung(){

    }

    public static void createPerson(String firstName, String lastName, String birthDate, String gender, String address){


        splitAddress(address);
    }



    public static void createPerson(String firstName, String lastName){
    Person p1 = new Person(firstName,lastName);
    }



    public static void createPerson(String firstName, String lastName, String birthDate){

    }


    private static void splitAddress(String address){


    }


}
