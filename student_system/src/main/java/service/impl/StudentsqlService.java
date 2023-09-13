package service.impl;

import jwxt.Student;
import service.SuperStudentsql;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsqlService implements SuperStudentsql {
    Map<Long, Student> data = new HashMap<>();
    public List<Student> getGrade(Long stuID){
        return null;
    }
    public boolean changeStudent(String password,long id){
        return false;
    }
    public List<Student> getAll(){
        return data.values().stream().toList();
    }
    public boolean selectCourse(long scID,long stuID,long csID,long tcID){
        return false;
    }
    public Student show(long stuID){
        return data.get(stuID);
    }
    public void add(Student student){
        data.put(student.getStuID(),student);
    }

    @Override
    public boolean studentDelete(long stuID) {
        return false;
    }
    public List<Student> getStudent(long tcID){
        return null;
    }

    public String findStudent(long stuID) {
        return null;
    }

    public boolean delete(long stuID){
        if(data.remove(stuID) == null){
            return false;
        }
        else
            return true;
    }
    public void change(Student student){
        data.put(student.getStuID(),student);
    }
    public void addStudent(long stuID, String name, int age, String sex,Date year,
                           String phone,String bumen,String sushe,String banji,String bandaoshi) {
        Student student = new Student(stuID, name, age, sex,year,phone,bumen,sushe,banji,bandaoshi);
        add(student);
    }
    public boolean login(long stuID,String password){
        return false;
    }
    public boolean changeStudentInformation(long stuID,String stuName,String stuClass){
        return false;
    }
}
