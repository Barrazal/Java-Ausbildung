public class Person {
    static int id;
    String firstName;
    String lastName;
    String birthDate;
    String gender;
    String streetName;
    int streetNumber;
    int plz;
    String district;

    Person(){    }

    Person(String firstName, String lastName, String birthDate, String gender,
           String streetName, int streetNumber, int plz, String district) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.plz = plz;
        this.district = district;
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Person(String lastName, String birthDate, String gender) {
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}
