package service;

import jwxt.Student;

import java.util.List;

public interface SuperStudentsql {

    List<Student> getAll();
    List<Student> getGrade();


    void add(Student student);
    boolean studentdelete(long stuID);
    boolean changeStudent(String password,long id);
    String findStudent(long stuID);
    boolean login(long stuID,String password);
    boolean changeStudentInformation(long stuID,String stuName,String stuClass);

}
