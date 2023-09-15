package entrance;

import jwxt.Manager;
import jwxt.MyClass;
import jwxt.Student;
import jwxt.Teacher;
import service.SuperStudentsql;
import service.mysql.ManagersqlService;
import service.mysql.StudentsqlService;
import service.mysql.TeachersqlService;

import java.awt.desktop.SystemEventListener;
import java.util.List;
import java.util.Scanner;
import java.util.SplittableRandom;

public class ManagerEntrance {
    ManagersqlService managersqlService = new ManagersqlService();
    Manager manager = new Manager();
    public void showAllClass(){
        List<MyClass> myClasses = managersqlService.getAllClass();
        for(MyClass myClass : myClasses)
            System.out.println("课程号为: " + myClass.getClassId() + " ,课程名字为: "
                    + myClass.getClassName() + " ,老师ID为: "
                    + myClass.getTeacherId() + " ,课程学分是: "
                    + myClass.getCourseCredit() + " ,课程学时是: "
                    + myClass.getCourseHour() + " ,课程性质是: "
                    + myClass.getCourseNature() + "课程是否开放: "
                    + myClass.getIfopen());
    }
    public void changeClass(String ifopen,long csid){
        managersqlService.changeCourse(ifopen,csid);
    }
    public void addStatus(long stuid){
        if(managersqlService.setaddStatus(stuid)){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败！原因为该学生学籍已经存在");
        }
    }
    public void changeStatus(long changeid,String state,String stu_reward_punish,String sturegister){
        if(managersqlService.changeStatus(changeid,state,stu_reward_punish,sturegister)){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败！原因可能为学生学号输入错误");
        }
    }
    public void sendEmails(long stuID){
        if(managersqlService.addStudentEmail(stuID,"您尚未缴纳学费，请及时缴纳")){
            System.out.println("已经自动发送催费邮件给学生");
        }else {
            System.out.println("未自动发送缴费邮件给学生，可能是由于学号不对引起的");
        }
    }
}
