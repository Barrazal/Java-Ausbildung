import enums.ClassLevel;
import enums.ClassName;
import enums.Gender;

public abstract class Person {
    private static int counter = 1;
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private ClassLevel classLevel;
    private ClassName className;

    private Person(int id, String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className, boolean create) throws Exception {

        if (id >= counter) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.classLevel = classLevel;
            this.className = className;
            if (create) counter++;
        } else {
            throw new Exception("Person-ID: '" + id + "' already in Use!");
        }
    }

    public Person(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
        this(counter,firstName,lastName,gender,classLevel,className,true);

    }

    public Person() throws Exception {
        this(counter, null, null, Gender.NOGENDER, ClassLevel.IN_NO_CLASS, ClassName.NOCLASS, true);
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
