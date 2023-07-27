package jwxt;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private long studentId;
    private String studentName;
    private int studentAge;
    private String studentSex;
    private Date studentYear;
    private String studentPhone;
    private String studentBumen;
    private String studentSushe;
    private String studentBanji;
    private String studentBandaoshi;
    private String studentPassword;
    private long csID;
    private long stuGrade;
    private String studentClass;

    public Student(long studentId, String name, int age, String sex, Date year,
                   String phone, String bumen, String sushe, String banji, String bandaoshi){
        this.studentId = studentId;
        this.studentName = name;
        this.studentAge = age;
        this.studentSex = sex;
        this.studentYear = year;
        this.studentPhone = phone;
        this.studentBumen = bumen;
        this.studentSushe = sushe;
        this.studentBanji = banji;
        this.studentBandaoshi = bandaoshi;
    }

    public Student() {

    }
    public void setStudnet(long stuID,String stuPassword,String stuClass){
        this.studentId = stuID;
        this.studentPassword = stuPassword;
        this.studentClass = stuClass;
    }
    public void changepassword(String studentPassword){
        this.studentPassword = studentPassword;
    }
    public void loginStudent(long stuID,String studentPassword){
        this.studentId = stuID;
        this.studentPassword = studentPassword;
    }
    public void setGrade(long csID,long stuGrade){
        this.csID = csID;
        this.stuGrade = stuGrade;
    }

    public long getcsID() {
        return csID;
    }
    public String getstuClass(){
        return studentClass;
    }

    public long getStuGrade() {
        return stuGrade;
    }

    public String getStudentPassword(){
        return studentPassword;
    }
    public void setStudentId(long stuID) {
        this.studentId = stuID;
    }

    public void setStudentName(String stuName) {
        this.studentName = stuName;
    }

    public long getStuID() {
        return studentId;
    }

    public String getStuName() {
        return studentName;
    }

    /*public int getStudentAge() {
        return studentAge;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public Date getStudentYear() {
        return studentYear;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public String getStudentBumen() {
        return studentBumen;
    }

    public String getStudentSushe() {
        return studentSushe;
    }

    public String getStudentBanji() {
        return studentBanji;
    }

    public String getStudentBandaoshi() {
        return studentBandaoshi;
    }

    @Override
    public String toString() {
        return studentId + studentName;
    }
    */
    /*
    ArrayList<String> StudentIdList = new ArrayList<>();
    ArrayList<String> StudentNameList = new ArrayList<>();
    ArrayList<Integer> StudentAgeList = new ArrayList<Integer>();
    ArrayList<String> StudentSexList = new ArrayList<>();
    ArrayList<String> StudentYearList = new ArrayList<>();
    ArrayList<String> StudentPhoneList = new ArrayList<>();
    ArrayList<String> StudentBumenList = new ArrayList<>();
    ArrayList<String> StudentSusheList = new ArrayList<>();
    ArrayList<String> StudentBanjiList = new ArrayList<>();
    ArrayList<String> StudentBandaoshiList = new ArrayList<>();
    ArrayList<String> TeacherIdList = new ArrayList<>();

    Map<String, Student> map = new HashMap<>();

    public void addInformation(String studentId, String name, int age, String sex,String year,
                               String phone,String bumen,String sushe,String banji,String bandaoshi) {
        StudentIdList.add(studentId);
        StudentNameList.add(name);
        StudentAgeList.add(age);
        StudentSexList.add(sex);
        StudentYearList.add(year);
        StudentPhoneList.add(phone);
        StudentBumenList.add(bumen);
        StudentSusheList.add(sushe);
        StudentBanjiList.add(banji);
        StudentBandaoshiList.add(bandaoshi);

        map.put(studentId, this); // 使用 classId 作为键，将当前对象存储到 map 中
    }

    public void show() {
        for (Map.Entry<String, Student> entry : map.entrySet()) {
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value.toString());
        }
    }

    @Override
    public String toString() {
        return "StudentIdList=" + StudentIdList +
                ", StudentNameList=" + StudentNameList +
                ", StudentAgeList=" + StudentAgeList +
                ", StudentSexList=" + StudentSexList +
                ", StudentYearList=" + StudentYearList +
                ", StudentPhoneList=" + StudentPhoneList +
                ", StudentBumenList=" + StudentBumenList+
                ", StudentSusheList=" + StudentSusheList+
                ", StudentBanjiList=" + StudentBanjiList+
                ", StudentBandaoshiList" + StudentBandaoshiList;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.addInformation("3210411029", "贺", 1, "男",
                "2021","213131","数据"
                ,"22楼","信计211","刘");
        student.show();
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