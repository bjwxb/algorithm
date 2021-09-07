package cn.wxb.java.proxy;

public class SayHello implements IHello{
    @Override
    public void say() {
        System.out.println("Hello World!");
    }
}
