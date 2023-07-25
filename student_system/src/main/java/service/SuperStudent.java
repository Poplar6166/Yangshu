package service;

import jwxt.Student;

import java.util.Date;
import java.util.List;

public interface SuperStudent {

    List<Student> getAll();


    void add(Student student);
    boolean studentdelete(long studentId);
    boolean changeStudent(Student student);
    String findStudent(long studentId);
}
