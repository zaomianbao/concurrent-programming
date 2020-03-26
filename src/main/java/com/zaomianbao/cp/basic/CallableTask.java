package com.zaomianbao.cp.basic;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Description CallableTask
 * @Author zaomianbao
 * @Date 2020/3/17
 **/
public class CallableTask implements Callable<Integer>{

    @Override
    public Integer call(){
        return new Random().nextInt();
    }

}
