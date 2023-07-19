package jwxt;

import java.util.Scanner;

public class Teacher implements SuperTeacher {

    public static void main(String[] args){

    }
    private String name;
    private int age;
    private String sex;
    private String year;
    private String phone;
    private String jiaoshihao;
    private String bumen;
    public void setTName(String name){
        this.name = name;
    }
    public void setTAge(int age){
        this.age = age;
    }
    public void setTSex(String sex){
        this.sex = sex;
    }
    public void setTYear(String year){
        this.year = year;
    }
    public void setTPhone(String phone){
        this.phone = phone;
    }
    public void setTJiaoshihao(String jiaoshihao){
        this.jiaoshihao = jiaoshihao;
    }
    public void setTBumen(String bumen){
        this.bumen = bumen;
    }
    public String getJiaoshihao(){
        return jiaoshihao;
    }
    public String getBumen(){
        return bumen;
    }
    public String getTName(){
        return name;
    }
    public int getTAge(){
        return age;
    }
    public String getTSex(){
        return sex;
    }
    public String getTYear(){
        return year;
    }
    public String getTPhone(){
        return phone;
    }
}
