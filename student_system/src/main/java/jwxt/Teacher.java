package jwxt;

import java.util.*;

public class Teacher {
    private long TeacherId;
    private String TeacherName;
    private int TeacherAge;
    private String TeacherSex;
    private Date TeacherYear;
    private String TeacherPhone;
    private String TeacherBumen;
    private void setInformation(long teacherid, String name, int age, String sex,
                                Date year, String phone,String bumen){
        this.TeacherId = teacherid;
        this.TeacherName = name;
        this.TeacherAge = age;
        this.TeacherSex = sex;
        this.TeacherYear = year;
        this.TeacherPhone = phone;
        this.TeacherBumen = bumen;
    }
    public void setTeacher(long id,String name){
        this.TeacherId = id;
        this.TeacherName = name;
    }
    public long getTeacherId() {
        return TeacherId;
    }

    public String getTeacherName() {return TeacherName;
    }

    public int getTeacherAge() {
        return TeacherAge;
    }

    public String getTeacherSex() {
        return TeacherSex;
    }

    public Date getTeacherYear() {
        return TeacherYear;
    }

    public String getTeacherPhone() {
        return TeacherPhone;
    }

    public String getTeacherBumen() {
        return TeacherBumen;
    }
    /*ArrayList<String> TeacherIdList = new ArrayList<>();
    ArrayList<String> TeacherNameList = new ArrayList<>();
    ArrayList<Integer> TeacherAgeList = new ArrayList<>();
    ArrayList<String> TeacherSexList = new ArrayList<>();
    ArrayList<String> TeacherYearList = new ArrayList<>();
    ArrayList<String> TeacherPhoneList = new ArrayList<>();
    ArrayList<String> TeacherBumenList = new ArrayList<>();
    Map<String, Teacher> map = new HashMap<>();

    public void addInformation(String teacherid, String name, int age, String sex,
                               String year, String phone,String bumen) {
        TeacherIdList.add(teacherid);
        TeacherNameList.add(name);
        TeacherAgeList.add(age);
        TeacherSexList.add(sex);
        TeacherYearList.add(year);
        TeacherPhoneList.add(phone);
        TeacherBumenList.add(bumen);

        map.put(teacherid, this); // 使用 classId 作为键，将当前对象存储到 map 中
    }

    public void show() {
        for (Map.Entry<String, Teacher> entry : map.entrySet()) {
            String key = entry.getKey();
            Teacher value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value.toString());
        }
    }

    @Override
    public String toString() {
        return  " TeacherIdList = " + TeacherIdList +
                ", TeacherNameList = " + TeacherNameList +
                ", TeacherAgeList = " + TeacherAgeList +
                ", TeacherSexList = " + TeacherSexList +
                ", TeacherYearList = " + TeacherYearList +
                ", TeacherPhoneList = " + TeacherPhoneList +
                ", TeacherBumenList = " + TeacherBumenList;
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.addInformation("212131", "刘", 22,
                "男", "2021","12332123","数据");
        teacher.show();
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