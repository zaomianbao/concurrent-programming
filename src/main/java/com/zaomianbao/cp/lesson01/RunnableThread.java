package com.zaomianbao.cp.lesson01;

/**
 * @Description RunnableThread
 * @Author zaomianbao
 * @Date 2020/3/17
 **/
public class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("用实现Runnable接口实现线程");
    }

}
