package service;

import java.util.Date;

interface SuperTeacher {
    void show(String id, String name, int age, String sex, Date year, String phone,String bumen);
    void add(String id, String name, int age, String sex, Date year, String phone,String bumen);
    void delete(String id, String name, int age, String sex, Date year, String phone,String bumen);
    void change(String id, String name, int age, String sex, Date year, String phone,String bumen);
}
