package cn.wxb.kotlin.study;

public class Ex {


    public static int x;
    public static int y = 0;
    private static Ex singleton = new Ex();

    private Ex() {
        ++x;
        ++y;
        System.out.println("Singleton构造方法执行，x = " + x +",y = " + y);
    }

    public static void main(String[] args) {
        System.out.println("**** " + July.tag);
        System.out.println("**** " + July.tag);
//        System.out.println("===== " + new July());

        System.out.println("singleton.x = " + singleton.x);
        System.out.println("singleton.y = " + singleton.y);

    }
}

class Person{
    static {
        System.out.println("------ person ------");
    }
}

class Student extends Person{

    public static String tag = "tag";

    static {
        System.out.println(">>>>>>> Student ------");
    }
}


class July extends Student{
    static {
        System.out.println(">>>>>>> this is July ------");
    }
}