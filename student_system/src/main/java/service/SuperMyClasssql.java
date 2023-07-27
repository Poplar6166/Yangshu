package service;

import jwxt.MyClass;

public interface SuperMyClasssql {
    MyClass show(Long ClassId);

    void add(MyClass myClass);

    void delete(Long Classid);

    void change(MyClass myClass);
}
