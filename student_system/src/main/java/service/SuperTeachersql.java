package service;

import jwxt.Student;
import jwxt.Teacher;

import java.util.List;

public interface SuperTeachersql {
    List<Teacher> getAll();
    String findTeacher(long id);
    void add(Teacher teacher);
    boolean delete(long id);
    boolean login(long tcID,String tcpassword);
    boolean change(Teacher teacher);
    boolean setStudentGrade(long stuID,long csID,long stuGrade);
    boolean changeTeacher(String tcpassword,long tcID);
    boolean changeTeacherInformation(long tcID,String tcName,String changeSdept);
    boolean setCourse(String csName,long tcID);
    boolean changeClass(String csName,long csCredit,long csHour,String csNature,long tcID);
}
