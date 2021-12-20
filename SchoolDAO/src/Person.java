import enums.ClassLevel;
import enums.ClassName;
import enums.Gender;

public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private ClassLevel classLevel;
    private ClassName className;

    public Person(int id, String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.classLevel = classLevel;
            this.className = className;

    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

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

    public ClassLevel getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(ClassLevel classLevel) {
        this.classLevel = classLevel;
    }

    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "";
    }
}
