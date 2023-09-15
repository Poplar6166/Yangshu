package entrance;

import jwxt.MyClass;
import jwxt.Student;
import service.mysql.StudentsqlService;

import java.security.PublicKey;
import java.util.List;
import java.util.Scanner;


public class StudentEntrance {
    StudentsqlService studentService = new StudentsqlService();
    Scanner scanner = new Scanner(System.in);
    public void showgrade(long stuid){
        List<Student> studentgrade = studentService.getGrade(stuid);
        for(Student studentGrade : studentgrade)
            System.out.println("课程号为: " + studentGrade.getcsID() + " ,成绩为: " + studentGrade.getStuGrade());
    }
    public void studentimformation(long stuid){
        String studentinformation = studentService.findStudent(stuid);
        System.out.println(studentinformation);
    }
    public void changepassword(long stuid){
        scanner.nextLine();
        System.out.println("请输入你的新密码: ");
        if(studentService.changeStudent(scanner.nextLine(),stuid)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败！");
        }
    }
    public void showAllCourse(){
        /*System.out.println(studentService.getAllclass());*/
        for (MyClass myClass : studentService.getAllclass()) {
            System.out.println(myClass);
        }
    }
    public void selectCourse(long csid,long stuID,long tcid){
        if(studentService.seletcCourse(csid,stuID,tcid)){
            System.out.println("选课成功！");
        }else{
            System.out.println("选课失败，可能因为这个课程未开放");
        }
    }
    public void changeStudentinformation(long IDcard,String Address,long stuID){
        if(studentService.changeStudentinformation(IDcard,Address,stuID)){
            System.out.println("修改成功");
        }else {
            System.out.println("出于某种原因,修改失败!");
        }
    }
    public void findStatus(long stuid){
        studentService.findStatus(stuid);
    }
    public void findEmail(long stuid){
        for (Student student : studentService.findEmail(stuid)) {
            System.out.println(student.getStudentNews());
        }
    }
    public void sentParents(){
        for (Student student : studentService.get_All_Student_Grade()) {
            System.out.println(student);
        }
    }
}
