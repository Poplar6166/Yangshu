package service.mysql;
import jwxt.Teacher;
import service.SuperTeachersql;
import util.JDBCTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class TeachersqlService implements SuperTeachersql {

    Map<String,Teacher> data = new HashMap<>();
    public List<Teacher> getAll(){
    List<Teacher> result = new ArrayList<>();
    try(Connection coon = JDBCTemplate.getInstance()){
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

    public String findTeacher(long tcID){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("SELECT tcID,tcName FROM Teacher WHERE tcID = ?")){
                ps.setObject(1,tcID);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    return "教师ID：" + rs.getLong("tcID") + " 教师姓名："
                            + rs.getString("tcName");
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public Teacher show(String id){
        return data.get(id);
    }
    public void add(Teacher teacher){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO Teacher(tcID,tcName) VALUES (?,?)")){
                ps.setObject(1,teacher.getTeacherId());
                ps.setObject(2,teacher.getTeacherName());
                int n = ps.executeUpdate();
                if(n > 0)
                    System.out.println("添加成功!");
                else
                    System.out.println("添加失败!");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public boolean delete(long id) {
        try (Connection coon = JDBCTemplate.getInstance()) {
            try(PreparedStatement ps = coon.prepareStatement("DELETE FROM Teacher WHERE tcID = ?")){
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
        try(Connection coon = JDBCTemplate.getInstance()){
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
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("SELECT tcID, tcpassword FROM Teacher WHERE tcID = ? and tcpassword = ?")) {
                ps.setObject(1, tcID);
                ps.setObject(2, tcpassword);
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


    public boolean setStudentGrade(long stuID,long stuGrade){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE SC SET stugrade = ? WHERE stuID = ?")){
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
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Teacher SET tcpassword = ? WHERE tcID = ?")){
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
    public boolean changeTeacherInformation(long tcID,String tcName){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Teacher SET tcpassword = '123456',tcName = ? WHERE tcID = ?")){
                ps.setObject(1,tcName);
                ps.setObject(2,tcID);
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
