package entrance;

import jwxt.Manager;
import jwxt.Student;
import jwxt.Teacher;
import service.SuperStudentsql;
import service.mysql.ManagersqlService;
import service.mysql.StudentsqlService;
import service.mysql.TeachersqlService;

import java.util.Scanner;

public class ManagerEntrance {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ManagersqlService managerService = new ManagersqlService();
        SuperStudentsql studentService = new StudentsqlService();
        TeachersqlService teacherService = new TeachersqlService();
        Manager mglogin = new Manager();
        System.out.println("请输入您的账号(管理员编号) : ");
        long mgid = scanner.nextLong();
        scanner.nextLine();
        System.out.println("请输入您的密码(初始密码为123456) : ");
        String mgpassword = scanner.nextLine();
        mglogin.loginManager(mgid,mgpassword);
        if(managerService.login(mglogin.getManagerId(), mglogin.getManagerPassword())){
            System.out.println("登录成功,请继续操作: ");
        }else {
            System.out.println("账号或密码输入不正确,请重新输入: ");
        }
        System.out.println("选项 0 : 修改学生信息(增删改查)");
        System.out.println("选项 1 : 修改老师信息(增删改查)");
        System.out.println("选项 2 : 查看您的信息");
        System.out.println("选项 3 : 修改您的密码");
        System.out.println("其他选项 : 退出系统");
        System.out.println("请输入您的选择 : ");
        switch (scanner.nextInt()){
            case 0:
                System.out.println("选项 1 : 添加学生信息");
                System.out.println("选项 2 : 删除学生信息");
                System.out.println("选项 3 : 修改学生信息");
                System.out.println("选项 4 : 查询学生信息");
                System.out.println("其他选项 : 返回上一步");
                System.out.println("请输入您的选择 : ");
                Student student = new Student();
                switch (scanner.nextInt()){
                    case 1:
                        System.out.println("请输入需要添加的学生的ID: ");
                        long stuID = scanner.nextLong();
                        scanner.nextLine();
                        System.out.println("请输入学生的姓名: ");
                        String stuName = scanner.nextLine();
                        System.out.println("请输入学生的班级: ");
                        String stuClass = scanner.nextLine();
                        student.setStudnet(stuID,stuName,stuClass);
                        studentService.add(student);
                        break;
                    case 2:
                        System.out.println("请输入需要删除的学生信息的ID: ");
                        long deletestuID = scanner.nextLong();
                        scanner.nextLine();
                        if(studentService.studentDelete(deletestuID)){
                            System.out.println("删除成功!");
                        }else{
                            System.out.println("删除失败,请确认输入的学号是否正确");
                        }
                        break;
                    case 3:
                        System.out.println("请输入需要修改的学生信息的ID: ");
                        Long changestuID = scanner.nextLong();
                        scanner.nextLine();
                        System.out.println("请输入新的学生姓名: ");
                        String changestuName = scanner.nextLine();
                        System.out.println("请输入新的学生班级: ");
                        String changestuClass = scanner.nextLine();
                        if(studentService.changeStudentInformation(changestuID,changestuName,changestuClass)){
                            System.out.println("修改成功!");
                        }else {
                            System.out.println("修改失败,请重新确认输入的学号是否正确");
                        }
                        break;
                    case 4:
                        System.out.println("请输入需要查找的学生的信息: ");
                        long findstuID = scanner.nextLong();
                        String showstudent = studentService.findStudent(findstuID);
                        System.out.println(showstudent);
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                System.out.println("选项 1 : 添加教师信息");
                System.out.println("选项 2 : 删除教师信息");
                System.out.println("选项 3 : 修改教师信息");
                System.out.println("选项 4 : 查询教师信息");
                System.out.println("其他选项 : 返回上一步");
                System.out.println("请输入您的选择 : ");
                Teacher teacher = new Teacher();
                switch (scanner.nextInt()){
                    case 1:
                        System.out.println("请输入教师的ID: ");
                        long tcID = scanner.nextLong();
                        scanner.nextLine();
                        System.out.println("请输入教师的姓名: ");
                        String tcName = scanner.nextLine();
                        teacher.setTeacher(tcID,tcName);
                        teacherService.add(teacher);
                        break;
                    case 2:
                        System.out.println("请输入需要删除的教师信息的ID: ");
                        long deletetcID = scanner.nextLong();
                        scanner.nextLine();
                        if(teacherService.delete(deletetcID)){
                            System.out.println("删除成功!");
                        }else{
                            System.out.println("删除失败,请确认输入的教师号是否正确");
                        }
                        break;
                    case 3:
                        System.out.println("请输入需要修改的教师信息的ID: ");
                        Long changetcID = scanner.nextLong();
                        scanner.nextLine();
                        System.out.println("请输入新的教师姓名: ");
                        String changetcName = scanner.nextLine();
                        if(teacherService.changeTeacherInformation(changetcID,changetcName)){
                            System.out.println("修改成功!");
                        }else {
                            System.out.println("修改失败,请重新确认输入的教师号是否正确");
                        }
                        break;
                    case 4:
                        System.out.println("请输入需要查找的教师的信息: ");
                        long findtcID = scanner.nextLong();
                        scanner.nextLine();
                        String showteacher = teacherService.findTeacher(findtcID);
                        System.out.println(showteacher);
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                String managerInformation = managerService.findManager(mgid);
                System.out.println(managerInformation);
                break;
            case 3:
                scanner.nextLine();
                System.out.println("请输入你新的密码");
                managerService.changeManager(scanner.nextLine(),mgid);
                return Entrance;
            default:
                break;
        }
    }
}
