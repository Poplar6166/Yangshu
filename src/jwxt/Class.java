package jwxt;

import java.util.ArrayList;

public class Class {
    public static void main(String[] args) {
        ArrayList<String> stu_id = new ArrayList<String>();
        ArrayList<String> name = new ArrayList<String>();
        stu_id.add("3210411111");
        stu_id.add("3210422222");
        name.add("jack");
        name.add("pick");
        System.out.println(name);
        System.out.println(stu_id);
        String firstName = name.get(0);
        String firstStu_id = stu_id.get(0);
        System.out.println("第一个名字和学号是: " + firstStu_id + " " + firstName);
        name.remove(1);
        stu_id.remove(1);
        System.out.println("删除第二个位置以后剩下的名字: " + stu_id);
        System.out.println("删除第二个位置以后剩下的学号: " + name);
        int size = name.size();
        int size1 = stu_id.size();
        System.out.println("姓名列表大小为: " + size + " ,学号列表大小为 : " + stu_id);
    }
}
