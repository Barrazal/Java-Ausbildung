import java.util.HashMap;

public class PersonManagement {

    private HashMap<String, Person> personList; //All Persons in a Map
    private static Integer personCount = 0;

    public PersonManagement() {
        personList = new HashMap<>();
    }

    public void createPerson(Person newPerson) {
        personList.put(newPerson.getLastName(), newPerson);
        personCount++;
    }

    private void splitAddress(String address) {
    }
}
