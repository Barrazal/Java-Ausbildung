import enums.*;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SchoolRamDao implements SchoolDao {

    HashMap<Integer, Teacher> teacherStorage;
    HashMap<Integer, Student> studentStorage;
    HashMap<Integer, Schedule> scheduleStorage;

    public SchoolRamDao() {
        this.teacherStorage = new HashMap<>();
        this.studentStorage = new HashMap<>();
        this.scheduleStorage = new HashMap<>();
    }

    @Override
    public ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> result = new ArrayList<>();
        //add the Value for each entry of teacherStorage in result and output it!
        for (Map.Entry<Integer, Teacher> entry : teacherStorage.entrySet()
        ) {
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> result = new ArrayList<>();
        //add the Value for each entry of studentStorage in result and output it!
        for (Map.Entry<Integer, Student> entry : studentStorage.entrySet()
        ) {
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    //add the Value for each entry of scheduleStorage in result and output it!
    public ArrayList<Schedule> getAllSchedules() {

        ArrayList<Schedule> result = new ArrayList<>();
        for (Map.Entry<Integer, Schedule> entry : scheduleStorage.entrySet()
        ) {
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    //return the Teacher with id from teacherStorage
    public Teacher getTeacher(int id) {
        return teacherStorage.get(id);
    }

    @Override
    //add an new Teacher to the Storage
    public Teacher addTeacher(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
        Teacher newTeacher = new Teacher(firstName, lastName, gender, classLevel, className);
        return teacherStorage.put(newTeacher.getId(), newTeacher);
    }
    @Override
    public Teacher addTeacher(Teacher teacher) throws Exception {
        return teacherStorage.put(teacher.getId(), teacher);
    }

    @Override
    public Teacher deleteTeacher(int id) {
        for (Schedule sched : getAllSchedules()) {
            this.removeScheduleTeacher(sched.getId(), id);
        }
        return teacherStorage.remove(id);
    }

    @Override
    public Student getStudent(int id) {
        return studentStorage.get(id);
    }

    @Override
    public Student addStudent(String firstName, String lastName, Gender gender, ClassLevel classLevel, ClassName className) throws Exception {
        Student newStudent = new Student(firstName, lastName, gender, classLevel, className);
        return studentStorage.put(newStudent.getId(), newStudent);
    }

    @Override
    public Student deleteStudent(int id) {
        return studentStorage.remove(id);
    }

    @Override
    public Schedule getSchedule(int id) {
        return scheduleStorage.get(id);
    }

    public Schedule addSchedule(Day day, String time, SchoolSubject schoolSubject) throws Exception {
        Schedule newSchedule = new Schedule(day, time, schoolSubject);
        return scheduleStorage.put(newSchedule.getId(), newSchedule);
    }

    @Override
    public Schedule deleteSchedule(int id) {
        return scheduleStorage.remove(id);
    }

    @Override
    public void addScheduleTeacher(int scheduleID, int teacherID) {
        Teacher localeTeacher = this.getTeacher(teacherID);
        Schedule localSchedule = this.getSchedule(scheduleID);
        //     localeTeacher.setTeachesSchedule(localSchedule);
        localSchedule.setTeacher(localeTeacher);
    }

    @Override
    public ArrayList<Teacher> getScheduleTeacher(Day day) {
        return null;
    }

    @Override
    public ArrayList<Teacher> getScheduleTeacher(int scheduleID) {
        return this.getSchedule(scheduleID).getTeacher();
    }

    @Override
    public Schedule removeScheduleTeacher(int scheduleID, int teacherID) {
        Teacher localeTeacher = this.getTeacher(teacherID);
        Schedule localSchedule = this.getSchedule(scheduleID);
        localSchedule.removeTeacher(localeTeacher);
        return null;
    }

  //  @Override
  //  public Schedule addScheduleStudent(Schedule scheduleID, Student studentID) {
  //      return null;
  //  }
//
  //  @Override
  //  public Schedule getScheduleStudent(Schedule scheduleID) {
  //      return null;
  //  }
//
  //  @Override
  //  public Schedule removeScheduleStudent(Schedule scheduleID, Student studentID) {
  //      return null;
  //  }

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
        ArrayList<Teacher> locArray = this.getAllTeachers();
        try {
            BufferedWriter newWriter = new BufferedWriter(new FileWriter(csvFileName,true));
            newWriter.newLine();
            newWriter.write("firstName,lastName,gender,classLevel,className");
            for (Teacher teach: locArray) {

                String firstName = teach.getFirstName();
                String lastName = teach.getLastName();
                Gender gender = teach.getGender();
                ClassLevel classLevel = teach.getClassLevel();
                ClassName className = teach.getClassName();


                //string.format example: https://www.javatpoint.com/java-string-format
                String line = String.format("%s,%s,%s,%s,%s", firstName, lastName, gender, classLevel, className);
                newWriter.newLine();
                newWriter.write(line);
            }

            newWriter.close();

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
                    this.addTeacher(new Teacher(firstName,lastName,gender,classLevel,className));
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


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\nThis Persons are Teachers:\n");
        for (Teacher arr1 : this.getAllTeachers()) {
            stringBuilder.append(arr1 + "\n");
        }

        stringBuilder.append("\nThis Persons are Students:\n");
        for (Student arr1 : this.getAllStudents()) {
            stringBuilder.append(arr1 + "\n");
        }

        stringBuilder.append("\nThese are the Schedules of the classes:\n");
        for (Schedule arr1 : this.getAllSchedules()) {
            stringBuilder.append(arr1 + "\n");
        }


        return " " + stringBuilder + " ";
    }
}
