package service.mysql;
import jwxt.Student;
import jwxt.Teacher;
import service.SuperTeachersql;
import util.JDBCTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class TeachersqlService implements SuperTeachersql {
    String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "root";
    Map<String,Teacher> data = new HashMap<>();
    public List<Teacher> getAll(){
    List<Teacher> result = new ArrayList<>();
    try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
        try (Statement stmt = coon.createStatement()){
            try (ResultSet rs = stmt.executeQuery("SELECT teacherID,teacherName FROM Teacher")){
                while(rs.next()) {
                    Teacher teacher = new Teacher();
                    long id = rs.getLong("teacherID");
                    String name = rs.getString("teacherName");
                    teacher.setTeacher(id, name);
                    result.add(teacher);
                }
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return result;
    }

    @Override
    public Teacher findTeacher(long id) {
        Teacher teacher = new Teacher();
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("SELECT teacherID,teacherName FROM Teacher WHERE teacherID = ?")){
                ps.setObject(1,id);
                int n = ps.executeUpdate();
                if(n > 0) {
                    ResultSet rs = ps.executeQuery();
                    teacher.setTeacher(rs.getLong("teacherID"), rs.getString("teacherName"));
                    return teacher;
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public Teacher show(String id){
        return data.get(id);
    }
    public void add(Teacher teacher){
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO Teacher VALUES (?,?)")){
                ps.setObject(1,teacher.getTeacherId());
                ps.setObject(2,teacher.getTeacherName());
                int n = ps.executeUpdate();
                if(n > 0)
                    System.out.println("添加成功!");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public boolean delete(long id) {
        try (Connection coon = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try(PreparedStatement ps = coon.prepareStatement("DELETE FROM Teacher WHERE teacherID = ?")){
                ps.setObject(1,id);
                int n = ps.executeUpdate();
                if(n > 0)
                    return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean change(Teacher teacher){
        try(Connection coon = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Teacher SET teacherName = ? WHERE teacherID = ?")){
                ps.setObject(1,teacher.getTeacherName());
                ps.setObject(2,teacher.getTeacherId());
                int n = ps.executeUpdate();
                if(n>0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean login(long tcID, String tcpassword) {
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("SELECT tcID,tcpassword FROM Teacher WHERE tcID = ? and tcpassword = ?")){
                ps.setObject(1,tcID);
                ps.setObject(2,tcpassword);
                int n = ps.executeUpdate();
                if(n > 0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Teacher> getStudent(long tcID) {
        List<Teacher> result = new ArrayList<>();
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("SELECT stuID,stuName,stuClass FROM Student a,SC b WHERE a.stuID = b.stuID and tcID = ?")) {
                ps.setObject(1, tcID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                long stuID = rs.getLong(1);
                String stuName = rs.getString(2);
                String stuClass = rs.getString(3);
                Teacher teacher = new Teacher();
                teacher.setStudent(stuID,stuName,stuClass);
                result.add(teacher);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public boolean setStudentGrade(long stuID,long stuGrade){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE CS SET stugrade = ? WHERE stuID = ?")){
                ps.setObject(1,stuGrade);
                ps.setObject(2,stuID);
                int n = ps.executeUpdate();
                if(n > 0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean changeTeacher(String password,long id){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Teacher SET tcpassword = ? WHERE stuID = ?")){
                ps.setObject(1,password);
                ps.setObject(2,id);
                int n = ps.executeUpdate();
                if(n>0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
}
