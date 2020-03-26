package com.zaomianbao.cp.basic;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description RunnableThread
 * @Author zaomianbao
 * @Date 2020/3/17
 **/
@Slf4j
public class RunnableThread implements Runnable{

    @Override
    public void run() {
        log.info("用实现Runnable接口实现线程");
    }

}
