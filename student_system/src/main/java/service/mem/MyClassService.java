package service.mem;

import jwxt.MyClass;
import service.SuperMyClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClassService implements SuperMyClass {
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
