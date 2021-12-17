import enums.Day;
import enums.SchoolSubject;

import java.util.ArrayList;

public class Schedule {
    private static int counter = 1;
    private int id;
    private Day day;
    private String time;
    private SchoolSubject schoolSubject;
    private ArrayList<Teacher> teacher;
//    private ArrayList<Student> students;

    private Schedule(int id, Day day, String time, SchoolSubject schoolSubject, Teacher teacher) throws Exception {
        this.teacher = new ArrayList<>();
        if (id >= counter) {
            this.id = id;
            this.day = day;
            this.time = time;
            this.schoolSubject = schoolSubject;
            if (teacher != null) this.teacher.add(teacher);

        } else {
            throw new Exception("Schedule-ID: '" + id + "' already in Use!");
        }

        counter++;
    }

    public Schedule(Day day, String time, SchoolSubject schoolSubject) throws Exception {
        this(counter, day, time, schoolSubject, null);
    }

    public Schedule() throws Exception {
        this(counter, Day.NOT_SET, null, SchoolSubject.PLACEHOLDER, null);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public SchoolSubject getSchoolSubject() {
        return schoolSubject;
    }

    public void setSchoolSubject(SchoolSubject schoolSubject) {
        this.schoolSubject = schoolSubject;
    }

    public ArrayList<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        this.teacher.remove(teacher);
    }


    @Override
    public String toString() {
        return "id:" + id +
                ", day:" + day +
                ", time:" + time +
                ", schoolSubject:" + schoolSubject +
                ", teacher/s: " + teacher
                //              + ", students=" + students
                ;
    }
}
