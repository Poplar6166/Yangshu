package jwxt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyClass {
    ArrayList<String> ClassIdList = new ArrayList<>();
    ArrayList<String> NameList = new ArrayList<>();
    ArrayList<String> ScList = new ArrayList<>();
    ArrayList<String> StudentIdList = new ArrayList<>();
    ArrayList<String> TeacherIdList = new ArrayList<>();

    Map<String, MyClass> map = new HashMap<String, MyClass>();

    public void addInformation(String classId, String nameId, String sc, String studentId, String teacherId) {
        ClassIdList.add(classId);
        NameList.add(nameId);
        ScList.add(sc);
        StudentIdList.add(studentId);
        TeacherIdList.add(teacherId);

        map.put(classId, this); // 使用 classId 作为键，将当前对象存储到 map 中
    }

    public void show() {
        for (Map.Entry<String, MyClass> entry : map.entrySet()) {
            String key = entry.getKey();
            MyClass value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value.toString());
        }
    }

    @Override
    public String toString() {
        return "ClassIdList=" + ClassIdList +
                ", NameList=" + NameList +
                ", ScList=" + ScList +
                ", StudentIdList=" + StudentIdList +
                ", TeacherIdList=" + TeacherIdList ;
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.addInformation("211", "信计211", "信息与计算科学", "贺", "刘");
        myClass.show();
        /*ArrayList<String> stuIdList = new ArrayList<String>();
        ArrayList<String> nameList = new ArrayList<String>();
        stuIdList.add("3210411111");
        stuIdList.add("3210422222");
        nameList.add("jack");
        nameList.add("pick");
        System.out.println(nameList);
        System.out.println(stuIdList);
        String firstName = nameList.get(0);
        String firstStu_id = stuIdList.get(0);
        System.out.println("第一个名字和学号是: " + firstStu_id + " " + firstName);
        nameList.remove(1);
        stuIdList.remove(1);
        System.out.println("删除第二个位置以后剩下的名字: " + stuIdList);
        System.out.println("删除第二个位置以后剩下的学号: " + nameList);
        int size = nameList.size();
        int size1 = stuIdList.size();
        System.out.println("姓名列表大小为: " + size + " ,学号列表大小为 : " + stuIdList);
         */
    }
}