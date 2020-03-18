package com.zaomianbao.cp.lesson01;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @Description MyCallable
 * @Author zaomianbao
 * @Date 2020/3/18
 **/
public class MyCallable implements Callable<RunResult> {
    // 运算结果类
    private RunResult result;
    // 线程同步器
    private CountDownLatch main;
    @Override
    public RunResult call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name + " 线程开始执行" + "-" + result.getParam());
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j <= 200000000; j++) {
                if (j == 200000000 && null != result.getParam()) {
                    result.setResult(result.getParam()*10);
                    result.setSuccess(true);
                    System.out.println(name + " 线程正在进行计算" + "-" + result.getParam());
                } else {
                    result.setSuccess(false);
                }
            }
        }
        System.out.println(name + " 线程执行完毕" + "-" + result.getParam());
        //main.countDown();
        return result;
    }
    public MyCallable(RunResult result, CountDownLatch main) {
        super();
        this.result = result;
        this.main = main;
    }
    public MyCallable() {
        super();
    }
}
