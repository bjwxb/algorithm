package cn.wxb.kotlin;

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
                5, //线程池中最大的线程数
                60,  //线程的存活时间，没事干的时候，空闲的时间
                TimeUnit.SECONDS, //线程存活时间的单位
                new LinkedBlockingQueue<>(10), //线程缓存队列
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
        for (int i = 0; i < 20; i++) {
            Runnable runnable = new WorkThread("t-" + i);
            //丢给线程池去执行
            THREAD_POOL_EXECUTOR.execute(runnable);
        }
    }
}
