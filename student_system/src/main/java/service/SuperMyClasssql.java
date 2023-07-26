package service;

import jwxt.MyClass;

public interface SuperMyClasssql {
    MyClass show(String ClassId);

    void add(MyClass myClass);

    void delete(String Classid);

    void change(MyClass myClass);
}
