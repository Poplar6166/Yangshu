package service.mysql;

import jwxt.Student;
import jwxt.Teacher;
import service.SuperStudentsql;
import util.JDBCTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsqlService implements SuperStudentsql {

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
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO Student(stuID,stuName,stuClass) VALUES (?,?,?)")){
                ps.setObject(1,student.getStuID());
                ps.setObject(2,student.getStuName());
                ps.setObject(3,student.getstuClass());
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

    public boolean studentDelete(long stuID) {
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("DELETE FROM SC WHERE stuID = ?")) {
                ps.setObject(1, stuID);
                int n = ps.executeUpdate();
                if (n > 0) {
                    try (PreparedStatement ps2 = coon.prepareStatement("DELETE FROM student WHERE stuID = ?")) {
                        ps2.setObject(1, stuID);
                        int n2 = ps2.executeUpdate();
                        if (n2 > 0) {
                            return true;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public List<Student> getStudent(long tcID) {
        List<Student> result = new ArrayList<>();
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("SELECT stuID, stuName, stuClass FROM Student WHERE stuID IN (SELECT stuID FROM SC WHERE tcID = ?)")) {
                ps.setObject(1, tcID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    long stuID = rs.getLong(1);
                    String stuName = rs.getString(2);
                    String stuClass = rs.getString(3);
                    Student student = new Student();
                    student.setStudent(stuID, stuName, stuClass);
                    result.add(student);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public boolean changeStudent(String password,long id){
        try(Connection coon = JDBCTemplate.getInstance()){
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
    public boolean changeStudentInformation(long stuID,String stuName,String stuClass){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Student SET stuPassword = '123456',stuName = ?,stuClass = ? WHERE stuID = ?")){
                ps.setObject(1,stuName);
                ps.setObject(2,stuClass);
                ps.setObject(3,stuID);
                int n = ps.executeUpdate();
                if(n>0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    public String findStudent(long stuID) {
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("SELECT stuID,stuName,stuClass FROM Student WHERE stuID = ?")) {
                ps.setObject(1, stuID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return "学生ID：" + rs.getLong("stuID") + " 学生姓名："
                            + rs.getString("stuName") + " ,学生所在班级: " + rs.getString("stuClass");
                }
                System.out.println("未找到学生信息");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public boolean login(long stuID, String password) {
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("SELECT stuID, stuPassword FROM Student WHERE stuID = ? and stuPassword = ?")) {
                ps.setObject(1, stuID);
                ps.setObject(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return true; // 如果结果集中有数据，则表示匹配成功，返回true
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false; // 如果没有匹配的记录，返回false
    }
    public List<Student> getGrade(Long stuID) {
        List<Student> result = new ArrayList<>();
        try (Connection conn = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT csID,stugrade FROM SC WHERE stuID = ?")) {
                ps.setObject(1,stuID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    long id = rs.getLong("csID");
                    long grade = rs.getLong("stugrade");
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
