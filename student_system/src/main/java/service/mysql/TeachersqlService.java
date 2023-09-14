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
    /*获取全部老师的信息*/
    public List<Teacher> getAll(){
    List<Teacher> result = new ArrayList<>();
    try(Connection coon = JDBCTemplate.getInstance()){
        try (Statement stmt = coon.createStatement()){
            try (ResultSet rs = stmt.executeQuery("SELECT teacherID,teacherName,tcSdept FROM Teacher")){
                while(rs.next()) {
                    Teacher teacher = new Teacher();
                    long id = rs.getLong("teacherID");
                    String name = rs.getString("teacherName");
                    String sdept = rs.getString("tcSdept");
                    teacher.setTeacher(id, name,sdept);
                    result.add(teacher);
                }
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return result;
    }
    /*查找老师的信息*/
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

    /*public Teacher show(String id){
        return data.get(id);
    }*/
    /*添加老师的信息*/
    public void add(Teacher teacher){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO Teacher(tcID,tcName,tcSdept) VALUES (?,?,?)")){
                ps.setObject(1,teacher.getTeacherId());
                ps.setObject(2,teacher.getTeacherName());
                ps.setObject(3,teacher.);
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
    /*删除老师的信息(由管理员操作)*/
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

    /*修改老师的信息*/
    public boolean change(Teacher teacher){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Teacher SET tcName = ? WHERE tcID = ?")){
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
    /*教师的登录功能*/
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
    /*添加学生的成绩*/
    public boolean setStudentGrade(long stuID,long csID,long stuGrade){
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
    /*修改自己的密码*/
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
    /*修改自己的信息*/
    public boolean changeTeacherInformation(long tcID,String tcName){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Teacher SET tcName = ? WHERE tcID = ?")){
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
    /*开设新课程*/
    public boolean setCourse(String csName,long tcID){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO Course(csName,tcID) VALUES (?,?)")){
                ps.setObject(1,csName);
                ps.setObject(2,tcID);
                int n = ps.executeUpdate();
                if(n > 0)
                    return true;
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean changeClass(String csName,long csCredit,long csHour,String csNature,long tcID){
        try(Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("UPDATE Course SET csCredit = ?,csHour = ?,csNature = ? WHERE csName = ? AND tcID = ?")) {
                ps.setObject(1, csCredit);
                ps.setObject(2, csHour);
                ps.setObject(3, csNature);
                ps.setObject(4,csName);
                ps.setObject(5,tcID);
                int n = ps.executeUpdate();
                if (n > 0)
                    return true;
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    /*课程教师设定，是否开设的开关默认0由管理员添加，如果id不为1则学生无法选这个课程*/
}
