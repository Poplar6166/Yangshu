package service;

import jwxt.Manager;

public interface SuperManager {
    Manager show(String id);

    void add(Manager manager);

    void delete(String id);

    void change(Manager manager);

}
