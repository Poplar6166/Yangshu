package jwxt;

import jwxt.SuperStudent;

public class Student implements SuperStudent {
    public static void main(String[] args){

    }
    private String name;
    private int age;
    private String sex;
    private String year;
    private String phone;
    private String xuehao;
    private String kecheng;
    private String bumen;
    public void setSName(String name){
        this.name = name;
    }
    public void setSAge(int age){
        this.age = age;
    }
    public void setSSex(String sex){
        this.sex = sex;
    }
    public void setSYear(String year){
        this.year = year;
    }
    public void setSPhone(String phone){
        this.phone = phone;
    }
    public String getSName(){
        return name;
    }
    public int getSAge(){
        return age;
    }
    public String getSSex(){
        return sex;
    }
    public String getSYear(){
        return year;
    }
    public String getSPhone(){
        return phone;
    }
    public void setXuehao(String xuehao){
        this.xuehao = xuehao;
    }
    public void setKecheng(String kecheng){
        this.kecheng = kecheng;
    }
    public void setBumen(String bumen){
        this.bumen = bumen;
    }
    public String getXuehao(){
        return xuehao;
    }
    public String getKecheng(){
        return kecheng;
    }
    public String getBumen(){
        return bumen;
    }
    public void show(){
        System.out.println("student name is " + name);
        System.out.println("student age is " + age);
        System.out.println("student sex is " + sex);
        System.out.println("student year is " + year);
        System.out.println("student phone is " + phone);
        System.out.println("Student xuehao is " + xuehao);
        System.out.println("Student kecheng is " + kecheng);
        System.out.println("Student bumen is " + bumen);
    }

}