package service;

import jwxt.Teacher;

public interface SuperTeacher {
    Teacher show(String id);
    void add(Teacher teacher);
    void delete(String id);
    void change(Teacher teacher);
}
