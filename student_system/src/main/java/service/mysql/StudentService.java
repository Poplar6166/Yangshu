package service.mysql;

import jwxt.Student;
import service.SuperStudent;

import java.util.Date;

public class StudentService implements SuperStudent {
    @Override
    public Student show(String stuId) {
        return null;
    }

    @Override
    public void add(Student student) {

    }

    @Override
    public boolean delete(String stuId) {
        return false;
    }

    @Override
    public void change(Student student) {

    }

    @Override
    public void addStudent(String studentId, String name, int age, String sex, Date year, String phone, String bumen, String sushe, String banji, String bandaoshi) {

    }
}
