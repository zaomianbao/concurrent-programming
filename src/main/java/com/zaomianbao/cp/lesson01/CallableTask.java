package com.zaomianbao.cp.lesson01;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Description CallableTask
 * @Author zaomianbao
 * @Date 2020/3/17
 **/
public class CallableTask implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }

}
