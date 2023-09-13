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
    public void changeGrade(long stuid,long stugrade){
        if(teacherService.setStudentGrade(stuid,stugrade)){
            System.out.println("添加成功!");
        }else {
            System.out.println("添加失败,请确认是否正确输入学号");
        }
    }
}
