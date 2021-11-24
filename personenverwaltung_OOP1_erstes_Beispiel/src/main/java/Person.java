import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private String streetName;
    private Integer streetNumber;
    private Integer plz;
    private String district;

    public Person() {
        this("NoFirstName", "NoLastName");
    }

    public Person( String firstName, String lastName, String birthDate, String gender,
           String streetName, Integer streetNumber, Integer plz, String district) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.plz = plz;
        this.district = district;
    }

    public Person( String firstName, String lastName, String birthDate, String gender,
                   String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;

        String[] splitAddress = address.split("\\s+");

        this.streetName = splitAddress[0];
        this.streetNumber = Integer.parseInt(splitAddress[1]);
        this.plz = Integer.parseInt(splitAddress[2]);
        this.district = splitAddress[3];
    }


    public Person( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String lastName, String birthDate, String gender) {
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }


//Todo: Make setters more secure/ sane e.g. prohibiting negative values

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "\n\nPerson:" +
                "\nName:  " + firstName + " " + lastName +
                "\nbirthDate:  " + birthDate  +
                "\ngender:  " + gender +
                "\nstreetName: " + streetName +
                "\nstreetNumber:  " + streetNumber +
                "\nplz:  " + plz +
                "\ndistrict: " + district+
                "\n\n";
    }
}
