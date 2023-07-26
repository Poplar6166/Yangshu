package service.mysql;

import jwxt.Manager;
import jwxt.Teacher;
import service.SuperManager;

import java.sql.*;
import java.util.*;

public class ManagerService implements SuperManager {
    String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "root";
    Map<Long,Manager> data = new HashMap<>();
    public List<Manager> getAll(){
        List<Manager> result = new ArrayList<>();
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps =  coon.prepareStatement("SELECT * FROM Manager")){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Manager manager = new Manager();
                    long id = rs.getLong("managerID");
                    String name = rs.getString("managerName");
                    manager.setManager(id,name);
                    result.add(manager);
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return result;
    }
    public void add(Manager manager){
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("INSERT INTO Manager VALUES (?,?)")){
                ps.setObject(1,manager.getManagerId());
                ps.setObject(1,manager.getManagerName());
                int n = ps.executeUpdate();
                if(n > 0)
                    System.out.println("添加成功!");
                else
                    System.out.println("添加失败");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean delete(long id){
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("DELETE FROM Manager WHERE managerID = ?")){
                ps.setObject(1,id);
                int n = ps.executeUpdate();
                if(n > 0)
                    return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean change(Manager manager){
    try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
        try(PreparedStatement ps = coon.prepareStatement("UPDATE Manager SET managerName = ? WHERE managerID = ?")){
            ps.setObject(1,manager.getManagerName());
            ps.setObject(2,manager.getManagerId());
            int n = ps.executeUpdate();
            if(n > 0)
                return true;
        }
    }catch (SQLException e){
        throw new RuntimeException(e);
    }
    return false;
    }
    public Manager findManager(long id){
        Manager manager = new Manager();
        try(Connection coon = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement ps = coon.prepareStatement("SELECT * FROM Manager WHERE managerID = ?")){
                ps.setObject(1,id);
                int n = ps.executeUpdate();
                if(n > 0){
                    ResultSet rs = ps.executeQuery();
                    manager.setManager(rs.getLong("managerID"),rs.getString("managerName") );
                    return manager;
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

}
