package service;

import jwxt.Manager;

import java.util.List;

public interface SuperManagersql {
    List<Manager> getAll();
    Manager findManager(long id);
    void add(Manager manager);

    boolean delete(long id);

    boolean change(Manager manager);

}
