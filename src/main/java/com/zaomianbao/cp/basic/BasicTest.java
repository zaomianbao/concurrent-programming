package com.zaomianbao.cp.basic;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description Lesson01Test
 * @Author zaomianbao
 * @Date 2020/3/17
 **/
@Slf4j
public class BasicTest {

    public static void main(String[] args) {

        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.start();

        Thread thread = new Thread(new RunnableThread());
        thread.start();

        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //提交任务
        Future<Integer> future = service.submit(new CallableTask());
        try {
            Integer value = future.get();
            log.info(value.toString());
            service.shutdown();
        } catch (InterruptedException e) {
            log.error(e.getMessage(),e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error(e.getMessage(),e);
        }

        //Future模式实现类似CountDownLatch的功能
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(6, 10, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        // 存放Future<>的集合
        List<Future<RunResult>> list = new ArrayList<>(12);
        for (int i = 1; i <= 12; i++) {
            RunResult result = new RunResult();
            result.setParam(i);
            MyCallable callable = new MyCallable(result);
            Future<RunResult> runResultFuture = threadPool.submit(callable);
            list.add(runResultFuture);
        }
        try {
            for (int i = 0; i < list.size(); i++) {
                RunResult runResult = list.get(i).get();
                log.info(JSON.toJSON(runResult).toString());
            }
            // 线程池不用了，关闭线程池
            threadPool.shutdown();
        } catch (InterruptedException e) {
            log.error(e.getMessage(),e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error(e.getMessage(),e);
        }

    }
}
