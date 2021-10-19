package cn.wxb.java;

///如何让两个线程循环交替打印
public class ThreadPrint {


    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        new Thread(t1, "thread-1").start();
        new Thread(t1, "thread-2").start();

        try {
            Thread.sleep(1000);
            t1.exit = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    static class MyThread implements Runnable{

        private int count = 0;
        public volatile boolean exit = false;

        @Override
        public void run() {
            if (!exit){
                synchronized (this){
                    while(count < 10){
                        this.notify();
                        count++;
                        System.out.println(Thread.currentThread().getName() + ">>>>>> count = " + count);


                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }
}
