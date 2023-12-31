package jwxt;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClass {
    private Long classId;
    private String className;
    private String sc;
    private Long studentId;
    private Long teacherId;
    private long CourseCredit;

    private long CourseHour;
    private String CourseNature;
    private String ifopen;
    private void setInformation(Long classId,String className,String sc,Long studentId,Long teacherId){
        this.classId = classId;
        this.className = className;
        this.sc = sc;
        this.studentId = studentId;
        this.teacherId = teacherId;
    }
    public void setAllClass(Long csID,String csName, Long tcID,long csCredit,long csHour,String csNature,String IFOPEN){
        this.classId = csID;
        this.className = csName;
        this.teacherId = tcID;
        this.CourseCredit = csCredit;
        this.CourseHour = csHour;
        this.CourseNature = csNature;
        this.ifopen = IFOPEN;
    }
    public void setClass(long csID,String csName,long tcID,String ifopen){
        this.classId = csID;
        this.className = csName;
        this.teacherId = tcID;
        this.ifopen = ifopen;
    }
    public Long getClassId() {
        return classId;
    }
    public long getCourseCredit(){return CourseCredit;}

    public String getClassName() {
        return className;
    }

    public String getSc() {
        return sc;
    }

    public Long getStudentId() {
        return studentId;
    }
    public long getCourseHour(){return CourseHour;}
    public String getCourseNature(){return CourseNature;}
    public String getIfopen(){return ifopen;}

    public Long getTeacherId() {
        return teacherId;
    }
    /*ArrayList<String> ClassIdList = new ArrayList<>();
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

    }
    */
}