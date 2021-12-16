package cn.wxb.kotlin;

/**
 * 1。原子性 - 对基本数据类型的变量的读取和赋值操作是原子性操作，即这些操作是不可被中断的，要么执行，要么不执行
 * 2。可见性 - 它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
 * 3。有序性 - 可以通过volatile关键字来保证一定的“有序性”（具体原理在下一节讲述）。另外可以通过synchronized和Lock来保证有序性
 *
 * 4。 不可变 - final 关键字修饰的基本数据类型/String/枚举类型
 *       不可变(Immutable)的对象一定是线程安全的，不需要再采取任何的线程安全保障措施。
 *       只要一个不可变的对象被正确地构建出来，永远也不会看到它在多个线程之中处于不一致的状态
 *
 */
//实现双重校验锁实现单例模式
public class Singleton {
    //volatile关键字有两个作用：
    // (1) 可见性 - 保证共享变量在修改之后对于其他线程的可见性；
    // (2) 有序性 - 禁止JVM在执行字节码时发生的指令重排(在这里主要是禁止指令重排的作用，
    //              因为new 对象在虚拟机中分几步执行
    //              1：分配对象的内存空间  memory = allocate();
    //              2：初始化对象  ctorInstance(memory);)
    //              3：设置instance指向刚分配的内存地址，此时对象还没被初始化
    //                  instance = memory;
                    //如果线程a先执行了3，  线程b在第一个if判断！=null,返回不正确对象，后续报错

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {//为了提高效率，避免多次执行同步代码
            //synchronized关键字本身就有保证可见性和原子性的作用
            synchronized(Singleton.class) {
                if (instance == null) {//防止多次创建对象
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance2() {
        return SingletonHolder.INSTANCE;
    }
}
