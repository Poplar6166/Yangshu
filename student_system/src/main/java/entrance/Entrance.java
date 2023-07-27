package entrance;
import jwxt.*;
import service.SuperManagersql;
import service.SuperMyClasssql;
import service.SuperStudentsql;
import service.SuperTeachersql;
import service.impl.MyClasssqlService;
import service.mysql.ManagersqlService;
import service.mysql.StudentsqlService;
import service.mysql.TeachersqlService;

import java.util.List;
import java.util.Scanner;

public class Entrance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SuperStudentsql studentService = new StudentsqlService();
        SuperTeachersql teacherService = new TeachersqlService();
        SuperManagersql managerService = new ManagersqlService();
        SuperMyClasssql myClassService = new MyClasssqlService();

        while(true) {
            System.out.println("\uD83D\uDE18 " + "welcome to jwxt : ");
            System.out.println("\uD83D\uDE0E" + "There are several options here :");
            System.out.println("choise 0 : Leave system");
            System.out.println("choise 1 : Student end");
            System.out.println("choise 2 : Teacher end");
            System.out.println("choise 3 : Manager end");
            System.out.println("\uD83E\uDD14" + "please input your choise : ");
            int choise = scanner.nextInt();
            switch (choise){
                case 1:
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
                        break;
                    }
                    System.out.println("选项 0 : 查看你的成绩");
                    System.out.println("选项 1 : 查看你的信息");
                    System.out.println("选项 2 : 修改你的密码");
                    System.out.println("其他选项 : 退出系统");
                    System.out.println("请输入你需要的操作 : ");
                    switch (scanner.nextInt()){
                        case 0 :
                            List<Student> studentgrade = studentService.getGrade();
                            for(Student studentGrade : studentgrade)
                                System.out.println("课程号为 " + studentGrade.getcsID() + " ,成绩为: " + studentGrade.getStuGrade());
                            break;
                        case 1 :
                            String studentinformation = studentService.findStudent(stuid);
                            System.out.println(studentinformation);
                            break;
                        case 2:
                            Student student = new Student();
                            System.out.println("请输入你新的密码");
                            studentService.changeStudent(scanner.nextLine(), stuid);
                            break;
                        default:
                            return;
                    }

                case 2:
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
                        break;
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
                            List<Teacher> student = teacherService.getStudent(tcid);
                            for(Teacher students : student){
                                System.out.println(students);
                            }
                            break;
                        case 2:
                            System.out.println("请输入您需要添加的学生的学号: ");
                            long stuID = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println("请输入他的成绩(请手下留情!)");
                            long stugrade = scanner.nextLong();
                            if(teacherService.setStudentGrade(stuID,stugrade)){
                                System.out.println("添加成功!");
                            }else {
                                System.out.println("添加失败,请确认是否正确输入学号");
                            }
                            break;
                        case 3:
                            Teacher teacher = new Teacher();
                            System.out.println("请输入你新的密码");
                            teacherService.changeTeacher(scanner.nextLine(),tcid);
                            break;
                        default:
                            return;
                    }
                case 3:
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
                        break;
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
                            if(scanner.nextInt() == 1){
                                System.out.println("请输入学生的ID: ");
                                long stuID = scanner.nextLong();
                                scanner.nextLine();
                                System.out.println("请输入学生的姓名: ");
                                String stuName = scanner.nextLine();
                                System.out.println("请输入学生的班级: ");
                                String stuClass = scanner.nextLine();
                                student.setStudnet(stuID,stuName,stuClass);
                                studentService.add(student);
                            } else if (scanner.nextInt() ==2) {
                                System.out.println("请输入需要删除的学生信息的ID: ");
                                long stuID = scanner.nextLong();
                                scanner.nextLine();
                                if(studentService.studentdelete(stuID)){
                                    System.out.println("删除成功!");
                                }else{
                                    System.out.println("删除失败,请确认输入的学号是否正确");
                                }
                            } else if (scanner.nextInt() == 3) {
                                    System.out.println("请输入需要修改的学生信息的ID: ");
                                    Long stuID = scanner.nextLong();
                                    scanner.nextLine();
                                    System.out.println("请输入新的学生姓名: ");
                                    String stuName = scanner.nextLine();
                                    System.out.println("请输入新的学生班级: ");
                                    String stuClass = scanner.nextLine();
                                    if(studentService.changeStudentInformation(stuID,stuName,stuClass)){
                                        System.out.println("修改成功!");
                                    }else {
                                        System.out.println("修改失败,请重新确认输入的学号是否正确");
                                    }
                            } else if (scanner.nextInt() == 4) {
                                    System.out.println("请输入需要查找的学生的信息: ");
                                    long stuID = scanner.nextLong();
                                    scanner.nextLine();
                                    String showstudent = studentService.findStudent(stuID);
                                    System.out.println(showstudent);
                            }else{
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
                            if(scanner.nextInt() == 1){
                                System.out.println("请输入教师的ID: ");
                                long tcID = scanner.nextLong();
                                scanner.nextLine();
                                System.out.println("请输入教师的姓名: ");
                                String tcName = scanner.nextLine();
                                teacher.setTeacher(tcID,tcName);
                                teacherService.add(teacher);
                            } else if (scanner.nextInt() ==2) {
                                System.out.println("请输入需要删除的教师信息的ID: ");
                                long tcID = scanner.nextLong();
                                scanner.nextLine();
                                if(teacherService.delete(tcID)){
                                    System.out.println("删除成功!");
                                }else{
                                    System.out.println("删除失败,请确认输入的教师号是否正确");
                                }
                            } else if (scanner.nextInt() == 3) {
                                System.out.println("请输入需要修改的教师信息的ID: ");
                                Long tcID = scanner.nextLong();
                                scanner.nextLine();
                                System.out.println("请输入新的教师姓名: ");
                                String tcName = scanner.nextLine();
                                if(teacherService.changeTeacherInformation(tcID,tcName)){
                                    System.out.println("修改成功!");
                                }else {
                                    System.out.println("修改失败,请重新确认输入的教师号是否正确");
                                }
                            } else if (scanner.nextInt() == 4) {
                                System.out.println("请输入需要查找的教师的信息: ");
                                long tcID = scanner.nextLong();
                                scanner.nextLine();
                                String showteacher = teacherService.findTeacher(tcID);
                                System.out.println(showteacher);
                            }else{
                                break;
                            }
                            break;
                        case 2:
                            String managerInformation = managerService.findManager(mgid);
                            System.out.println(managerInformation);
                            break;
                        case 3:
                            Manager manager = new Manager();
                            System.out.println("请输入你新的密码");
                            managerService.changeManager(scanner.nextLine(),mgid);
                            break;
                        default:
                            return;

                    }

                    /*System.out.println("choise 0 : ");
                    System.out.println("choise 1 : 对教师进行操作");
                    System.out.println("choise 2 : 对学生进行操作进行操作");
                    System.out.println("请输入你需要的操作 : ");
                    switch (scanner.nextInt()){
                        case 0:
                            System.out.println("choise 0 : add your information");
                            System.out.println("choise 1 : find your information");
                            System.out.println("choise 2 : show all information");
                            System.out.println("choise 3 : change your information");
                            System.out.println("choise 4 : delete your information");
                            System.out.println("请输入你需要的操作 : ");
                    }

                    System.out.println("choise 2 : show the student information");
                    System.out.println("choise 3 : change the student information");
                    System.out.println("choise 4 : delete the student information");
                    System.out.println("choise 4 : show the teacher information");
                    System.out.println("choise 5 : change the student information");
                    System.out.println("choise 6 : delete the student information");
                    System.out.println("choise 7 : show the class information");
                    System.out.println("choise 8 : change the class information");
                    System.out.println("choise 9 : delete the class information");
                    System.out.println("choise - : delete the class information");
                    System.out.println("请输入你需要的操作 : ");
                    */
                default:
                    break;
            }
            if(choise == 0)
                break;



        }

    }
}
