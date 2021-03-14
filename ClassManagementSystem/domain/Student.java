package ClassManagementSystem.domain;

public class Student {
    private String sid; // 学号
    private String name; // 姓名
    private int age; // 年龄
    private String sex; // 性别
    private String brithday; // 生日
    private String constellation; // 星座
    private String message; // 查看班级信息
    public Student(){
    }

    public Student(String sid, String name, int age, String sex, String brithday, String constellation, String message) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.brithday = brithday;
        this.constellation = constellation;
        this.message = message;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
