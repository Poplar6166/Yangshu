package jwxt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Manager {
        private String managerId;
        private String managerName;
        private int managerAge;
        private String managerSex;
        private Date managerYear;
        private String managerPhone;
        private void setInformation(String managerid, String managername, int age, String sex, Date year,String phone){
                this.managerId = managerid;
                this.managerName = managername;
                this.managerAge = age;
                this.managerSex = sex;
                this.managerYear = year;
                this.managerPhone = phone;
        }
        public String getManagerId(){
                return this.managerId;
        }
        public String getManagerName(){
                return this.managerName;
        }
        public int getManagerAge(){
                return this.managerAge;
        }
        public String getManagerSex(){
              return this.managerSex;
        }
        public Date getManagerYear(){
                return this.managerYear;
        }
        public String getManagerPhone(){
                return this.managerPhone;
        }
    /*
    ArrayList<String> ManagerIdList = new ArrayList<>();
    ArrayList<String> ManagerNameList = new ArrayList<>();
    ArrayList<Integer> ManagerAgeList = new ArrayList<>();
    ArrayList<String> ManagerSexList = new ArrayList<>();
    ArrayList<String> ManagerYearList = new ArrayList<>();
    ArrayList<String> ManagerPhoneList = new ArrayList<>();
    Map<String, Manager> map = new HashMap<>();

    public void addInformation(String managerid, String managername, int age, String sex, String year,String phone) {
        ManagerIdList.add(managerid);
        ManagerNameList.add(managername);
        ManagerAgeList.add(age);
        ManagerSexList.add(sex);
        ManagerYearList.add(year);
        ManagerPhoneList.add(phone);
        map.put(managerid, this); // 使用 classId 作为键，将当前对象存储到 map 中
    }

    public void show() {
        for (Map.Entry<String, Manager> entry : map.entrySet()) {
            String key = entry.getKey();
            Manager value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value.toString());
        }
    }

    @Override
    public String toString() {
        return "ManagerIdList = " + ManagerIdList +
                ", ManagerNameList = " + ManagerNameList +
                ", ManagerAgeList = " + ManagerAgeList +
                ", ManagerSexList = " + ManagerSexList +
                ", ManagerYearList = " + ManagerYearList +
                ", ManagerPhoneList = " + ManagerPhoneList;
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addInformation("22222", "张", 28, "男", "2019","132123123");
        manager.show();
        /*ArrayList<String> stuIdList = new ArrayList<String>();
        ArrayList<String> nameList = new ArrayList<String>();
        stuIdList.add("3210411111");
        stuIdList.add("3210422222");
        nameList.add("jack");
        nameList.add("pick");
        System.out.println(nameList);
        System.out.println(stuIdList);
        String firstName = nameList.get(0);
        String firstStu_id = stuIdList.get(0);
        System.out.println("第一个名字和学号是: " + firstStu_id + " " + firstName);
        nameList.remove(1);
        stuIdList.remove(1);
        System.out.println("删除第二个位置以后剩下的名字: " + stuIdList);
        System.out.println("删除第二个位置以后剩下的学号: " + nameList);
        int size = nameList.size();
        int size1 = stuIdList.size();
        System.out.println("姓名列表大小为: " + size + " ,学号列表大小为 : " + stuIdList);

    }
    */
}