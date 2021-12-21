import enums.*;

import java.util.ArrayList;

public class RamTestBench {
    public static void main(String[] args) throws Exception {

        SchoolRamDao schoolRamDao = new SchoolRamDao();

        schoolRamDao.addTeacher("Alexander", "Gruber",Gender.MALE,ClassLevel.IN_NO_CLASS,ClassName.NOCLASS);
        schoolRamDao.addTeacher("2", "2",Gender.MALE,ClassLevel.IN_NO_CLASS,ClassName.NOCLASS);
        schoolRamDao.addTeacher("3", "3",Gender.MALE,ClassLevel.IN_NO_CLASS,ClassName.NOCLASS);
        schoolRamDao.addTeacher("4", "4",Gender.MALE,ClassLevel.IN_NO_CLASS,ClassName.NOCLASS);

        schoolRamDao.addSchedule(Day.MONDAY,"08:00", SchoolSubject.ENGLISH);
        schoolRamDao.addSchedule(Day.FRIDAY,"12:00",SchoolSubject.GERMAN);

        System.out.println(schoolRamDao);

        schoolRamDao.addScheduleTeacher(1,1);
        schoolRamDao.addScheduleTeacher(1,4);

        System.out.println(schoolRamDao);

        schoolRamDao.deleteSchedule(2);

        schoolRamDao.removeScheduleTeacher(1,4);
        schoolRamDao.deleteTeacher(1);

        System.out.println(schoolRamDao);
        schoolRamDao.addTeacher("Alexander", "Gruber",Gender.MALE,ClassLevel.IN_NO_CLASS,ClassName.NOCLASS);


        schoolRamDao.getTeacher(2);

        System.out.println(schoolRamDao);

    }

}
