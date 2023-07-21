package service.mem;

import jwxt.Student;
import service.SuperStudent;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements SuperStudent {
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
    public boolean delete(String stuId){
        if(data.remove(stuId) == null){
            return false;
        }
        else
            return true;
    }
    public void change(Student student){
        data.put(student.getStudentId(),student);
    }
    public void addStudent(String studentId, String name, int age, String sex,Date year,
                           String phone,String bumen,String sushe,String banji,String bandaoshi) {
        Student student = new Student(studentId, name, age, sex,year,phone,bumen,sushe,banji,bandaoshi);
        add(student);
    }
}
