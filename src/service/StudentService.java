package service;

import jwxt.Student;
import jwxt.Teacher;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements SuperStudent{
    Map<String, Student> data = new HashMap<>();
    public List<Student> getAll(){
        return data.values().stream().toList();
    }
    public Student show(String stuId){
        return data.get(stuId);
    }
    public void add(Student student){
        data.put(student.getStudentId(),student);
    }
    public void delete(String stuId){
        data.remove(stuId);
    }
    public void change(Student student){
        data.put(student.getStudentId(),student);
    }
}
