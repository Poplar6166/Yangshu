package service;

import jwxt.Teacher;

import java.util.List;

public interface SuperTeachersql {
    List<Teacher> getAll();
    Teacher findTeacher(long id);
    void add(Teacher teacher);
    boolean delete(long id);
    boolean change(Teacher teacher);
}
