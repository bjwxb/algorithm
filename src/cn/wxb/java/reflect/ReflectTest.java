package cn.wxb.java.reflect;

import cn.wxb.java.proxy.IHello;
import cn.wxb.java.proxy.SayHello;

import java.lang.reflect.Proxy;

/**
 * 类加载器 - 双亲委托加载机制
 * 1. 类加载器
 *   a. 系统类加载起： bootstrapClassloader - 启动类加载器，用来加载jvm运行时所需要的系统类，由c++实现
 *                  ExtensionsClassloader - 扩展类加载器，由ExtClassLoader类实现
 *                  AppClassloader - 系统类加载器， 由AppClassLoader类实现
 *
 *   b. 自定义类加载起
 *
 * 2. 双亲委托机制
 *   a. 首先判断class是否已记载
 *   b. 如果没有则不是自身去查找而是委托给父加载器进行查找，这样依次的进行递归，直到委托到最顶层的Bootstrap ClassLoader
 *   c. 如果Bootstrap ClassLoader找到了该Class，就会直接返回
 *   d. 如果没找到，则继续依次向下查找，如果还没找到则最后会交由子类去查找
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
