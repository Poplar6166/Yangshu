package entrance;

import jwxt.Student;
import service.SuperStudentsql;
import service.mysql.StudentsqlService;

import java.util.List;
import java.util.Scanner;

public class StudentEntrance {
    public static void main(String[] args){
        SuperStudentsql studentService = new StudentsqlService();
        Scanner scanner = new Scanner(System.in);
        Student stulogin = new Student();
        System.out.println("请输入您的账号(学号) : ");
        long stuid = scanner.nextLong();
        scanner.nextLine();
        System.out.println("请输入您的密码(初始密码为123456) : ");
        String stupassword = scanner.nextLine();
        stulogin.loginStudent(stuid,stupassword);
        if(studentService.login(stulogin.getStuID(), stulogin.getStudentPassword())){
            System.out.println("登录成功,请继续操作: ");
        }else {
            System.out.println("账号或密码输入不正确,请重新输入: ");

        }
        System.out.println("选项 0 : 查看你的成绩");
        System.out.println("选项 1 : 查看你的信息");
        System.out.println("选项 2 : 修改你的密码");
        System.out.println("其他选项 : 退出系统");
        System.out.println("请输入你需要的操作 : ");
        switch (scanner.nextInt()){
            case 0 :
                List<Student> studentgrade = studentService.getGrade(stuid);
                for(Student studentGrade : studentgrade)
                    System.out.println("课程号为: " + studentGrade.getcsID() + " ,成绩为: " + studentGrade.getStuGrade());
                break;
            case 1 :
                String studentinformation = studentService.findStudent(stuid);
                System.out.println(studentinformation);
                break;
            case 2:
                scanner.nextLine();
                System.out.println("请输入你新的密码: ");
                if(studentService.changeStudent(scanner.nextLine(), stuid)){
                    System.out.println("修改成功!");
                }else {
                    System.out.println("修改失败!");
                }
                break;
            default:
                break;
        }

    }
}
