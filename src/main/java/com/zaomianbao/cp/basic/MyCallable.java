package com.zaomianbao.cp.basic;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.Callable;

/**
 * @Description MyCallable
 * @Author zaomianbao
 * @Date 2020/3/18
 **/
@Slf4j
public class MyCallable implements Callable<RunResult> {
    // 运算结果类
    private RunResult result;
    @Override
    public RunResult call() {
        String name = Thread.currentThread().getName();
        log.info(name + " 线程开始执行" + "-" + result.getParam());
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j <= 200000000; j++) {
                if (j == 200000000 && null != result.getParam()) {
                    result.setResult(result.getParam()*10);
                    result.setSuccess(true);
                    log.info(name + " 线程正在进行计算" + "-" + result.getParam());
                } else {
                    result.setSuccess(false);
                }
            }
        }
        log.info(name + " 线程执行完毕" + "-" + result.getParam());
        return result;
    }
    public MyCallable(RunResult result) {
        super();
        this.result = result;
    }
    public MyCallable() {
        super();
    }
}
