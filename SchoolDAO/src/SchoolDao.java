import enums.*;

import java.util.ArrayList;

public interface SchoolDao {

    //Create Lists for:
    public ArrayList <Teacher> getAllTeachers();
    public ArrayList <Student> getAllStudents();
    public ArrayList <Schedule> getAllSchedules();

    //ToDo: Not implemented yet!
   // public SchoolClass setClassReference(ClassLevel classLevel, ClassName className);


    //get and Set for Teacher:
    public Teacher getTeacher(int id);
    public Teacher addTeacher(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className, boolean isTeacher) throws Exception;
    public Teacher deleteTeacher(int id);

    //get and Set for Student:
    public Student getStudent(int id);
    public Student addStudent(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception;
    public Student deleteStudent(int id);

    //Get and Set for Schedule
    public Schedule getSchedule(int id);
    public Schedule addSchedule(Day day, String time, SchoolSubject schoolSubject) throws Exception;
    public Schedule deleteSchedule(int id);

    //Assign Teacher to Schedule/ Output assigned Teacher
    public Schedule addScheduleTeacher(int scheduleId, int teacherid2);
    public Schedule getScheduleTeacher(Schedule id);
    public Schedule removeScheduleTeacher(Schedule scheduleId, Teacher teacherid2);


    //Assign Student to Schedule/ Output assigned Student
    public Schedule addScheduleStudent(Schedule scheduleId, Student studentid);
    public Schedule getScheduleStudent(Schedule scheduleId);
    public Schedule removeScheduleStudent(Schedule scheduleId, Student studentid);

}
