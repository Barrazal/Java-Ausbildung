import enums.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SchoolRamDao implements SchoolDao {

    HashMap<Integer, Teacher> teacherStorage;
    HashMap<Integer, Student> studentStorage;
    HashMap<Integer, Schedule> scheduleStorage;

    public SchoolRamDao() {
        this.teacherStorage = new HashMap<>();
        this.studentStorage = new HashMap<>();
        this.scheduleStorage = new HashMap<>();
    }

    @Override
    public ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> result = new ArrayList<>();
        //add the Value for each entry of teacherStorage in result and output it!
        for (Map.Entry<Integer, Teacher> entry : teacherStorage.entrySet()
        ) {
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> result = new ArrayList<>();
        //add the Value for each entry of studentStorage in result and output it!
        for (Map.Entry<Integer, Student> entry : studentStorage.entrySet()
        ) {
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    //add the Value for each entry of scheduleStorage in result and output it!
    public ArrayList<Schedule> getAllSchedules() {

        ArrayList<Schedule> result = new ArrayList<>();
        for (Map.Entry<Integer, Schedule> entry : scheduleStorage.entrySet()
        ) {
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    //return the Teacher with id from teacherStorage
    public Teacher getTeacher(int id) {
        return teacherStorage.get(id);
    }

    @Override
    //add an new Teacher to the Storage
    public Teacher addTeacher(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className, boolean isTeacher) throws Exception {
        Teacher newTeacher = new Teacher( firstName, lastName, gender, classLevel, className, isTeacher);
        return teacherStorage.put(newTeacher.getId(), newTeacher);
    }

    @Override
    public Teacher deleteTeacher(int id) {
        return teacherStorage.remove(id);
    }

    @Override
    public Student getStudent(int id) {
        return studentStorage.get(id);
    }

    @Override
    public Student addStudent(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
        Student newStudent = new Student(firstName, lastName, gender, classLevel, className);
        return studentStorage.put(newStudent.getId(), newStudent);
    }

    @Override
    public Student deleteStudent(int id) {
        return studentStorage.remove(id);
    }

    @Override
    public Schedule getSchedule(int id) {
        return scheduleStorage.get(id);
    }

    public Schedule addSchedule(Day day, String time, SchoolSubject schoolSubject) throws Exception {
        Schedule newSchedule = new Schedule(day,time,schoolSubject);
        return scheduleStorage.put(newSchedule.getId(), newSchedule);
    }

    @Override
    public Schedule deleteSchedule(int id) {
        return scheduleStorage.remove(id);
    }

    @Override
    public Schedule addScheduleTeacher(int scheduleId, int teacherid2) {
        Teacher localeTeacher = this.getTeacher(teacherid2);
        Schedule localSchedule = this.getSchedule(scheduleId);

        localeTeacher.setTeachesSchedule(localSchedule);
        localSchedule.setTeacher(localeTeacher);

        return null;
    }

    @Override
    public Schedule getScheduleTeacher(Schedule id) {
        return null;
    }

    @Override
    public Schedule removeScheduleTeacher(Schedule scheduleId, Teacher teacherid2) {
        return null;
    }

    @Override
    public Schedule addScheduleStudent(Schedule scheduleId, Student studentid) {
        return null;
    }

    @Override
    public Schedule getScheduleStudent(Schedule scheduleId) {
        return null;
    }

    @Override
    public Schedule removeScheduleStudent(Schedule scheduleId, Student studentid) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\nThis Persons are Teachers:\n");
        for (Teacher arr1: this.getAllTeachers()) {
            stringBuilder.append(arr1+"\n");
        }

        stringBuilder.append("This Persons are Students:\n");
        for (Student arr1: this.getAllStudents()) {
            stringBuilder.append(arr1+"\n");
        }

        stringBuilder.append("These are the Schedules of the classes:\n");
        for (Schedule arr1: this.getAllSchedules()) {
            stringBuilder.append(arr1+"\n");
        }



        return " "+ stringBuilder + " ";
    }
}
