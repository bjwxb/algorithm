package cn.wxb.kotlin;

import java.sql.Time;
import java.util.concurrent.*;

public class ThreadPoolTest {
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(4, Math.min(CPU_COUNT - 1, 5));
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 2;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<>(9);

    //一共执行20个任务 ,核心线程数是4，最大核心线程数是10，目前加入的runnable20个(相当于20个任务），
    //20个任务需要执行，但是核心线程数只有4个，还有16个任务，由于LinkedBlockingQueue队列是最大存放的任务为9个，队列满了，则会创建新的线程去执行任务
    //这个时候最大线程是10，非核心线程数还有6个，这时候会开6个线程去执行，目前达到10个最大线程数，此时队列里面最大只能存放9个，
    //还有一个Runnable，此时就会报错RejectedExecutionException

    private final static ExecutorService THREAD_POOL_EXECUTOR;
    static {
        System.out.println("核心线程数=" + CORE_POOL_SIZE);
        System.out.println("最大线程数=" + MAXIMUM_POOL_SIZE);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,  //核心线程数
                13, //线程池中最大的线程数
                60,  //线程的存活时间，没事干的时候，空闲的时间
                TimeUnit.SECONDS, //线程存活时间的单位
                new LinkedBlockingQueue<>(6), //线程缓存队列
//                new SynchronousQueue<>(),
                new ThreadFactory() {  //线程创建工厂，如果线程池需要创建线程会调用newThread来创建
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setDaemon(false);
                        return thread;
                    }
                }, new CustomRejectedExecutionHandler());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    public static void main(String[] args) {

        //阻塞队列（BlockingQueue）是一个支持两个附加操作的队列。这两个附加的操作是：在队列为空时，获取元素的线程会等待队列变为非空。
        // 当队列满时，存储元素的线程会等待队列可用。阻塞队列常用于生产者和消费者的场景，生产者是往队列里添加元素的线程，
        // 消费者是从队列里拿元素的线程。阻塞队列就是生产者存放元素的容器，而消费者也只从容器里拿元素
        //array 必须指定大小初始化，一旦初始化无法更改
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(4);
        //若不指定大小， 默认Integer.Max_value
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
//        Executors.newCachedThreadPool()

        try {
            queue.put("a");
            System.out.println(">>>>>>>>>>>>>>");
            queue.put("b");//会阻塞 - put/take
            System.out.println("---------------");
//            queue.add("e");//会抛出异常 - add/remove/element
            queue.offer( "c", 2, TimeUnit.SECONDS); // 无异常 - offer/poll/peek
            System.out.println("===============");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 20; i++) {
            Runnable runnable = new WorkThread("t-" + i);
            //丢给线程池去执行
            THREAD_POOL_EXECUTOR.execute(runnable);
        }
    }
}
