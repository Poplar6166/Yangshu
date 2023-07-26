package service;

import jwxt.Manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SuperManager {
    List<Manager> getAll();
    Manager findManager(long id);
    void add(Manager manager);

    boolean delete(long id);

    boolean change(Manager manager);

}
