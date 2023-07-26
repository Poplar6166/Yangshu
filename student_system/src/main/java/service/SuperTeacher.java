package service;

import jwxt.Teacher;

import java.util.List;

public interface SuperTeacher {
    List<Teacher> getAll();
    Teacher show(long id);
    void add(Teacher teacher);
    boolean delete(long id);
    boolean change(Teacher teacher);
}
