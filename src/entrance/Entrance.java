package entrance;
import jwxt.*;
import service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Entrance {
    public static void main(String[] args) {
        System.out.println("welcome to jwxt : ");
        System.out.println("There are several options here :");
        System.out.println("choise 0 : Student end");
        System.out.println("choise 1 : Teacher end");
        System.out.println("choise 2 : Manager end");
        System.out.println("please input your choise : ");
        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();
        switch (choise){
            case 0:
                System.out.println("choise 0 : add your information");
                System.out.println("choise 1 : show your information");
                System.out.println("choise 2 : change your information");
                System.out.println("请输入你需要的操作 : ");
                StudentService student = new StudentService();

                switch (scanner.nextInt()){
                    case 0 :
                        System.out.println("请输入学生ID: ");
                        String studentId = scanner.next();
                        System.out.println("请输入姓名: ");
                        String name = scanner.next();
                        System.out.println("请输入年龄: ");
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
                        student.addStudent(studentId,name,age,sex,year,phone,
                                bumen,sushe,banji,bandaoshi);
                        ;
                    case 1 :
                        student.show(student.toString());
                    case 2 :
                        student.
                        student.change(studentId);
                }

            case 1:
                System.out.println("choise 0 : add your information");
                System.out.println("choise 1 : show your information");
                System.out.println("choise 2 : show your student information");
                System.out.println("choise 2 : change the student information");
                System.out.println("请输入你需要的操作 : ");
            case 2:
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
        }
    }
}
