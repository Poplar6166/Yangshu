package service;

import jwxt.MyClass;

import java.util.List;

public interface SuperMyClasssql {
    MyClass show(Long ClassId);

    void add(MyClass myClass);

    void delete(Long Classid);
    List<MyClass> getAllclass();

    void change(MyClass myClass);
}
