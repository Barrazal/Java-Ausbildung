import enums.*;

public class DerbyTestBench {
    public static void main(String[] args) throws Exception {

        SchoolDerbyDao schoolDerbyDao = new SchoolDerbyDao("DerbyTest", true);

        schoolDerbyDao.addTeacher("Alexander", "Gruber", Gender.MALE, ClassLevel.IN_NO_CLASS, ClassName.NOCLASS);
        schoolDerbyDao.addTeacher("asadsf", "asfasa", Gender.NOGENDER, ClassLevel.FIRST_CLASS, ClassName.B);
        schoolDerbyDao.addTeacher("gcgbnh", "rutzfhc", Gender.MALE, ClassLevel.FOURTH_CLASS, ClassName.C);
        schoolDerbyDao.addTeacher("1425", "745", Gender.NOGENDER, ClassLevel.FIRST_CLASS, ClassName.B);

        schoolDerbyDao.addSchedule(Day.SATURDAY,"12:00", SchoolSubject.ENGLISH);
        schoolDerbyDao.addSchedule(Day.MONDAY,"12:00", SchoolSubject.MATH);
        schoolDerbyDao.addSchedule(Day.SATURDAY,"08:00", SchoolSubject.PHYSICS_AND_CHEMISTRY);
        schoolDerbyDao.addSchedule(Day.WEDNESDAY,"12:00", SchoolSubject.GERMAN);

        System.out.printf("all Schedules:");
        System.out.println(schoolDerbyDao.getAllSchedules());
        System.out.println();
        System.out.printf("all Teachers:");
        System.out.println(schoolDerbyDao.getAllTeachers());


        schoolDerbyDao.addScheduleTeacher(3,4);
        schoolDerbyDao.addScheduleTeacher(1,1);
        schoolDerbyDao.addScheduleTeacher(2,2);
        System.out.println(schoolDerbyDao.getAllSchedules());

        System.out.println();

        System.out.println("Get all Teachers from Schedule at the following day´s:");
        System.out.println("Monday: \n" + schoolDerbyDao.getScheduleTeacher(Day.MONDAY));
        System.out.println("Saturday: \n" + schoolDerbyDao.getScheduleTeacher(Day.SATURDAY));

        System.out.println("Get all Teachers from a Schedule id:");
        System.out.println("id: 3 \n" + schoolDerbyDao.getScheduleTeacher(3));
        System.out.println("id: 4 \n" + schoolDerbyDao.getScheduleTeacher(4));


        System.out.println(schoolDerbyDao);


        System.out.println("remove teacher X from Schedule Y");
        System.out.println(schoolDerbyDao.removeScheduleTeacher(1,1));


    }
}
