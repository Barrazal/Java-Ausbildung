import enums.*;

import java.util.ArrayList;

public class RamTestBench {
    public static void main(String[] args) throws Exception {

        SchoolRamDao mySchool = new SchoolRamDao();



        mySchool.addTeacher("Alexander", "Gruber",Gender.MALE,ClassLevel.IN_NO_CLASS,ClassName.NOCLASS);
        mySchool.addTeacher("2", "2",Gender.MALE,ClassLevel.IN_NO_CLASS,ClassName.NOCLASS);
        mySchool.addTeacher("3", "3",Gender.MALE,ClassLevel.IN_NO_CLASS,ClassName.NOCLASS);
        mySchool.addTeacher("4", "4",Gender.MALE,ClassLevel.IN_NO_CLASS,ClassName.NOCLASS);

        mySchool.addStudent( "Markus", "Neubacher", Gender.MALE, ClassLevel.THIRD_CLASS, ClassName.C);
        mySchool.addStudent("Andrea", "Bergbauer", Gender.FEMALE, ClassLevel.FIRST_CLASS, ClassName.A);
        mySchool.addStudent("Anders", "Breivik", Gender.NOGENDER, ClassLevel.THIRD_CLASS, ClassName.NOCLASS);
        mySchool.addStudent("S-te", "Fan", Gender.MALE, ClassLevel.FOURTH_CLASS, ClassName.B);
        mySchool.addSchedule(Day.MONDAY,"08:00", SchoolSubject.ENGLISH);
        mySchool.addSchedule(Day.FRIDAY,"12:00",SchoolSubject.GERMAN);

        System.out.println(mySchool);

        mySchool.addScheduleTeacher(1,1);
        mySchool.addScheduleTeacher(1,4);

        System.out.println(mySchool);

        mySchool.deleteSchedule(2);
   //     mySchool.removeScheduleTeacher(1,4);
        mySchool.deleteTeacher(1);

        System.out.println(mySchool);
        mySchool.addTeacher("Alexander", "Gruber",Gender.MALE,ClassLevel.IN_NO_CLASS,ClassName.NOCLASS);

        System.out.println(mySchool);

 //       ArrayList<Student> allStudent = mySchool.getAllStudents();
 //       for (Student student : allStudent
 //       ) {
 //           System.out.println(student);
 //       }
    }

}
