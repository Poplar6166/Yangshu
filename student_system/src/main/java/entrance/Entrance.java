package entrance;
import jwxt.*;
import service.SuperStudent;
import service.SuperTeacher;
import service.mysql.StudentService;
import service.mysql.TeacherService;

import java.sql.*;
import java.util.List;
import java.util.*;
import java.util.Scanner;

public class Entrance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SuperStudent studentService = new StudentService();
        SuperTeacher teacherService = new TeacherService();


        while(true) {
            System.out.println("\uD83D\uDE18 " + "welcome to jwxt : ");
            System.out.println("\uD83D\uDE0E" + "There are several options here :");
            System.out.println("choise 0 : Leave system");
            System.out.println("choise 1 : Student end");
            System.out.println("choise 2 : Manager end");
            System.out.println("choise 3 : Teacher end");
            System.out.println("\uD83E\uDD14" + "please input your choise : ");
            int choise = scanner.nextInt();
            switch (choise){
                case 1:
                    System.out.println("choise 0 : add your information");
                    System.out.println("choise 1 : print all students information");
                    System.out.println("choise 2 : change your information");
                    System.out.println("choise 3 : delete your information");
                    System.out.println("choise 4 : show your information");
                    System.out.println("请输入你需要的操作 : ");
                    switch (scanner.nextInt()){
                        case 0 :
                            final Student student = new Student();
                            System.out.println("请输入学生ID: ");
                            student.setStudentId(scanner.nextInt());
                            System.out.println("请输入姓名: ");
                            student.setStudentName(scanner.next());
                            studentService.add(student);
                            System.out.println("添加成功！");
                            break;
                        /*System.out.println("请输入年龄: ");
                        int age = scanner.nextInt();
                        System.out.println("请输入性别: ");
                        String sex = scanner.next();
                        System.out.println("请输入入学日期（格式为yyyy-MM-dd）: ");
                        Date year = null;
                        String dateString = scanner.nextLine();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            year = dateFormat.parse(dateString);
                            System.out.println("日期是： " + year);
                        } catch (ParseException e) {
                            System.out.println("日期格式不正确");
                        }

                        System.out.println("请输入电话号码: ");
                        String phone = scanner.next();
                        System.out.println("请输入所属部门: ");
                        String bumen = scanner.next();
                        System.out.println("请输入宿舍号: ");
                        String sushe = scanner.next();
                        System.out.println("请输入班级: ");
                        String banji = scanner.next();
                        System.out.println("请输入班导师: ");
                        String bandaoshi = scanner.next();
                        */
                        case 1 :
                            StudentService studentshow = new StudentService();
                            studentshow.showStudent();
                            break;
                        case 2:
                            Student student1 = new Student();
                            System.out.println("请输入要修改的学生ID: ");
                            student1.setStudentId(scanner.nextInt());
                            System.out.println("请输入要修改的姓名: ");
                            student1.setStudentName(scanner.next());
                            if(studentService.changeStudent(student1)){
                                System.out.println("修改成功");//修改后的结果
                            }else {
                                System.out.println("ID不正确!");
                            }

                            break;
                        case 3:
                            Student student2 = new Student();
                            System.out.println("请输入要删除的学生ID");
                            student2.setStudentId(scanner.nextLong());//是否删除成功
                            if(studentService.studentdelete(student2.getStudentId())){
                                System.out.println("删除成功！");
                            }else {
                                System.out.println("查无此人!");
                            }
                            break;
                        case 4:
                            Student student3 = new Student();
                            System.out.println("请输入要显示的学生ID");
                            student3.setStudentId(scanner.nextLong());
                            String s = studentService.findStudent(student3.getStudentId());
                            System.out.println(s);
                            break;
                        default:
                            break;
                    }

                case 2:
                    System.out.println("choise 0 : add your information");
                    System.out.println("choise 1 : find your information");
                    System.out.println("choise 2 : show all information");
                    System.out.println("choise 3 : change your information");
                    System.out.println("choise 4 : delete your information");
                    System.out.println("请输入你需要的操作 : ");
                    switch (scanner.nextInt()){
                        case 0:
                            Teacher addteacher = new Teacher();
                            System.out.println("请输入您的ID: ");
                            long id = scanner.nextLong();
                            System.out.println("请输入您的名字: ");
                            String name = scanner.nextLine();
                            addteacher.setTeacher(id,name);
                            teacherService.add(addteacher);
                            break;
                        case 1:
                            System.out.println("请输入该老师的ID: ");
                            Teacher teacher = teacherService.show(scanner.nextLong());
                            if(teacher == null)
                                System.out.println("没有找到该ID老师的信息");
                            else {
                                System.out.println("该老师的ID为:" + teacher.getTeacherId() + "该老师的姓名为" + teacher.getTeacherName());
                            }
                            break;
                        case 2:
                            teacherService.getAll();
                            break;
                        case 3:
                            Teacher changeteacher = new Teacher();
                            System.out.println("请输入需要修改的老师的ID: ");
                            long teacherID = scanner.nextLong();
                            System.out.println("请输入要修改的老师的名字: ");
                            String teacherName = scanner.nextLine();
                            changeteacher.setTeacher(teacherID,teacherName);
                            if(teacherService.change(changeteacher))
                                System.out.println("修改成功!");
                            else
                                System.out.println("修改失败!");
                            break;
                        case 4:
                            System.out.println("请输入需要删除的老师的ID: ");
                            if(teacherService.delete(scanner.nextLong()))
                               System.out.println("删除成功!");
                            else
                                System.out.println("删除失败!");
                            break;
                        default:
                            break;
                    }
                /*case 2:
                    System.out.println("choise 0 : 对教务处人员进行操作");
                    System.out.println("choise 1 : 对教师进行操作");
                    System.out.println("chiose 2 : 对学生进行操作进行操作");
                    System.out.println("请输入你需要的操作 : ");
                    switch (scanner.nextInt()){
                        case 0:
                            System.out.println("choise 0 : add your information");
                            System.out.println("choise 1 : show your information");
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
