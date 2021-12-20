import enums.*;

import java.sql.*;
import java.util.ArrayList;

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
            System.out.println("Error Creating an Database!");
            System.out.println(ex.getMessage());
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
            System.out.println("SQL ERROR: " + ex.getMessage());
        }

        try {
            sql = "DROP TABLE student";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex.getMessage());
        }

        try {
            sql = "DROP TABLE teacher";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex.getMessage());
        }

    }

    public void initDatabase() {
        String sql;
        try {
            sql = "CREATE TABLE teacher (id integer PRIMARY KEY, firstName varchar(32), lastName varchar(32), gender varchar(32), classLevel varchar(32), className varchar(32))";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex.getMessage());

        }

        try {
            sql = "CREATE TABLE student (id integer PRIMARY KEY, firstName varchar(32), lastName varchar(32), gender varchar(32), classLevel varchar(32), className varchar(32))";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex.getMessage());

        }

        try {
            sql = "CREATE TABLE schedule (id integer PRIMARY KEY, day varchar(32), time varchar(32), schoolSubject varchar(32), teacherID integer, FOREIGN KEY (teacherID) REFERENCES teacher(id))";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex.getMessage());

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
                Teacher teacher = this.getTeacher(sqlResult.getInt("teacher"));

                result.add(new Schedule(id, day, time, schoolSubject, teacher));
            }
        } catch (SQLException ex) {
            System.out.println("get All Schedules ERROR: " + ex.getMessage());
            return result;
        }
        return result;
    }

    @Override
    public Teacher getTeacher(int id) throws Exception {
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
                String lastName =sqlResult.getString("lastName");
                Gender gender =Gender.valueOf(sqlResult.getString("gender"));
                ClassLevel classLevel= ClassLevel.valueOf(sqlResult.getString("classLevel"));
                ClassName className = ClassName.valueOf(sqlResult.getString("className"));

                localTeacher = new Teacher(idLoc,firstName,lastName,gender,classLevel,className);
            }

        } catch (SQLException ex) {
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
            System.out.println("Add-Teacher ERROR: " + ex);
        }
        return localTeacher;
    }

    @Override
    public Teacher deleteTeacher(int id) {
        String sql = "DELETE from teacher where id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);

            //Todo: dont forget to execute!!
            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("delete Teacher Error: "+ ex.getMessage());
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
                String lastName =sqlResult.getString("lastName");
                Gender gender =Gender.valueOf(sqlResult.getString("gender"));
                ClassLevel classLevel= ClassLevel.valueOf(sqlResult.getString("classLevel"));
                ClassName className = ClassName.valueOf(sqlResult.getString("className"));

                localStudent = new Student(idLoc,firstName,lastName,gender,classLevel,className);
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

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);

            //Todo: dont forget to execute!!
            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("delete Student Error: "+ ex.getMessage());
        }
        return null;
    }

    @Override
    public Schedule getSchedule(int id) {
        return null;
    }

    @Override
    public Schedule addSchedule(Day day, String time, SchoolSubject schoolSubject) throws Exception {
        return null;
    }

    @Override
    public Schedule deleteSchedule(int id) {
        return null;
    }

    @Override
    public void addScheduleTeacher(int scheduleID, int teacherID) {

    }

    @Override
    public ArrayList<Teacher> getScheduleTeacher(int scheduleID) {
        return null;
    }

    @Override
    public Schedule removeScheduleTeacher(int scheduleID, int teacherID) {
        return null;
    }

    @Override
    public Schedule addScheduleStudent(Schedule scheduleID, Student studentID) {
        return null;
    }

    @Override
    public Schedule getScheduleStudent(Schedule scheduleID) {
        return null;
    }

    @Override
    public Schedule removeScheduleStudent(Schedule scheduleID, Student studentID) {
        return null;
    }
}
