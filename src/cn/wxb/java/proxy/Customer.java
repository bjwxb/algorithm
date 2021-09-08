package cn.wxb.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理模式理解
public class Customer implements ILaw{
    @Override
    public void law() {
        System.out.println(">>> 上法庭陈述事实 <<<");
    }

    public static void main(String[] args) {

        //1. 动态代理 demo1
        //代理目标对象
        Customer customer = new Customer();
        //代理回调类
        MyHandler handler = new MyHandler(customer);
        //生成代理对象Proxy通过调用newProxyInstance方法生成代理对象，传入该类的classLoader，实现接口，InvocationHandler
        ILaw proxy =  (ILaw) Proxy.newProxyInstance(ILaw.class.getClassLoader(),
                new Class[]{ILaw.class}, handler);
        proxy.law();

        System.out.println("\n=====================================\n");

        //2. 动态代理 demo - 2
        SayHello sh = new SayHello();
        MyHandler handler1 = new MyHandler(sh);
        //生成代理对象Proxy通过调用newProxyInstance方法生成代理对象，传入该类的classLoader，实现接口，InvocationHandler
        IHello hello =  (IHello) Proxy.newProxyInstance(sh.getClass().getClassLoader(),
                sh.getClass().getInterfaces(), handler1);
        hello.say();

        System.out.println("\n=====================================\n");

        //3. 静态代理
        SayHello sh1 = new SayHello();
        SayHelloProxy slp = new SayHelloProxy(sh1);
        slp.say();


    }
}
