package cn.wxb.kotlin;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 1. 为什么要有线程池
 *      线程池由任务队列和工作线程组成，它可以重用线程来避免线程创建的开销，
 *      在任务过多时通过排队避免创建过多线程来减少系统资源消耗和竞争，确保任务有序完成
 *
 *      线程池能够对线程进行统一分配，调优和监控:
 *      a. 降低资源消耗(线程无限制地创建，然后使用完毕后销毁)
 *      b. 提高响应速度(无须创建线程)
 *      c. 提高线程的可管理性
 *
 * 2. 自定义拒绝策略通过 RejectedExecutionHandler 接口实现
 *
 * 3. wait 和 sleep 区别
 *      a。 wait可以在任何对象上调用，因为它在java.lang.Object上定义，
 *          但它只能从synchronized块中调用。它释放对象的锁定，以便另一个线程可以跳入并获取锁。（使用notify唤醒）
 *      b. Thread.sleep（）是一个可以从任何上下文调用的静态方法。Thread.sleep（）暂停当前线程并且不释放任何锁。
 *      c. sleep来控制线程执行时间； wait进行多线程同步
 *      d. sleep只是针对当前线程,而wait和notify配合使用可以实现多线程的通讯.
 *      e. sleep不需要被唤醒,wait是需要被唤醒的
 *      f. sleep会让出cpu资源,并且会上下文的切换,wait不一定会,因为可能会有机会重新竞争获取到锁
 *
 *      执行join方法的线程会让当前线程进入阻塞状态
 *
 * 4. activity A 跳转到 activity B
 *      A.onPause -> B.onCreate,onStart,onResume -> A.onStop
 *    activityB 返回A
 *    B.onPause -> A.onStart,onResume -> B.onStop
 *
 * 5。 主线程中一般情况是catch不到子线程到异常的; 通过自定义线程池的拒绝策略是可以捕获到子线程异常的
 *
 * 6. multiDex 作用
 *      如果App引用的库太多，方法数超过65536后无法编译。这是因为单个dex里面不能有超过65536个方法。
 *      为什么有最大的限制呢， 因为android会把每一个类的方法id检索起来，存在一个链表结构里面。
 *      但是这个链表的长度是用一个short类型来保存的， short占两个字节（保存-2的15次方到2的15次方-1，即-32768~32767），
 *      最大保存的数量就是65536。
 *      新版本的Android系统中修复了这个问题， 但是我们仍然需要对低版本的Android系统做兼容
 *       1.精简方法数量,删除没用到的类、方法、第三方库。
 *       2.使用ProGuard去掉一些未使用的代码
 *       3.复杂模块采用jni的方式实现，也可以对边缘模块采用本地插件化的方式。
 *       4.分割Dex
 *
 * 7。 JVM、DVM、ART的区别
 *
 *      Jvm是java虚拟机，执行class字节码
 *      Dvm是Android虚拟机，对jvm做了许多优化，执行dex文件，dex格式是专门为Dalvik应用设计的一种压缩格式，
 *          适合于内存和处理器速度有限的平台，允许同时独立运行多个进程
 *      Dalvik下的应用每次运行的时候都要通过即时编译器（Android Runtime，JIT）将字节码转化为机器码，即每次应用运行的时候都需要先编译再运行
 *      ART的优点是在安装的时候就预编译字节码为机器代码，这样在以后应用的运行时就不用再反复编译了，提高了应用的启动速度，同时也节省了手机的能耗，
 *      缺点是应用安装的时候会比较慢，同时由于同一份代码的机器代码会比字节码大10%-20%，所以造成相同的应用在Art下的大小可能比在Dalvik下大10%左右
 *
 * 8。transient作用
 *      Serializable方式序列化时
 *      a。一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问
 *      b. transient关键字只能修饰变量，而不能修饰方法和类。
 *      c. 被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化
 *
 */
public class Doc4 {

    public static void main(String[] args) {

        //会创建5个核心线程，五个线程不随着工作的完成而消亡，会一直存在，并负责执行分配给线程池的任务，直到线程池消亡
        //因为阻塞队列是无界的LinkedBlockingQueue，这使得最大线程数和拒绝策略失效
        ExecutorService executor = Executors.newFixedThreadPool(5);


        CustomRejectedExecutionHandler rejectionHandler = new CustomRejectedExecutionHandler();
        //Get the ThreadFactory implementation to use
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //1. 一个任务提交至线程池
        //2。 线程池首先当前运行的线程数量是否少于corePoolSize。如果是，则创建一个新的工作线程来执行任务
        //3。 判断BlockingQueue是否已经满了，倘若还没有满，则将线程放入BlockingQueue。否则进入3
        //4。 如果创建一个新的工作线程将使当前运行的线程数量超过maximumPoolSize，则交给RejectedExecutionHandler来处理任务
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(8), threadFactory, rejectionHandler);

        for (int i = 0; i< 20; i++){
            executorPool.execute(new WorkThread("thread-" + i));
        }
        List<String> l1 = new ArrayList<>();
        List<Object> l2 = new ArrayList<>();

    }
}
