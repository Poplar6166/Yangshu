package service.impl;

import jwxt.Manager;
import service.SuperManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerServiceImpl implements SuperManager {
    Map<Long, Manager> data = new HashMap<>();
    public List<Manager> getAll(){
        return data.values().stream().toList();
    }

    public Manager findManager(long id) {
        return data.get(id);
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
}
