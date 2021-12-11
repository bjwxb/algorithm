package cn.wxb.kotlin;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (r instanceof WorkThread){
            WorkThread w = (WorkThread) r;
            System.out.println(">>>>>> rejected <<<<<< " + w.toString());
        } else {
            System.out.println(">>>>>>>>> rejected <<<<<<<<<<<<");
        }

    }
}
