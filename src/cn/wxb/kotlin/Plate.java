package cn.wxb.kotlin;

import java.util.concurrent.ArrayBlockingQueue;

public class Plate {
    private ArrayBlockingQueue queue = new ArrayBlockingQueue(5);

    void put(Object egg){
        try {
            queue.put(egg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===== 放入鸡蛋 =======");
    }

    Object take(){
        Object egg = null;
        try {
            egg = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("》》》》》 取出鸡蛋 《《《《《");
        return egg;
    }

    static class AddThread implements Runnable{
        private Plate plate;
        private Object egg = new Object();

        public AddThread(Plate plate) {
            this.plate = plate;
        }

        public void run() {
            plate.put(egg);
        }
    }

    static class getThread implements Runnable{
        private Plate plate;

        public getThread(Plate plate) {
            this.plate = plate;
        }

        public void run() {
            plate.take();
        }
    }

    public static void main(String[] args) {
        Plate plate = new Plate();
        for(int i = 0; i < 15; i++){
            new Thread(new AddThread(plate)).start();
        }

        for(int i = 0; i < 15; i++){
            new Thread(new getThread(plate)).start();
        }
    }
}
