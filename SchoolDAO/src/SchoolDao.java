import enums.*;

import java.util.ArrayList;

public interface SchoolDao {

    //Create Lists for:
    public ArrayList <Teacher> getAllTeachers();
    public ArrayList <Student> getAllStudents();
    public ArrayList <Schedule> getAllSchedules() throws Exception;

    //ToDo: Not implemented yet!
   // public SchoolClass setClassReference(ClassLevel classLevel, ClassName className);


    //get and Set for Teacher:
    public Teacher getTeacher(int id);
    public Teacher addTeacher(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception;
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
    public void addScheduleTeacher(int scheduleID, int teacherID);
    public ArrayList<Teacher> getScheduleTeacher(int scheduleID);
    public Schedule removeScheduleTeacher(int scheduleID, int teacherID);


    //Assign Student to Schedule/ Output assigned Student
    public Schedule addScheduleStudent(Schedule scheduleID, Student studentID);
    public Schedule getScheduleStudent(Schedule scheduleID);
    public Schedule removeScheduleStudent(Schedule scheduleID, Student studentID);

}
