import enums.ClassLevel;
import enums.ClassName;
import enums.Gender;

public class DerbyTestBench {
    public static void main(String[] args) throws Exception {
        SchoolDerbyDao derby = new SchoolDerbyDao("DerbyTest", true);
        derby.addTeacher("Alexander", "Gruber", Gender.MALE, ClassLevel.IN_NO_CLASS, ClassName.NOCLASS);
        derby.addTeacher("asadsf", "asfasa", Gender.NOGENDER, ClassLevel.FIRST_CLASS, ClassName.B);


        derby.addStudent("gfds","cxxvcb", Gender.FEMALE,ClassLevel.THIRD_CLASS,ClassName.C);

        System.out.println(derby.getTeacher(2));
        System.out.println(derby.getStudent(1));
        System.out.println(derby.getAllTeachers());
        System.out.println(derby.getAllStudents());


        System.out.println(
        );
        System.out.println();
        System.out.println();

        derby.deleteTeacher(2);
        derby.deleteStudent(1);
        System.out.println(derby.getAllTeachers());
        System.out.println(derby.getAllStudents());


    }
}
