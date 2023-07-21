package service;

import jwxt.Student;

import javax.swing.text.TabSet;
import java.util.Date;

interface SuperStudent {

    Student show(String stuId);
    void add(Student student);
    void delete(String stuId);
    void change(Student student);
    void addStudent(String studentId, String name, int age, String sex,Date year,
             String phone,String bumen,String sushe,String banji,String bandaoshi);
}
