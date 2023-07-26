package service;

import jwxt.Student;

import java.util.List;

public interface SuperStudentsql {

    List<Student> getAll();


    void add(Student student);
    boolean studentdelete(long studentId);
    boolean changeStudent(Student student);
    String findStudent(long studentId);
}
