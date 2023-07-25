package service;

import jwxt.Student;

import java.util.Date;
import java.util.List;

public interface SuperStudent {

    List<Student> getAll();

    Student show(long stuId);
    void add(Student student);
    boolean delete(long stuId);
    void change(Student student);
    void addStudent(long studentId, String name, int age, String sex,Date year,
             String phone,String bumen,String sushe,String banji,String bandaoshi);
    boolean studentdelete(long studentId);
    boolean changeStudent(Student student);
    boolean findStudent(long studentId);
}
