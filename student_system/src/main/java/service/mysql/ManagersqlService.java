package service.mysql;
import jwxt.Manager;
import jwxt.MyClass;
import jwxt.Student;
import service.SuperManagersql;
import util.JDBCTemplate;

import java.security.Key;
import java.sql.*;
import java.util.*;
import java.sql.Connection;

public class ManagersqlService implements SuperManagersql {
    /*Map<Long, Manager> data = new HashMap<>();*/
    /*获取所有的管理员信息*/
    public List<Manager> getAll() {
        List<Manager> result = new ArrayList<>();
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("SELECT * FROM Manager")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Manager manager = new Manager();
                    long id = rs.getLong("managerID");
                    String name = rs.getString("managerName");
                    manager.setManager(id, name);
                    result.add(manager);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public List<MyClass> getAllClass() {
        List<MyClass> result = new ArrayList<>();
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("SELECT * FROM Course ")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    long csid = rs.getLong("csID");
                    String name = rs.getString("csName");
                    long tcid = rs.getLong("tcID");
                    long csCredit = rs.getLong("csCredit");
                    long csHour = rs.getLong("csHour");
                    String csNature = rs.getString("csNature");
                    String ifOpen = rs.getString("ifopen");
                    MyClass myClass = new MyClass();
                    myClass.setAllClass(csid,name,tcid,csCredit,csHour,csNature,ifOpen);
                    result.add(myClass);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    /*添加管理员信息*/
    public void add(Manager manager) {
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("INSERT INTO Manager VALUES (?,?)")) {
                ps.setObject(1, manager.getManagerId());
                ps.setObject(2, manager.getManagerName());
                int n = ps.executeUpdate();
                if (n > 0)
                    System.out.println("添加成功!");
                else
                    System.out.println("添加失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*删除管理员信息*/
    public boolean delete(long id) {
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("DELETE FROM Manager WHERE managerID = ?")) {
                ps.setObject(1, id);
                int n = ps.executeUpdate();
                if (n > 0)
                    return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    /*修改管理员姓名*/
    public boolean change(Manager manager) {
        try (Connection coon = JDBCTemplate.getInstance()) {
            try (PreparedStatement ps = coon.prepareStatement("UPDATE Manager SET managerName = ? WHERE managerID = ?")) {
                ps.setObject(1, manager.getManagerName());
                ps.setObject(2, manager.getManagerId());
                int n = ps.executeUpdate();
                if (n > 0)
                    return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    /*查找管理员自己的信息*/
    public String findManager(long mgID){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("SELECT mgID,mgName FROM Manager WHERE mgID = ?")){
                ps.setObject(1,mgID);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    return "您的ID: " + rs.getLong("mgID") + " 您的姓名: "
                            + rs.getString("mgName");
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
    /*管理员登录功能*/
    public boolean login(long mgID,String mgPassword){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("SELECT mgID,mgpassword FROM Manager WHERE mgID = ? and mgpassword = ?")){
                ps.setObject(1,mgID);
                ps.setObject(2,mgPassword);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return true; // 如果结果集中有数据，则表示匹配成功，返回true
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    /*修改管理员密码*/
    public boolean changeManager(String password,long id){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Manager SET mgpassword = ? WHERE mgID = ?")){
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
    /*确定是否开设课程*/
    public boolean changeCourse(String ifopen,long csID){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE Course SET ifopen = ? WHERE csID = ?")){
                ps.setObject(1,ifopen);
                ps.setObject(2,csID);
                int n = ps.executeUpdate();
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean setaddStatus(long stuid){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO statu(stuID) VALUES (?)")){
                ps.setObject(1,stuid);
                int n = ps.executeUpdate();
                if(n > 0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean changeStatus(long changeid,String state,String stu_reward_punish,String sturegister){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("UPDATE statu SET stuState = ? AND stu_reward_punish = ? AND sturegister = ? WHERE stuID = ?")){
                ps.setObject(1,state);
                ps.setObject(2,stu_reward_punish);
                ps.setObject(3,sturegister);
                ps.setObject(4,changeid);
                int n = ps.executeUpdate();
                if(n > 0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    return false;
    }
    public boolean addStudentEmail(long id,String news){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO email(stuID,news) VALUES (?,?)")){
                ps.setObject(1,id);
                ps.setObject(2,news);
                int n = ps.executeUpdate();
                if(n > 0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
}
