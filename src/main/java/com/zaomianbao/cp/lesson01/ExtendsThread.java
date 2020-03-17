package com.zaomianbao.cp.lesson01;

/**
 * @Description ExtendsThread
 * @Author zaomianbao
 * @Date 2020/3/17
 **/
public class ExtendsThread extends Thread{

    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }

}
