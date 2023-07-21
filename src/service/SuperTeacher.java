package service;

import jwxt.Teacher;

import java.util.Date;

interface SuperTeacher {
    Teacher show(String id);
    void add(Teacher teacher);
    void delete(String id);
    void change(Teacher teacher);
}
