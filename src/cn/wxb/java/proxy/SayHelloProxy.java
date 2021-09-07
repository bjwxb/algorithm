package cn.wxb.java.proxy;

public class SayHelloProxy implements IHello{

    private IHello hello;

    public SayHelloProxy(IHello hello) {
        this.hello = hello;
    }

    @Override
    public void say() {
        System.out.println(">>> 静态代理 >>> begin");
        hello.say();
        System.out.println("====== 静态代理 after");
    }
}
