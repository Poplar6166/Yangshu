package service.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jwxt.Manager;
import service.SuperManagersql;
import util.JDBCTemplate;

import javax.sql.DataSource;
import javax.sql.rowset.JdbcRowSet;
import java.security.Key;
import java.sql.*;
import java.util.*;
import java.sql.Connection;

public class ManagersqlService implements SuperManagersql {
    Map<Long, Manager> data = new HashMap<>();
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


    public String findManager(long mgID){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("SELECT mgID,mgName FROM Manager WHERE mgID = ?")){
                ps.setObject(1,mgID);
                ResultSet rs = ps.executeQuery();
                int n = ps.executeUpdate();
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
    public boolean login(long mgID,String mgPassword){
        try(Connection coon = JDBCTemplate.getInstance()){
            try(PreparedStatement ps = coon.prepareStatement("SELECT mgID,mgpassword FROM Manager WHERE mgID = ? and mgassword = ?")){
                ps.setObject(1,mgID);
                ps.setObject(2,mgPassword);
                int n = ps.executeUpdate();
                if(n > 0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
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

}
