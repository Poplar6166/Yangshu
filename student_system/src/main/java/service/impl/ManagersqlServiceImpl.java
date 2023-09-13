package service.impl;

import jwxt.Manager;
import service.SuperManagersql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagersqlServiceImpl implements SuperManagersql {
    Map<Long, Manager> data = new HashMap<>();
    public List<Manager> getAll(){
        return data.values().stream().toList();
    }

    public String findManager(long id) {
        return null;
    }

    public void add(Manager manager) {
        data.put(manager.getManagerId(), manager);
    }

    public boolean delete(long id) {
        return false;
    }

    public boolean change(Manager manager) {
        return false;
    }
    public boolean login(long mgID,String mgPassword){
        return false;
    }
    public boolean setCourse(long ifopen,long csID){return false;}
    public boolean changeManager(String password,long id){
        return false;
    }
}
