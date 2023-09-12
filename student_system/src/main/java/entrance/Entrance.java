package entrance;
import service.SuperManagersql;
import service.SuperStudentsql;
import service.SuperTeachersql;

import service.mysql.ManagersqlService;
import service.mysql.StudentsqlService;
import service.mysql.TeachersqlService;
import jwxt.Student;
import jwxt.Manager;
import jwxt.Teacher;

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
            switch (choise) {
                case 1:

                case 2:

                case 3:

                    if (choise == 0)
                        break;


            }

        }
    }
}
