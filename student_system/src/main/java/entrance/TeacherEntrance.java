package entrance;

import jwxt.Student;
import jwxt.Teacher;
import service.mysql.StudentsqlService;
import service.mysql.TeachersqlService;

import java.util.List;
import java.util.Scanner;

public class TeacherEntrance {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TeachersqlService teacherService = new TeachersqlService();
        StudentsqlService studentService = new StudentsqlService();
        Teacher tclogin = new Teacher();
        System.out.println("请输入您的账号(教师编号) : ");
        long tcid = scanner.nextLong();
        scanner.nextLine();
        System.out.println("请输入您的密码(初始密码为123456) : ");
        String tcpassword = scanner.nextLine();
        tclogin.loginTeacher(tcid,tcpassword);
        if(teacherService.login(tclogin.getTeacherId(), tclogin.getTeacherPassword())){
            System.out.println("登录成功,请继续操作: ");
        }else {
            System.out.println("账号或密码输入不正确,请重新输入: ");
        }
        System.out.println("选项 0 : 查看您的信息");
        System.out.println("选项 1 : 查看您的学生信息");
        System.out.println("选项 2 : 添加学生的成绩");
        System.out.println("选项 3 : 修改密码");
        System.out.println("其他选项 : 退出系统");
        System.out.println("请输入你需要的操作 : ");
        switch (scanner.nextInt()){
            case 0:
                String teacherinformation = teacherService.findTeacher(tcid);
                System.out.println(teacherinformation);
                break;
            case 1:
                List<Student> student = studentService.getStudent(tcid);
                for(Student students : student)
                    System.out.println("学生学号: " + students.getStuID() + " ,学生姓名: " +
                            students.getStuName() + " ,学生班级: " +  students.getstuClass());
                break;
            case 2:
                System.out.println("请输入您需要添加成绩的学生的学号: ");
                long stuID = scanner.nextLong();
                scanner.nextLine();
                System.out.println("请输入他的成绩(请手下留情!)");
                long stugrade = scanner.nextLong();
                if(teacherService.setStudentGrade(stuID,stugrade)){
                    System.out.println("添加成功!");
                }else {
                    System.out.println("添加失败,请确认是否正确输入学号");
                }
                scanner.nextLine();
                break;
            case 3:
                scanner.nextLine();
                System.out.println("请输入你新的密码");
                if(teacherService.changeTeacher(scanner.nextLine(),tcid)){
                    System.out.println("修改成功!");
                }else {
                    System.out.println("修改失败!");
                }
                break;
            default:
                return;
        }
    }
}
