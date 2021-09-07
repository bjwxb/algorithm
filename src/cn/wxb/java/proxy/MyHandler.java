package cn.wxb.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现动态代理的核心接口，动态代理本质采用的java反射机制实现
 */
public class MyHandler implements InvocationHandler {

    private Object object;

    public MyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--- proxy befor ---");
        Object obj = method.invoke(object, args);
        System.out.println(">>>>> " + method.getName());
        System.out.println("=== proxy after ===");
        return null;
    }
}
