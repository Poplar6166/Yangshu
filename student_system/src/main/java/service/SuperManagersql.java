package service;

import jwxt.Manager;

import java.util.List;

public interface SuperManagersql {
    List<Manager> getAll();
    String findManager(long id);
    void add(Manager manager);


    boolean delete(long id);

    boolean change(Manager manager);
    boolean login(long mgID,String mgPassword);

    boolean changeManager(String password,long id);
    boolean changeCourse(String ifopen,long csID);
    boolean setaddStatus(long stuid);
    boolean changeStatus(long changeid,String state,String stu_reward_punish,String sturegister);
    boolean addStudentEmail(long id,String news);
}
