package jwxt;

public class Manager implements SuperManager {

    public static void main(String[] args){

    }
    private String name;
    private int age;
    private String sex;
    private String year;
    private String phone;
    public void setMName(String name){
        this.name = name;
    }
    public void setMAge(int age){
        this.age = age;
    }
    public void setMSex(String sex){
        this.sex = sex;
    }
    public void setMYear(String year){
        this.year = year;
    }
    public void setMPhone(String phone){
        this.phone = phone;
    }
    public String getMName(){
        return name;
    }
    public int getMAge(){
        return age;
    }
    public String getMSex(){
        return sex;
    }
    public String getMYear(){
        return year;
    }
    public String getMPhone(){
        return phone;
    }
}
