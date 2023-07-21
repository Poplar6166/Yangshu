package service;

import jwxt.Student;

import java.util.Date;

public interface SuperStudent {

    Student show(String stuId);
    void add(Student student);
    boolean delete(String stuId);
    void change(Student student);
    void addStudent(String studentId, String name, int age, String sex,Date year,
             String phone,String bumen,String sushe,String banji,String bandaoshi);
}
