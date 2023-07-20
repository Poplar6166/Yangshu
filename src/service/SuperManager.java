package service;

import java.util.Date;

interface SuperManager {
    void show(String id, String name, int age, String sex, Date year,String phone);
    void add(String id, String name, int age, String sex, Date year,String phone);
    void delete(String id, String name, int age, String sex, Date year,String phone);
    void change(String id, String name, int age, String sex, Date year,String phone);

}
