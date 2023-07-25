package service.mysql;

import jwxt.Student;
import service.SuperStudent;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class StudentService implements SuperStudent {
    String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "root";
    @Override
    public List<Student> getAll() {

        return null;
    }
    @Override
    public void add(Student student) {
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO Student VALUES (?,?)")){
                ps.setObject(1,student.getStudentId());
                ps.setObject(2,student.getStudentName());
                int n = ps.executeUpdate();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override

    public boolean studentdelete(long stuId){
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("DELETE FROM Student WHERE stuID = ?")){
                ps.setObject(1,stuId);
                int n = ps.executeUpdate();
                if(n>0)
                    return true;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    @Override

    public boolean changeStudent(Student student){
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Student SET stuName = ? WHERE stuID = ?")){
                ps.setObject(1,student.getStudentName());
                ps.setObject(2,student.getStudentId());
                int n = ps.executeUpdate();
                if(n>0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    public String findStudent(long studentId){
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("SELECT * FROM Student WHERE stuID = ?")){
                ps.setObject(1,studentId);
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    System.out.println("找到学生信息：");
                    return "学生ID：" + rs.getLong("stuID") + " 学生姓名：" + rs.getString("stuName");
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }


    public void showStudent(){
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT stuID,stuName FROM Student ")) {
                    while (rs.next()) {
                        long id = rs.getLong(1); // 注意：索引从1开始
                        String name = rs.getString(2);
                        System.out.println("ID: " + id +  ",NAME: "+name);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
