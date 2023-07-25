package service.impl;
import jwxt.Teacher;
import service.SuperTeacher;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class TeacherService implements SuperTeacher {
    Map<String,Teacher> data = new HashMap<>();
    public List<Teacher> getAll(){
        return data.values().stream().toList();
    }
    public Teacher show(String id){
        return data.get(id);
    }
    public void add(Teacher teacher){
        data.put(teacher.getTeacherId(),teacher);
    }
    public void delete(String id){
        data.remove(id);
    }
    public void change(Teacher teacher){
        data.put(teacher.getTeacherId(),teacher);
    }
}
