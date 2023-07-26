package service.impl;
import jwxt.Teacher;
import service.SuperTeachersql;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class TeachersqlService implements SuperTeachersql {
    Map<Long, Teacher> data = new HashMap<>();
    public List<Teacher> getAll(){
        return data.values().stream().toList();
    }
    public Teacher show(String id){
        return data.get(id);
    }

    @Override
    public Teacher findTeacher(long id) {
        return null;
    }

    public void add(Teacher teacher){
        data.put(teacher.getTeacherId(),teacher);
    }
    public boolean delete(long id){
        return false;
    }
    public boolean change(Teacher teacher){
        return false;
    }
}
