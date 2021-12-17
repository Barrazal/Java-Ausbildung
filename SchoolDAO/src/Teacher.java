import enums.ClassLevel;
import enums.ClassName;
import enums.Gender;

import java.util.ArrayList;

public class Teacher extends Person{
    ArrayList<Schedule> teachesSchedule;

    public Teacher() throws Exception {
        super();
    }

    public Teacher( String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
        super( firstName, lastName, gender, classLevel, className);
        teachesSchedule =new ArrayList<>();
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


        return super.toString()+  "ID:" + super.getId() + " "+ super.getFirstName() + " " + super.getLastName();
    }
}
