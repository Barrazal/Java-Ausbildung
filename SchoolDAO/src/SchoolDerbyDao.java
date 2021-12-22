import enums.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SchoolDerbyDao implements SchoolDao {
    Connection connection;


    public SchoolDerbyDao(String dbName) {
        this(dbName, false);
    }

    public SchoolDerbyDao(String dbName, boolean clearAll) {
        try {
            final String DB_URL = "jdbc:derby:" + dbName + ";create=true";
            this.connection = DriverManager.getConnection(DB_URL);
            if (clearAll) clearDatabase();
            initDatabase();
        } catch (Exception ex) {
            System.out.println("Error Creating an Database: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void executeDBStatement(String sql) throws SQLException {
        try {
            Statement stmt = connection.createStatement();
            try {
                stmt.execute(sql);

            } catch (SQLException e) {
                if (!e.getSQLState().equals("X0Y32")) {
                    return; // X0Y32 => already exists
                } else {
                    throw (e);
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex.getMessage());
        }
    }

    public void clearDatabase() {
        String sql;
        try {
            sql = "DROP TABLE schedule";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("DROP TABLE schedule ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }

        try {
            sql = "DROP TABLE student";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("DROP TABLE student ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }

        try {
            sql = "DROP TABLE teacher";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("DROP TABLE teacher ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public void initDatabase() {
        String sql;
        try {
            sql = "CREATE TABLE teacher (id integer PRIMARY KEY, firstName varchar(32), lastName varchar(32), gender varchar(32), classLevel varchar(32), className varchar(32))";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex.getMessage());
            ex.printStackTrace();

        }

        try {
            sql = "CREATE TABLE student (id integer PRIMARY KEY, firstName varchar(32), lastName varchar(32), gender varchar(32), classLevel varchar(32), className varchar(32))";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex.getMessage());
            ex.printStackTrace();

        }

        try {
            sql = "CREATE TABLE schedule (id integer PRIMARY KEY, day varchar(32), time varchar(32), schoolSubject varchar(32), teacherID integer, FOREIGN KEY (teacherID) REFERENCES teacher(id))";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex.getMessage());
            ex.printStackTrace();

        }
    }


    @Override
    public ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> result = new ArrayList<>();
        String sql = "SELECT * FROM teacher";
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()) {
                int id = sqlResult.getInt("ID");
                String firstName = sqlResult.getString("FIRSTNAME");
                String lastName = sqlResult.getString("LASTNAME");
                Gender gender = Gender.valueOf(sqlResult.getString("GENDER"));                  //Required Upper tag!?
                ClassLevel classLevel = ClassLevel.valueOf(sqlResult.getString("CLASSLEVEL"));
                ClassName className = ClassName.valueOf(sqlResult.getString("CLASSNAME"));

                result.add(new Teacher(id, firstName, lastName, gender, classLevel, className));
            }
        } catch (SQLException ex) {
            System.out.println("get all Teachers ERROR: " + ex.getMessage());
            return result;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return result;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> result = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()) {
                int id = sqlResult.getInt("id");
                String firstName = sqlResult.getString("firstName");
                String lastName = sqlResult.getString("lastName");
                Gender gender = Gender.valueOf(sqlResult.getString("gender"));
                ClassLevel classLevel = ClassLevel.valueOf(sqlResult.getString("classLevel"));
                ClassName className = ClassName.valueOf(sqlResult.getString("className"));

                result.add(new Student(id, firstName, lastName, gender, classLevel, className));
            }
        } catch (SQLException ex) {
            System.out.println("get all Students ERROR: " + ex.getMessage());
            return result;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return result;
    }

    @Override
    public ArrayList<Schedule> getAllSchedules() throws Exception {
        ArrayList<Schedule> result = new ArrayList<>();
        String sql = "SELECT * FROM SCHEDULE";
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()) {
                int id = sqlResult.getInt("id");
                Day day = Day.valueOf(sqlResult.getString("day"));
                String time = sqlResult.getString("time");
                SchoolSubject schoolSubject = SchoolSubject.valueOf(sqlResult.getString("schoolSubject"));
                Teacher teacher;
                try {
                    teacher = this.getTeacher(sqlResult.getInt("teacherID"));
                } catch (SQLException ex) {
                    System.out.println("Error Reading Teacher from Schedule: " + ex.getMessage());
                    teacher = null;
                }
                result.add(new Schedule(id, day, time, schoolSubject, teacher));
            }
        } catch (SQLException ex) {
            System.out.println("get All Schedules ERROR: " + ex.getMessage());
            ex.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public Teacher getTeacher(int id) {
        String sql = "SELECT * FROM teacher WHERE id = ?";
        Teacher localTeacher = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()) {
                int idLoc = sqlResult.getInt("id");
                String firstName = sqlResult.getString("firstName");
                String lastName = sqlResult.getString("lastName");
                Gender gender = Gender.valueOf(sqlResult.getString("gender"));
                ClassLevel classLevel = ClassLevel.valueOf(sqlResult.getString("classLevel"));
                ClassName className = ClassName.valueOf(sqlResult.getString("className"));
                localTeacher = new Teacher(idLoc, firstName, lastName, gender, classLevel, className);
            }

        } catch (Exception ex) {
            System.out.println(" Get-Teacher ERROR: " + ex.getMessage());
        }
        return localTeacher;
    }

    @Override
    public Teacher addTeacher(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
        String sql = "INSERT INTO TEACHER(id, firstName, lastName, gender, classLevel, ClassName) VALUES (?,?,?,?,?,?)";
        Teacher localTeacher = null;
        try {
            localTeacher = new Teacher(firstName, lastName, gender, classLevel, className);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, localTeacher.getId());
            stmt.setString(2, localTeacher.getFirstName());
            stmt.setString(3, localTeacher.getLastName());
            stmt.setString(4, gender.toString()); //gender.toString()
            stmt.setString(5, classLevel.toString()); //classLevel.toString()
            stmt.setString(6, className.toString());
            stmt.execute();

        } catch (Exception ex) {
            System.out.println("Add-Teacher ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return localTeacher;
    }

    @Override
    public Teacher addTeacher(Teacher teacher) throws Exception {
        String sql = "INSERT INTO TEACHER(id, firstName, lastName, gender, classLevel, ClassName) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, teacher.getId());
            stmt.setString(2, teacher.getFirstName());
            stmt.setString(3, teacher.getLastName());
            stmt.setString(4, teacher.getGender().toString()); //gender.toString()
            stmt.setString(5, teacher.getClassLevel().toString()); //classLevel.toString()
            stmt.setString(6, teacher.getClassName().toString());
            stmt.execute();

        } catch (Exception ex) {
            System.out.println("Add-Teacher ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return teacher;
    }

    @Override
    public Teacher deleteTeacher(int id) {
        String sql = "DELETE from teacher where id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("delete Teacher Error: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Student getStudent(int id) {
        String sql = "SELECT * FROM STUDENT WHERE id = ?";
        Student localStudent = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()) {
                int idLoc = sqlResult.getInt("id");
                String firstName = sqlResult.getString("firstName");
                String lastName = sqlResult.getString("lastName");
                Gender gender = Gender.valueOf(sqlResult.getString("gender"));
                ClassLevel classLevel = ClassLevel.valueOf(sqlResult.getString("classLevel"));
                ClassName className = ClassName.valueOf(sqlResult.getString("className"));

                localStudent = new Student(idLoc, firstName, lastName, gender, classLevel, className);
            }

        } catch (Exception ex) {
            System.out.println(" Get-Teacher ERROR: " + ex.getMessage());
        }
        return localStudent;
    }

    @Override
    public Student addStudent(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
        String sql = "INSERT INTO STUDENT(id, firstName, lastName, gender, classLevel, ClassName) VALUES (?,?,?,?,?,?)";
        Student localStudent = null;
        try {
            localStudent = new Student(firstName, lastName, gender, classLevel, className);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, localStudent.getId());
            stmt.setString(2, localStudent.getFirstName());
            stmt.setString(3, localStudent.getLastName());
            stmt.setString(4, gender.toString()); //gender.toString()
            stmt.setString(5, classLevel.toString()); //classLevel.toString()
            stmt.setString(6, className.toString());
            stmt.execute();

        } catch (Exception ex) {
            System.out.println("Add-Teacher ERROR: " + ex);
        }
        return localStudent;
    }

    @Override
    public Student deleteStudent(int id) {
        String sql = "DELETE from Student where id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("delete Student Error: " + ex.getMessage());
        }
        return null;
    }


    @Override
    public Schedule getSchedule(int id) {
        String sql = "SELECT * FROM Schedule WHERE id = ?";
        Schedule localSchedule = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()) {
                int idLoc = sqlResult.getInt("id");
                Day day = Day.valueOf(sqlResult.getString("day"));
                String classLevel = sqlResult.getString("time");
                SchoolSubject className = SchoolSubject.valueOf(sqlResult.getString("schoolSubject"));
                Teacher getTeacher = null;

                int teacherid = sqlResult.getInt("teacherID");
                getTeacher = this.getTeacher(teacherid);


                localSchedule = new Schedule(idLoc, day, classLevel, className, getTeacher);
            }

        } catch (Exception ex) {
            System.out.println(" Get-Teacher ERROR: " + ex.getMessage());
        }
        return localSchedule;
    }

    @Override
    public Schedule addSchedule(Day day, String time, SchoolSubject schoolSubject) throws Exception {
        String sql = "INSERT INTO Schedule(id, day,time, schoolSubject) VALUES (?,?,?,?)";
        Schedule localSchedule = null;
        try {
            localSchedule = new Schedule(day, time, schoolSubject);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, localSchedule.getId());
            stmt.setString(2, localSchedule.getDay().toString());
            stmt.setString(3, time);
            stmt.setString(4, schoolSubject.toString()); //gender.toString()
            stmt.execute();

        } catch (Exception ex) {
            System.out.println("Add-Schedule ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return localSchedule;
    }


    @Override
    public Schedule deleteSchedule(int id) {
        String sql = "DELETE from Schedule where id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("delete Schedule Error: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public void addScheduleTeacher(int scheduleID, int teacherID) {
        String sql = "update Schedule set teacherID = ? where ID = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, teacherID);
            stmt.setInt(2, scheduleID);
            stmt.execute();

        } catch (Exception ex) {
            System.out.println(" Add-Teacher to Schedule ERROR: " + ex.getMessage());
        }

    }

    @Override
    public ArrayList<Teacher> getScheduleTeacher(int scheduleID) {
        String sql = "select * from SCHEDULE inner join teacher  on schedule.TEACHERID = teacher.ID where schedule.id = ?";
        ArrayList<Teacher> localTeacher = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, scheduleID);
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()) {
                int id = sqlResult.getInt(6);
                String firstName = sqlResult.getString(7);
                String lastName = sqlResult.getString(8);
                Gender gender = Gender.valueOf(sqlResult.getString(9));
                ClassLevel classLevel = ClassLevel.valueOf(sqlResult.getString(10));
                ClassName className = ClassName.valueOf(sqlResult.getString(11));
                Teacher newTeacher = new Teacher(id, firstName, lastName, gender, classLevel, className);
                localTeacher.add(newTeacher);
            }

        } catch (Exception ex) {
            System.out.println(" Get Schedule-Teacher ERROR: " + ex.getMessage());
        }
        return localTeacher;
    }

    @Override
    public ArrayList<Teacher> getScheduleTeacher(Day day) {
        String sql = "select * from SCHEDULE inner join teacher  on schedule.TEACHERID = teacher.ID where schedule.day = ?";
        ArrayList<Teacher> localTeacher = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, day.toString());
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()) {
                int id = sqlResult.getInt(6);
                String firstName = sqlResult.getString(7);
                String lastName = sqlResult.getString(8);
                Gender gender = Gender.valueOf(sqlResult.getString(9));
                ClassLevel classLevel = ClassLevel.valueOf(sqlResult.getString(10));
                ClassName className = ClassName.valueOf(sqlResult.getString(11));
                Teacher newTeacher = new Teacher(id, firstName, lastName, gender, classLevel, className);
                localTeacher.add(newTeacher);
            }

        } catch (Exception ex) {
            System.out.println(" Get Schedule-Teacher ERROR: " + ex.getMessage());
        }
        return localTeacher;
    }

    @Override
    public Schedule removeScheduleTeacher(int scheduleID, int teacherID) {
        String sql = "update SCHEDULE set TEACHERID = null where ID = ? AND TEACHERID = ?";
        Schedule localSchedule = null;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, scheduleID);
            stmt.setInt(2, teacherID);
            stmt.execute();

            sql = "select * from schedule where id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, scheduleID);
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()) {
                int id = sqlResult.getInt("id");
                Day day = Day.valueOf(sqlResult.getString("day"));
                String time = sqlResult.getString("time");
                SchoolSubject schoolSubject = SchoolSubject.valueOf(sqlResult.getString("schoolSubject"));
                localSchedule = new Schedule(id, day, time, schoolSubject);
                if (sqlResult.getString("TeacherID") != null) {
                    System.out.println("Teacher in Schedule is not correctly removed!");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Remove Schedule Teacher Error: " + ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localSchedule;
    }

//    @Override
//    public Schedule addScheduleStudent(Schedule scheduleID, Student studentID) {
//        return null;
//    }
//
//    @Override
//    public Schedule getScheduleStudent(Schedule scheduleID) {
//        return null;
//    }
//
//    @Override
//    public Schedule removeScheduleStudent(Schedule scheduleID, Student studentID) {
//        return null;
//    }


    /*
   CREATE TABLE teacher (id integer PRIMARY KEY, firstName varchar(32), lastName varchar(32), gender varchar(32), classLevel varchar(32), className varchar(32))
    * */

    //example: https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
    //https://stackabuse.com/reading-and-writing-csvs-in-java/
    public void fileExportTeacher(boolean deleteOldFile) {
        String csvFileName = "teacher_export.csv";
        if (deleteOldFile) {

            try {
                File csvFile = new File(csvFileName);
                if (csvFile.delete()) {
                    System.out.println(csvFile.getName() + " deleted");
                } else {
                    System.out.println(csvFile.getName() + " not deleted!");
                }
            } catch (Exception ex) {
                System.out.println("Error at deleting exportTeacherFile!" + ex.getMessage());

            }
        }

        String sql = "SELECT * FROM TEACHER";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();
            BufferedWriter newWriter = new BufferedWriter(new FileWriter(csvFileName,true));
            newWriter.newLine();
            newWriter.write("firstName,lastName,gender,classLevel,className");
            while (sqlResult.next()) {
                String firstName = sqlResult.getString("FIRSTNAME");
                String lastName = sqlResult.getString("LASTNAME");
                Gender gender = Gender.valueOf(sqlResult.getString("GENDER"));                  //Required Upper tag!?
                ClassLevel classLevel = ClassLevel.valueOf(sqlResult.getString("CLASSLEVEL"));
                ClassName className = ClassName.valueOf(sqlResult.getString("CLASSNAME"));


                //string.format example: https://www.javatpoint.com/java-string-format
                String line = String.format("%s,%s,%s,%s,%s", firstName, lastName, gender, classLevel, className);
                newWriter.newLine();
                newWriter.write(line);
            }
            stmt.close();
            newWriter.close();

        } catch (SQLException e) {
            System.out.println("Export Teacher- Database error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Export Teacher-File IO error:");
            e.printStackTrace();
        }
    }

    public void fileImportTeacher() {
        ArrayList<Teacher> localeTeacher = new ArrayList<>();
        String[] data;
        String row;
        try {
            BufferedReader csvFile = new BufferedReader(new FileReader("teacher_export.csv"));
            while ((row = csvFile.readLine()) != null) {
                data = row.split(",");
                if (!data[0].equals("firstName") && !data[0].equals("")) {
                    String firstName = data[0];
                    String lastName = data[1];
                    Gender gender = Gender.valueOf(data[2]);
                    ClassLevel classLevel = ClassLevel.valueOf(data[3]);
                    ClassName className = ClassName.valueOf(data[4]);
                    this.addTeacher(new Teacher(firstName, lastName, gender, classLevel, className));
                }
            }
            for (int i = 0; i < localeTeacher.size(); i++) {
                this.addTeacher(localeTeacher.get(i));
            }
            //first insert Statement for fileImport!
        /*
            for (int i = 0; i < localeTeacher.size(); i++) {
            String sql = "INSERT INTO TEACHER(id, firstName, lastName, gender, classLevel, ClassName) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, localeTeacher.get(i).getId());
            stmt.setString(2, localeTeacher.get(i).getFirstName());
            stmt.setString(3, localeTeacher.get(i).getLastName());
            stmt.setString(4, localeTeacher.get(i).getGender().toString()); //gender.toString()
            stmt.setString(5, localeTeacher.get(i).getClassLevel().toString()); //classLevel.toString()
            stmt.setString(6, localeTeacher.get(i).getClassName().toString());
            stmt.execute();
            }
        */
        } catch (FileNotFoundException e) {
            System.out.println("File import TeacherError: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File import TeacherError: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("File import TeacherError: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //CREATE TABLE schedule (id integer PRIMARY KEY, day varchar(32), time varchar(32), schoolSubject varchar(32), teacherID integer, FOREIGN KEY (teacherID) REFERENCES teacher(id))


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n\nThis Persons are Teachers:\n");
        for (Teacher arr1 : this.getAllTeachers()) {
            stringBuilder.append(arr1);
        }

        stringBuilder.append("\n\nThis Persons are Students:\n");
        for (Student arr1 : this.getAllStudents()) {
            stringBuilder.append(arr1);
        }

        stringBuilder.append("\n\nThese are the Schedules of the classes:\n");
        try {
            for (Schedule arr1 : this.getAllSchedules()) {
                stringBuilder.append(arr1);
            }
        } catch (Exception e) {
            System.out.println("Error @ToString from getAllSchedules with : " + e.getMessage());
        }


        return " " + stringBuilder + " ";
    }

}
