package cn.wxb.kotlin;

import java.util.concurrent.ArrayBlockingQueue;

public class PrintNum {
    private static final int THREAD_COUNT = 3;
    private static int value = 0;
    private static final Object lock = new Object();


    static class PrintThread extends Thread{
        private int threadNo;

        public PrintThread(int threadNo) {
            this.threadNo = threadNo;
        }

        @Override
        public void run() {
            while (true){
                synchronized (lock){
                    try{
                        while (value % THREAD_COUNT != threadNo){
//                            System.out.println(">>>>> " + threadNo + " , value = " + value);
                            lock.wait();
                        }
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " : " + (value % THREAD_COUNT + 1));
                        value ++;
                        if (value == 10){
                            value = 1;//value % THREAD_COUNT;
                        }
                        lock.notifyAll();

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }
    }


    public static void main(String[] args) {
        new PrintThread(0).start();
        new PrintThread(1).start();
        new PrintThread(2).start();
    }
}
