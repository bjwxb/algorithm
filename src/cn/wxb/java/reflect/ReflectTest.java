package cn.wxb.java.reflect;

import cn.wxb.java.proxy.IHello;
import cn.wxb.java.proxy.SayHello;

import java.lang.reflect.Proxy;


/**
 * 反射
 *
 */
public class ReflectTest {


    public static void main(String[] args) {
        printInfo(SayHello.class);
        System.out.println("\n ************************** \n");
        printInfo(IHello.class);
        System.out.println("\n ************************** \n");
        printInfo(Proxy.class);

        Class strCls = String.class;
        String s = "hello";
        //Class实例在JVM中是唯一的
        System.out.println("------- " + (s.getClass() == strCls));

    }

    static void printInfo(Class cls) {
        System.out.println("class name is " + cls.getName());
        System.out.println("class simple name is " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("package name is : " + cls.getPackage().getName());
        }
        System.out.println(">> " + cls.getInterfaces().length);
        System.out.println("is interface = " + cls.isInterface());
        System.out.println("is enum = " + cls.isEnum());
        System.out.println("is array = " + cls.isArray());
        System.out.println("is primitive = " + cls.isPrimitive());
        ClassLoader loader = cls.getClassLoader();
        while(null != loader){
            System.out.println(loader);
            loader = loader.getParent();
        }
    }
}
