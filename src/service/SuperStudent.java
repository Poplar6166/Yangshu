package service;

import jwxt.Student;

import javax.swing.text.TabSet;
import java.util.Date;

interface SuperStudent {

    Student show(String stuId);
    void add(Student student);
    void delete(String stuId);
    void change(Student student);
}
