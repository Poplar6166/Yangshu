package service.mysql;

import jwxt.MyClass;
import jwxt.Student;
import service.SuperStudentsql;
import util.JDBCTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsqlService implements SuperStudentsql {
    public List<Student> getAllClassStudent(long csid) {
        List<Student> result = new ArrayList<>();
        try (Connection conn = JDBCTemplate.getInstance()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT stuID FROM SC WHERE csID = ?")) {
                stmt.setLong(1, csid);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        long stuID = rs.getLong("stuID");
                        // 根据stuID获取学生对象MyClass，并添加到result列表中
                        Student student = new Student();
                        student.setClass(csid,stuID);
                        result.add(student);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public List<Student> get_All_Student_Grade(){
        List<Student> result = new ArrayList<>();
        try(Connection coon = JDBCTemplate.getInstance()){
            try(Statement stmt = coon.createStatement()){
                try(ResultSet rs = stmt.executeQuery("SELECT stuID,csID,tcID,stugrade FROM SC ")){
                    while (rs.next()){
                        long stuID = rs.getLong("stuID");
                        long csID = rs.getLong("csID");
                        long tcID = rs.getLong("tcID");
                        long stugrade = rs.getLong("stugrade");
                        Student student = new Student();
                        student.sentParent(stuID,csID,tcID,stugrade);
                        result.add(student);
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return result;
    }

    /*获取所有课程*/
    public List<MyClass> getAllclass(){
        List<MyClass> result = new ArrayList<>();
        try(Connection coon = JDBCTemplate.getInstance()){
            try(Statement stmt = coon.createStatement()){
                try(ResultSet rs = stmt.executeQuery("SELECT csID,csName,tcID,ifopen FROM Course")){
                    while (rs.next()){
                        long csid = rs.getLong("csID");
                        String name = rs.getString("csName");
                        long tcid = rs.getLong("tcID");
                        String ifopen = rs.getString("ifopen");
                        MyClass myClass = new MyClass();
                        myClass.setClass(csid,name,tcid,ifopen);
                        result.add(myClass);
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return result;
    }
    /*获取所有学生的信息*/
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
    /*添加学生的功能*/
    @Override
    public void add(Student student) {
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO Student(stuName,stuClass) VALUES (?,?)")){
                ps.setObject(1,student.getStuName());
                ps.setObject(2,student.getstuClass());
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
    /*删除学生的功能(先删除Sc表，再删除student表)*/
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
    /*获取老师所教学的所有学生以及其所在班级的功能*/
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
    public List<Student> findEmail(Long stuID) {
        List<Student> result = new ArrayList<>();
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("SELECT news FROM email WHERE stuID = ?")) {
                ps.setObject(1, stuID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String stuEmail = rs.getString(1);
                    Student student = new Student();
                    student.setEmail(stuEmail);
                    result.add(student);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    /*学生自己修改密码*/
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
    /*学生自己修改地址和身份证号*/
    public boolean changeStudentinformation(long IDcard,String Address,long stuID){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Student SET stuIDcard = ?,stuAddress = ? WHERE stuID = ?")){
                ps.setObject(1,IDcard);
                ps.setObject(2,Address);
                ps.setObject(3,stuID);
                int n = ps.executeUpdate();
                if(n > 0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    /*修改学生信息*/
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
    /*查询学生信息的功能*/
    public String findStudent(long stuID) {
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("SELECT stuID,stuName,stuClass,stuSdept,stuIDcard,stuAddress FROM Student WHERE stuID = ?")) {
                ps.setObject(1, stuID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return "学生ID：" + rs.getLong("stuID") + " 学生姓名: "
                            + rs.getString("stuName") + " ,学生所在班级: "
                            + rs.getString("stuClass") + " ,学生所在系: "
                            + rs.getLong("stuSdept") + " ,学生身份证: "
                            + rs .getString("stuIDcard") + " ,学生户口所在地: "
                            + rs.getString("stuAddress");
                }
                System.out.println("未找到学生信息");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String findStatus(long stuID) {
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("SELECT * FROM statu WHERE stuID = ?")) {
                ps.setObject(1, stuID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return "学籍号: " + rs.getLong("stID")
                            + rs.getLong("stuID")
                            + rs.getString("stuState")
                            + rs.getString("stu_reward_punish")
                            + rs.getString("sturegister");
                }
                System.out.println("未找到学生信息");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /*学生的登录功能*/
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
    /*学生查询自己的成绩*/
    public List<Student> getGrade(Long stuID) {
        List<Student> result = new ArrayList<>();
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("SELECT csID,stugrade FROM SC WHERE stuID = ?")) {
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
    /*选课的功能*/
    public boolean addCourse(long scID,long stuID,long csID,long tcID){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO SC(scID,stuID,csID,tcID) VALUES (?,?,?,?)")){
                ps.setObject(1,scID);
                ps.setObject(2,stuID);
                ps.setObject(3,csID);
                ps.setObject(4,tcID);
                int n = ps.executeUpdate();
                if (n > 0) {
                    return true;
                }
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean seletcCourse(long csID,long stuID,long tcID){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("SELECT * FROM Course WHERE csID = ? AND ifopen LIKE '开放'" )){
                ps.setObject(1,csID);
                int n = ps.executeUpdate();
                if(n > 0) {
                    try(PreparedStatement ps1 = coon.prepareStatement("INSERT INTO SC(stuID,csID,tcID) VALUES (?,?,?)")){
                        ps.setObject(1,stuID);
                        ps.setObject(2,csID);
                        ps.setObject(3,tcID);
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
            return false;
    }


}
