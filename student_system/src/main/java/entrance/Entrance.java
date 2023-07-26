package entrance;
import jwxt.*;
import service.SuperManagersql;
import service.SuperStudentsql;
import service.SuperTeachersql;
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
                    /*Student Student = new Student();
                    System.out.println("请输入您的学号: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("请输入您的密码: ");
                    long password = scanner.nextLong();
                    if(studentService.findStudent(id,password) == null){
                        System.out.println("学生账号或密码不存在");
                        break;
                    }*/
                    System.out.println("choise 0 : add your information");
                    System.out.println("choise 1 : print all students information");
                    System.out.println("choise 2 : change your information");
                    System.out.println("choise 3 : delete your information");
                    System.out.println("choise 4 : show your information");
                    System.out.println("choise other : Go back");
                    System.out.println("请输入你需要的操作 : ");
                    switch (scanner.nextInt()){
                        case 0 :
                            final Student student = new Student();
                            System.out.println("请输入学生ID: ");
                            student.setStudentId(scanner.nextInt());
                            System.out.println("请输入姓名: ");
                            student.setStudentName(scanner.next());
                            studentService.add(student);
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
                            List<Student> studentshow = studentService.getAll();
                            for (Student students : studentshow) {
                                System.out.println("该学生的ID为: " + students.getStudentId() + " ,该学生的学号为: " + students.getStudentName());
                            }
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
                    System.out.println("choise other : Go back");
                    System.out.println("请输入你需要的操作 : ");
                    switch (scanner.nextInt()){
                        case 0:
                            Teacher addteacher = new Teacher();
                            System.out.println("请输入您要添加的ID: ");
                            long id = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println("请输入您的名字: ");
                            String name = scanner.nextLine();
                            addteacher.setTeacher(id,name);
                            teacherService.add(addteacher);
                            break;
                        case 1:
                            System.out.println("请输入该老师的ID: ");
                            Teacher teacher = teacherService.findTeacher(scanner.nextLong());
                            if(teacher == null)
                                System.out.println("没有找到该ID老师的信息");
                            else {
                                System.out.println("该老师的ID为:" + teacher.getTeacherId() + "该老师的姓名为" + teacher.getTeacherName());
                            }
                            break;
                        case 2:
                            List<Teacher> teachershow = teacherService.getAll();
                            for(Teacher teachers : teachershow){
                                System.out.println("该老师的ID为: " + teachers.getTeacherId() + " ,该老师的名字为: " + teachers.getTeacherName());
                            }
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
                                System.out.println("查无此人!");
                            break;
                        default:
                            break;
                    }
                case 3:
                    System.out.println("choise 0 : add your information");
                    System.out.println("choise 1 : find your information");
                    System.out.println("choise 2 : show all information");
                    System.out.println("choise 3 : change your information");
                    System.out.println("choise 4 : delete your information");
                    System.out.println("choise other : Go back");

                    switch (scanner.nextInt()){
                        case 0:
                            Manager addmanager = new Manager();
                            System.out.println("请输入您要添加的ID: ");
                            long id = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println("请输入您要添加的姓名: ");
                            String name = scanner.nextLine();
                            addmanager.setManager(id,name);
                            managerService.add(addmanager);
                            break;
                        case 1:
                            System.out.println("请输入您要查询的ID: ");
                            Manager findmanager = managerService.findManager(scanner.nextLong());
                            if(findmanager == null)
                                System.out.println("没有找到该ID的管理人员");
                            else
                                System.out.println("该管理人员的ID为: " + findmanager.getManagerId() + " ,该管理人员的姓名为: " + findmanager.getManagerName());
                            break;
                        case 2:
                            List<Manager> showmanager= managerService.getAll();
                            for(Manager managers : showmanager){
                                System.out.println("该管理人员的ID为: " + managers.getManagerId() + " ,该管理人员的姓名为: " + managers.getManagerName());
                            }
                            break;
                        case 3:
                            Manager manager = new Manager();
                            System.out.println("请输入您需要修改的管理人员的ID: ");
                            long managerID = scanner.nextLong();
                            scanner.nextLine();
                            String managerName = scanner.nextLine();
                            manager.setManager(managerID,managerName);
                            if(managerService.change(manager))
                                System.out.println("修改成功!");
                            else
                                System.out.println("修改失败!");
                            break;
                        case 4:
                            System.out.println("请输入您需要删除的管理人员的ID: ");
                            if(managerService.delete(scanner.nextLong()))
                                System.out.println("删除成功!");
                            else
                                System.out.println("查无此人!");

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
