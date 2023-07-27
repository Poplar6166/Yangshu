package service.mysql;

import jwxt.Student;
import service.SuperStudentsql;
import util.JDBCTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsqlService implements SuperStudentsql {
    String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "root";
    @Override
    public List<Student> getAll() {
        List<Student> result = new ArrayList<>();
        try (Connection conn = JDBCTemplate.getInstance()) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT stuID, stuName,stuClass FROM Student")) {
                    while (rs.next()) {
                        long id = rs.getLong("stuID");
                        String name = rs.getString("stuName");
                        String stuclass =  rs.getString("stuClass");
                        Student student = new Student();
                        student.setStudnet(id, name, stuclass);
                        result.add(student);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    @Override
    public void add(Student student) {
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO Student VALUES (?,?)")){
                ps.setObject(1,student.getcsID());
                ps.setObject(2,student.getStuName());
                int n = ps.executeUpdate();
                if(n > 0)
                    System.out.println("添加成功!");
                else
                    System.out.println("添加失败!");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override

    public boolean studentdelete(long stuID){
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("DELETE FROM Student WHERE stuID = ?")){
                ps.setObject(1,stuID);
                int n = ps.executeUpdate();
                if(n>0)
                    return true;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    public boolean changeStudent(String password,long id){
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Student SET stuPassword = ? WHERE stuID = ?")){
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
    public String findStudent(long stuID){
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("SELECT * FROM Student WHERE stuID = ?")){
                ps.setObject(1,stuID);
                ResultSet rs = ps.executeQuery();
                int n = ps.executeUpdate();
                if(n > 0)
                    System.out.println("找到学生信息：");
                while(rs.next()) {
                    return "学生ID：" + rs.getLong("stuID") + " 学生姓名：" + rs.getString("stuName");
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
    public boolean login(long stuID,String password){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("SELECT stuID,stuPassword FROM Student WHERE stuID = ? and stuPassword = ?")){
                ps.setObject(1,stuID);
                ps.setObject(2,password);
                int n = ps.executeUpdate();
                if(n > 0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    public List<Student> getGrade() {
        List<Student> result = new ArrayList<>();
        try (Connection conn = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT csID,stugrade FROM SC")) {
                ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        long id = rs.getLong("stuID");
                        long grade = rs.getLong("stugrate");
                        Student student = new Student();
                        student.setGrade(id,grade);
                        result.add(student);
                    }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
