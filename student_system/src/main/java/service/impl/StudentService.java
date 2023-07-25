package service.impl;

import jwxt.Student;
import service.SuperStudent;

import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements SuperStudent {
    Map<Long, Student> data = new HashMap<>();
    public List<Student> getAll(){
        return data.values().stream().toList();
    }
    public Student show(long stuId){
        return data.get(stuId);
    }
    public void add(Student student){
        data.put(student.getStudentId(),student);
    }
    public boolean delete(long stuId){
        if(data.remove(stuId) == null){
            return false;
        }
        else
            return true;
    }
    public boolean changeStudent(Student student){
        return false;
    }

    @Override
    public boolean findStudent(long studentId) {
        return false;
    }

    public void change(Student student){
        data.put(student.getStudentId(),student);
    }
    public void addStudent(long studentId, String name, int age, String sex,Date year,
                           String phone,String bumen,String sushe,String banji,String bandaoshi) {
        Student student = new Student(studentId, name, age, sex,year,phone,bumen,sushe,banji,bandaoshi);
        add(student);
    }
    public boolean studentdelete(long studentId){
        return false;
    }
}
