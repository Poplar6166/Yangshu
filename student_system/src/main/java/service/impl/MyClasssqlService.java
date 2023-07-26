package service.impl;

import jwxt.MyClass;
import service.SuperMyClasssql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClasssqlService implements SuperMyClasssql {
    Map<String, MyClass> data = new HashMap<>();
    public List<MyClass> getAll(){
        return data.values().stream().toList();
    }
    public MyClass show(String ClassId) {
        return data.get(ClassId);
    }

    public void add(MyClass myClass) {
        data.put(myClass.getClassId(),myClass);
    }

    public void delete(String Classid) {
        data.remove(Classid);
    }

    public void change(MyClass myClass) {
        data.put(myClass.getClassId(),myClass);
    }
}
