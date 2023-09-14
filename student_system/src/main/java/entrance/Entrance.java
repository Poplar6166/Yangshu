package entrance;
import jwxt.Manager;
import jwxt.Teacher;
import service.SuperStudentsql;

import service.mysql.ManagersqlService;
import service.mysql.StudentsqlService;
import jwxt.Student;
import service.mysql.TeachersqlService;

import java.util.List;
import java.util.Scanner;

public class Entrance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*SuperStudentsql studentService = new StudentsqlService();
        SuperTeachersql teacherService = new TeachersqlService();
        SuperManagersql managerService = new ManagersqlService();*/

        while (true) {
            System.out.println("\uD83D\uDE18 " + "欢迎来到教务管理系统 : ");
            System.out.println("\uD83D\uDE0E" + "以下是教务系统的各个端口 :");
            System.out.println("当您选择 0 : 离开教务管理系统");
            System.out.println("当您选择 1 : 学生端");
            System.out.println("当您选择 2 : 教师端");
            System.out.println("当您选择 3 : 教务处管理端");
            System.out.println("\uD83E\uDD14" + "请选择你要进入的端口 : ");
            int choise = scanner.nextInt();
            SuperStudentsql studentService = new StudentsqlService();
            StudentEntrance studentEntrance = new StudentEntrance();
            TeacherEntrance teacherEntrance = new TeacherEntrance();
            ManagerEntrance managerEntrance = new ManagerEntrance();
            TeachersqlService teacherService = new TeachersqlService();
            ManagersqlService managerService = new ManagersqlService();
            switch (choise) {
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
                        System.out.println("账号或密码输入不正确,请重新输入");
                        break;
                    }
                    System.out.println("选项 0 : 查看你的成绩");
                    System.out.println("选项 1 : 查看你的信息");
                    System.out.println("选项 2 : 修改你的密码");
                    System.out.println("选项 3 : 查看所有课程");
                    System.out.println("选项 4 : 选择你想学习的课程");
                    System.out.println("选项 5 : 修改你的信息(仅支持修改密码，身份证和户口所在地)");
                    System.out.println("其他选项 : 退出系统");
                    System.out.println("请输入你需要的操作 : ");
                    switch (scanner.nextInt()){
                        case 0 :
                            studentEntrance.showgrade(stuid);
                            break;
                        case 1 :
                            studentEntrance.studentimformation(stuid);
                            break;
                        case 2:
                            studentEntrance.changepassword(stuid);
                            break;
                        case 3:
                            studentEntrance.showAllCourse();
                            break;
                        case 4:
                            System.out.println("请输入您想选择的课程号: ");
                            long csid = scanner.nextLong();
                            studentEntrance.selectCourse(csid,stuid);
                            break;
                        case 5 :
                            System.out.println("请输入你的身份证号: ");
                            long stuIDcard = scanner.nextLong();
                            System.out.println("请输入你的户口所在地: ");
                            String Address = scanner.nextLine();
                            studentEntrance.changeStudentinformation(stuIDcard,Address,stuid);
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
                        System.out.println("账号或密码输入不正确,请重新输入");
                        break;
                    }
                    System.out.println("选项 0 : 查看您的信息");
                    System.out.println("选项 1 : 查看您的学生信息");
                    System.out.println("选项 2 : 添加学生的成绩");
                    System.out.println("选项 3 : 修改您的密码");
                    System.out.println("选项 4 : 添加课程");
                    System.out.println("选项 5 : 修改课程");
                    /*System.out.println("选项 6 : 查看您课程的学生信息");*/
                    System.out.println("其他选项 : 退出系统");
                    System.out.println("请输入你需要的操作 : ");
                    switch (scanner.nextInt()){
                        case 0:
                            teacherEntrance.showTeacherinformation(tcid);
                            break;
                        case 1:
                            teacherEntrance.showTeacherstudent(tcid);
                            break;
                        case 2:
                            System.out.println("请输入您需要添加成绩的学生的学号: ");/*这里认为老师只能知道自己教的学生的学号，因此无需再匹配课程号*/
                            long stuID = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println("请输入您需要添加成绩的学生的课程号: ");
                            long csID = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println("请输入他的成绩(请手下留情!)");
                            long stugrade = scanner.nextLong();
                            teacherEntrance.changeGrade(stuID,csID,stugrade);
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
                        case 4:
                            System.out.println("请输入你需要添加的课程的名字: ");
                            teacherEntrance.setClass(tcid,scanner.nextLine());
                            scanner.nextLine();
                        case 5:
                            System.out.println("请输入你需要修改的课程的名字: ");
                            String csName = scanner.nextLine();
                            System.out.println("请输入课程学分: ");
                            long csCredit = scanner.nextLong();
                            System.out.println("请输入课程学时: ");
                            long csHour = scanner.nextLong();
                            System.out.println("请输入课程性质: ");
                            String csNature = scanner.nextLine();
                            teacherEntrance.changeClass(tcid,csName,csCredit,csHour,csNature);
                            break;
                        case 6:
                            System.out.println("请输入课程ID");
                            long classID = scanner.nextLong();
                            teacherEntrance.findMyClass(classID);
                            break;
                        default:
                            break;
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
                        System.out.println("账号或密码输入不正确,请重新输入");
                        break;
                    }
                    System.out.println("选项 0 : 修改学生信息(增删改查)");
                    System.out.println("选项 1 : 修改老师信息(增删改查)");
                    System.out.println("选项 2 : 查看您的信息");
                    System.out.println("选项 3 : 修改您的密码");
                    System.out.println("选项 4 : 修改课程信息");
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
                                    System.out.println("请输入需要添加的学生所在的系: ");
                                    String stuDept = scanner.nextLine();
                                    System.out.println("请输入需要添加的学生所在的班级: ");
                                    String stuClass = scanner.nextLine();
                                    student.addStudent(stuDept,stuClass);
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
                                    System.out.println("请输入您想查找的学生信息的学生ID: ");
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
                                    System.out.println("请输入教师所在的系: ");
                                    String sdept = scanner.nextLine();
                                    teacher.setTeacher(tcID,tcName,sdept);
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
                            break;
                        case 4:

                            break;
                        default:
                            break;
                    }
                    if (choise == 0)
                        break;

            }

        }
    }
}
