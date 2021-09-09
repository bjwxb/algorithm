package cn.wxb.java.reflect;


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
 *
 * 3. 双亲委托机制好处
 *   a. 因为这样可以避免重复加载，当父亲已经加载了该类的时候，就没有必要子ClassLoader再加载一次。
 *   b. 考虑到安全因素，我们试想一下，如果不使用这种委托模式，那我们就可以随时使用自定义的String来动态替代java核心api中定义类型，
 *      这样会存在非常大的安全隐患，而双亲委托的方式，就可以避免这种情况，因为String已经在启动时被加载，
 *      所以用户自定义类是无法加载一个自定义的ClassLoader
 */
public class MyClassLoader extends ClassLoader{

    private String name;

}
