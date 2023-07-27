package service;

import jwxt.Student;
import jwxt.Teacher;

import java.util.List;

public interface SuperTeachersql {
    List<Teacher> getAll();
    List<Teacher> getStudent(long tcID);
    Teacher findTeacher(long id);
    void add(Teacher teacher);
    boolean delete(long id);
    boolean login(long tcID,String tcpassword);
    boolean change(Teacher teacher);
    boolean setStudentGrade(long stuID,long stuGrade);
    boolean changeTeacher(String tcpassword,long tcID);
}
