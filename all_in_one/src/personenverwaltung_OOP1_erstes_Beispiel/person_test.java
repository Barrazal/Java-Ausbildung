import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class person_test {
    @Test
    @DisplayName("Check if a Person with all Avilable values was correctly created")
    void createAccount_AllValues() {
        String first_name = "Markus";
        String last_name = "Neubacher";
        String birthdate = "12.34.5678";
        String gender = "male";
        String address = "Peter-Behrens-Platz 5 4020 Linz";
        Person testPerson = new Person(first_name, last_name, birthdate, gender, address);

        assertAll("Person is Correctly created: ",
                () -> assertEquals("Markus", testPerson.getFirstName()),
                () -> assertEquals("Neubacher", testPerson.getLastName()),
                () -> assertEquals("12.34.5678", testPerson.getBirthDate()),
                () -> assertEquals("male", testPerson.getGender()),
                () -> assertEquals("Peter-Behrens-Platz", testPerson.getStreetName()),
                () -> assertEquals(5, testPerson.getStreetNumber()),
                () -> assertEquals(4020, testPerson.getPlz()),
                () -> assertEquals("Linz", testPerson.getDistrict())
        );
    }

    @Test
    @DisplayName("Check if a Person with first and LastName was correctly created")
    void createAccount_Firstname_Lastname() {
        String first_name = "Markus";
        String last_name = "Neubacher";

        Person testPerson = new Person(first_name, last_name);
        assertEquals("Markus", testPerson.getFirstName());
        assertEquals("Neubacher", testPerson.getLastName());
    }

    @Test
    @DisplayName("Check if a Person with LastName, birthDate and gender was correctly created")
    void createAccount_Firstname_Lastname_Birth() {
        String last_name = "Neubacher";
        String birthdate = "12.34.5678";
        String gender = "male";

        Person testPerson = new Person(last_name, birthdate, gender);
        assertEquals("Neubacher", testPerson.getLastName());
        assertEquals("12.34.5678", testPerson.getBirthDate());
        assertEquals("male", testPerson.getGender());
    }

}


