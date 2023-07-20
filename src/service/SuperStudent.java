package service;

import javax.swing.text.TabSet;
import java.util.Date;

interface SuperStudent {

    void show(String id, String name, int age, String sex, Date year, String phone,String bumen,String sushe,String banji,String bandaoshi);
    void add(String id, String name, int age, String sex, Date year, String phone,String bumen,String sushe,String banji,String bandaoshi);
    void delete(String id, String name, int age, String sex, Date year, String phone,String bumen,String sushe,String banji,String bandaoshi);
    void change(String id, String name, int age, String sex, Date year, String phone,String bumen,String sushe,String banji,String bandaoshi);
}
