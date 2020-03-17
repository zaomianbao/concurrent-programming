package com.zaomianbao.cp.lesson01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description Lesson01Test
 * @Author zaomianbao
 * @Date 2020/3/17
 **/
public class Lesson01Test {

    public static void main(String[] args) {

        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.start();

        Thread thread = new Thread(new RunnableThread());
        thread.start();

        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //提交任务
        Future<Integer> future = service.submit(new CallableTask());

    }
}
