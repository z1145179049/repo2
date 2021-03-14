package ClassManagementSystem.test;

import ClassManagementSystem.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/*
    需求：学生管理系统
 
        功能:对学生的信息进行管理
           1 登录系统   2 退出系统
           账号：
           密码：
           验证码
        -----欢迎来到班级管理系统-----
            1 添加学生信息：
            2 删除学生信息
            3 查找指定学生信息：
            4 查找所有学生信息
            5 统计班级信息
            6 退出
            请选择您要查询的序号：


    private String sid; // 学号
    private String name; // 姓名
    private int age; // 年龄
    private String sex; // 性别
    private String brithday; // 生日
    private String constellation; // 星座
    private String message; // 查看班级信息

 */
public class StudentDemo {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        // 登录系统
        lo:
        while(true){
            System.out.println("1 登录系统" + " " + "2 退出系统");
            String count = sc.next();
            switch(count){
                case "1":
                    //输入账号密码
                    int num = 0;
                    for (int i = 0; i < 3; i++) {
                        System.out.println("请输入管理员账号：");
                        String uesr = sc.next();
                        System.out.println("请输入管理员密码：");
                        String password = sc.next();

                            // 验证码
                            String code = "1234567890zxcvbnmlkjhgfdsaqwertyuiopZMXNCBVLAKSJDHFGQPWOEIRUTY";
                            StringBuilder ss= new StringBuilder();
                            int number = code.length();
                            for (int j = 0; j < 4; j++) {
                                int a = random.nextInt(number);
                                char ch = code.charAt(a);
                                ss.append(ch);
                            }
                            while (true){
                            System.out.println("请输入验证码：" + ss);
                            String Code = sc.next();
                            System.out.print("验证码：" + Code);
                            if(Code.equalsIgnoreCase(ss.toString())){
                                System.out.println("验证成功！");
                                break;
                            }else{
                                System.out.println("您输入的有误，请重新输入！");
                            }
                        }



                        if(uesr.equals("admin") && password.equals("123456")){
                            System.out.println("登录成功！");
                            break lo;
                        }else{
                            num++;
                            if(num < 3){
                                System.out.println("您输入的账号或密码错误，请重新输入！");
                            }else{
                                System.out.println("您已连续三次输入错误，请24小时以后再次尝试！");
                                return;
                            }
                        }
                    }
                case "2":
                    return;
                default:
                    System.out.println("您输入的有误，请重新输入！");
                    break;
            }
        }

        // 登录界面
        Scanner s = new Scanner(System.in);
        la:
        while(true){
            System.out.println("-----欢迎来到班级管理系统-----");
            System.out.println("1 添加学生信息：");
            System.out.println("2 删除学生信息");
            System.out.println("3 查找指定学生信息：");
            System.out.println("4 查找所有学生信息");
            System.out.println("5 统计班级信息");
            System.out.println("6 退出");
            System.out.println("请选择您要查询的序号：");

            // 选择要执行的代码块
            String num = sc.next();
            switch(num){
                case "1":
                    // System.out.println("1 添加学生信息：");
                    addStudent(list);
                    break;
                case "2":
                    // System.out.println("2 删除学生信息");
                    deleteStudent(list);
                    break;
                case "3":
                    // System.out.println("3 查找指定学生信息：");
                    locatingStudent(list);
                    break;
                case "4":
                    // System.out.println("4 查找所有学生信息");
                    setStudent(list);
                    break;
                case "5":
                    // System.out.println("5 统计班级信息");
                    printMessage(list);
                    break;
                case "6":
                    System.out.println("退出");
                    break la;
                default:
                    System.out.println("您输入的有误请重新输入！");
                    break;
            }

        }

    }

    // 统计班级信息
    public static void printMessage(ArrayList<Student> list) {
        // 多少人，男女，
        int count = 0;
        int total = list.size();

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if(stu.getSex().equals("男")){
                count++;
            }
        }
        System.out.println("班级有：" + total + "人");
        System.out.println("班级男生有：" + count + "人");
        System.out.println("班级女生有：" + (total - count) + "人");
    }

    // 查找指定学生
    public static void locatingStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要查找的学号：");
        String sid = sc.next();
        Student stu = new Student();
        int index = getIndex(list,sid);
        if(index == -1){
            System.out.println("无信息，请添加信息之后在查找！");
            return;
        }else{
            for (int i = 0; i < list.size(); i++) {
                Student a = list.get(i);
                System.out.println("学号：" + a.getSid());
                System.out.println("姓名：" + a.getName());
                System.out.println("年龄：" + a.getAge());
                System.out.println("性别：" + a.getSex());
                System.out.println("生日：" + a.getBrithday());
                System.out.println("星座：" + a.getConstellation());
            }
        }
    }

    // 删除学生
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要删除的学号：");
        String sid = sc.next();
        int index = getIndex(list,sid);
        if(index == -1){
            System.out.println("您输入的学生号不存在！");
            return;
        }else{
            list.remove(index);
            System.out.println("删除成功！");
        }
    }

    // 查找所有学生信息
    public static void setStudent(ArrayList<Student> list) {
        int s = list.size();
        if(s == 0){
            System.out.println("暂无信息，请添加以后再次查询！");
            return;
        }
        System.out.println("学号\t姓名\t年龄\t性别\t生日\t星座");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getSid() + "\t" + stu.getName() + "\t" + stu.getAge() +"\t" + stu.getSex() + "\t" + stu.getBrithday() + "\t" + stu.getConstellation());
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String sid;
        while(true){
            System.out.println("请输入学号");
            sid = sc.next();
            int index = getIndex(list,sid);
            if(index == -1){
                break;
            }else{
                System.out.println("您输入的学号已存在，请重新输入！");
            }
        }
        System.out.println("请输入您的姓名:");
        String name = sc.next();
        System.out.println("请输入您的年龄:");
        int age = sc.nextInt();
        System.out.println("请输入您的性别：");
        String sex = sc.next();
        System.out.println("请输入您的生日:");
        String brithday = sc.next();
        System.out.println("请输入您的小组:");
        String groud = sc.next();
        System.out.println("请输入您的星座：");
        String constellation = sc.next();
        Student stu = new Student(sid,name,age,sex,brithday,groud,constellation);
        list.add(stu);
        System.out.println("添加成功！");
    }

    // 判断学生是否存在
    public static int getIndex(ArrayList<Student> list,String sid){
        int index = -1; // 无信息
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String id = stu.getSid();
            if(id.equals(sid)){
                index = i; // 学生的索引位置
            }
        }
        return index;
    }
}
