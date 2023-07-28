package service;

import jwxt.Student;

import java.util.List;

public interface SuperStudentsql {

    List<Student> getAll();
    List<Student> getGrade(Long stuID);
    List<Student> getStudent(long tcID);


    void add(Student student);
    boolean studentDelete(long stuID);
    boolean changeStudent(String password,long id);
    String findStudent(long stuID);
    boolean login(long stuID,String password);
    boolean changeStudentInformation(long stuID,String stuName,String stuClass);

}
