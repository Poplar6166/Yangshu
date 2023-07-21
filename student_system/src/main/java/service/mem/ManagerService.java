package service.mem;

import jwxt.Manager;
import service.SuperManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerService implements SuperManager {
    Map<String, Manager> data = new HashMap<>();
    public List<Manager> getAll(){
        return data.values().stream().toList();
    }

    public Manager show(String id) {
        return data.get(id);
    }

    public void add(Manager manager) {
        data.put(manager.getManagerId(), manager);
    }

    public void delete(String id) {
        data.remove(id);
    }

    public void change(Manager manager) {
        data.put(manager.getManagerId(), manager);
    }
}
