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
            return result;
        }
        return result;
    }

    @Override
    public Teacher getTeacher(int id){
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
            System.out.println("Add-Teacher ERROR: " + ex);
        }
        return localTeacher;
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


    //CREATE TABLE schedule (id integer PRIMARY KEY, day varchar(32), time varchar(32), schoolSubject varchar(32), teacherID integer, FOREIGN KEY (teacherID) REFERENCES teacher(id))
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
            System.out.println("Add-Schedule ERROR: " + ex);
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
            stmt.setInt(1,scheduleID);
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
