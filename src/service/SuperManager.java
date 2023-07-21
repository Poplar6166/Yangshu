package service;

import jwxt.Manager;

import java.util.Date;

interface SuperManager {
    Manager show(String id);

    void add(Manager manager);

    void delete(String id);

    void change(Manager manager);

}
