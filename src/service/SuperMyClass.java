package service;

import jwxt.Manager;
import jwxt.MyClass;
import jwxt.Teacher;

import java.util.Date;

interface SuperMyClass {
    MyClass show(String ClassId);

    void add(MyClass myClass);

    void delete(String Classid);

    void change(MyClass myClass);
}
