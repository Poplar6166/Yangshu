package entrance;

import jwxt.Student;
import service.mysql.StudentsqlService;

import java.util.List;
import java.util.Scanner;


public class StudentEntrance {
    StudentsqlService studentService = new StudentsqlService();
    Scanner scanner = new Scanner(System.in);
    public void showgrade(long stuid){

        List<Student> studentgrade = studentService.getGrade(stuid);
        for(Student studentGrade : studentgrade)
            System.out.println("课程号为: " + studentGrade.getcsID() + " ,成绩为: " + studentGrade.getStuGrade());
        return;
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

}
