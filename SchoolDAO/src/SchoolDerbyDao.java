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
        try{
            Statement stmt = connection.createStatement();
            try{
                stmt.execute(sql);
            }catch (SQLException e){
                if (!e.getSQLState().equals("X0Y32")){
                    return; // X0Y32 => already exists
                }else{
                    throw (e);
                }
            }
        }catch(SQLException ex){
            System.out.println("SQL ERROR: "+ex.getMessage());
        }
    }

    public void clearDatabase(){
        String sql;
        try{
            sql = "DROP TABLE teacher";
            executeDBStatement(sql);

            sql = "DROP TABLE student";
            executeDBStatement(sql);

            sql = "DROP TABLE schedule";
            executeDBStatement(sql);

        } catch (SQLException ex) {
            System.out.println("SQL ERROR: "+ex.getMessage());
        }
    }

    public void initDatabase(){
        String sql;
        try{
            sql = "CREATE TABLE teacher (id integer PRIMARY KEY, firstName char, lastName char, gender char, classLevel integer, className char)";
            executeDBStatement(sql);

            sql = "CREATE TABLE student (id integer PRIMARY KEY, firstName char, lastName char, gender char, classLevel integer, className char)";
            executeDBStatement(sql);

            sql = "CREATE TABLE schedule (id integer PRIMARY KEY, day char, time char, schoolSubject char, teacherID integer, FOREIGN KEY (teacherID) REFERENCES teacher(id))";
            executeDBStatement(sql);
        }catch (SQLException ex) {
            System.out.println("SQL ERROR: "+ex.getMessage());

        }
    }



    @Override
    public ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> result = new ArrayList<>();
        String sql = "SELECT * FROM TEACHER";
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()){
                int id = sqlResult.getInt("id");
                String firstName = sqlResult.getString("firstName");
                String lastName = sqlResult.getString("lastName");
                String gender = sqlResult.getString("gender");
                int classLevel = sqlResult.getInt("classLevel");
                String className = sqlResult.getString("className");
            }
        }catch (SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
            return result;
        }
        return result;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> result = new ArrayList<>();
        String sql = "SELECT * FROM STUDENTS";
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()){
                int id = sqlResult.getInt("id");
                String firstName = sqlResult.getString("firstName");
                String lastName = sqlResult.getString("lastName");
                String gender = sqlResult.getString("gender");
                int classLevel = sqlResult.getInt("classLevel");
                String className = sqlResult.getString("className");
            }
        }catch (SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
            return result;
        }
        return result;
    }

    @Override
    public ArrayList<Schedule> getAllSchedules() throws Exception {
        ArrayList<Schedule> result = new ArrayList<>();
        String sql = "SELECT * FROM SCHEDULE";
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet sqlResult = stmt.getResultSet();
            while (sqlResult.next()){
                int id = sqlResult.getInt("id");
                Day day = Day.valueOf(sqlResult.getString("day"));
                String time = sqlResult.getString("time");
                SchoolSubject schoolSubject = SchoolSubject.valueOf(sqlResult.getString("schoolSubject"));
                Teacher teacher = new Teacher();
                       teacher = teacher.getId(sqlResult.getInt("teacher"));
                result.add(new Schedule(id,day,time,schoolSubject,teacher);
            }
        }catch (SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
            return result;
        }
        return result;
    }

    @Override
    public Teacher getTeacher(int id) {
        return null;
    }

    @Override
    public Teacher addTeacher(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
        return null;
    }

    @Override
    public Teacher deleteTeacher(int id) {
        return null;
    }

    @Override
    public Student getStudent(int id) {
        return null;
    }

    @Override
    public Student addStudent(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
        return null;
    }

    @Override
    public Student deleteStudent(int id) {
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
