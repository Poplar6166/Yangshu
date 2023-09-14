package entrance;

import jwxt.Student;
import jwxt.Teacher;
import service.mysql.StudentsqlService;
import service.mysql.TeachersqlService;

import java.util.List;
import java.util.Scanner;

public class TeacherEntrance {
    Scanner scanner = new Scanner(System.in);
    TeachersqlService teacherService = new TeachersqlService();
    StudentsqlService studentService = new StudentsqlService();
    public void showTeacherinformation(long tcid){
        String teacherinformation = teacherService.findTeacher(tcid);
        System.out.println(teacherinformation);
    }
    public void showTeacherstudent(long tcid){
        List<Student> student = studentService.getStudent(tcid);
        for(Student students : student)
            System.out.println("学生学号: " + students.getStuID() + " ,学生姓名: " +
                    students.getStuName() + " ,学生班级: " +  students.getstuClass());
    }
    public void changeGrade(long stuid,long csID,long stugrade){
        if(teacherService.setStudentGrade(stuid,csID,stugrade)){
            System.out.println("添加成功!");
        }else {
            System.out.println("添加失败,请确认是否正确输入学号");
        }
    }
    public void setClass(long tcID,String name){
        if(teacherService.setCourse(name,tcID)){
            System.out.println("添加课程成功");
        }else {
            System.out.println("添加失败");/*尚未思考到添加失败的原因，先放上*/
        }
    }
    public void changeClass(long tcID,String name,long csCredit,long csHour,String csNature){
        if(teacherService.changeClass(name,csCredit,csHour,csNature,tcID)){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败,可能因为您查询的课程名字不存在");
        }
    }
    public void findMyClass(long csid){
        List<Student> student = studentService.getAllClassStudent(csid);
        for(Student students : student)
            System.out.println("学生学号: " + students.getStuID());
    }
}
