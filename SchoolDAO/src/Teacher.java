import enums.ClassLevel;
import enums.ClassName;
import enums.Gender;

import java.util.ArrayList;

public class Teacher extends Person {
    private static int counter = 1;
    ArrayList<Schedule> teachesSchedule;

    public Teacher(){
    }

    public Teacher(int id, String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
        super(id, firstName, lastName, gender, classLevel, className);
    }

    public Teacher(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className, boolean create) throws Exception {
        this(counter, firstName, lastName, gender, classLevel, className);
        if (create) counter++;
    }

    public Teacher(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
        this(firstName, lastName, gender, classLevel, className, true);
    }




    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public Gender getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(Gender gender) {
        super.setGender(gender);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public ClassLevel getClassLevel() {
        return super.getClassLevel();
    }

    @Override
    public void setClassLevel(ClassLevel classLevel) {
        super.setClassLevel(classLevel);
    }

    @Override
    public ClassName getClassName() {
        return super.getClassName();
    }

    @Override
    public void setClassName(ClassName className) {
        super.setClassName(className);
    }

    public ArrayList<Schedule> getTeachesSchedule() {
        return teachesSchedule;
    }

    //  public void setTeachesSchedule(Schedule teachesSchedule) {
    //      this.teachesSchedule.add(teachesSchedule);
    //  }

    @Override
    public String toString() {
        String genderLocale = null;
        if (super.getGender() == Gender.MALE) {
            genderLocale = "he";
        } else if (super.getGender() == Gender.FEMALE) {
            genderLocale = "she";
        } else {
            genderLocale = "it";
        }
        int inClass= 0;
        if (super.getClassLevel() == ClassLevel.FIRST_CLASS) {
            inClass = 1;
        } else if (super.getClassLevel() == ClassLevel.SECOND_CLASS) {
            inClass = 2;
        } else if (super.getClassLevel() == ClassLevel.THIRD_CLASS) {
            inClass = 3;
        } else if (super.getClassLevel() == ClassLevel.FOURTH_CLASS) {
            inClass = 4;
        }

        return super.toString()+ "ID:" + super.getId() + " " + super.getFirstName() + " " + super.getLastName() + " gender: "+ super.getGender() + " assigned to: " + inClass  + super.getClassName();
    }
}
