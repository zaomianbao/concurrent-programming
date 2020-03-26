package com.zaomianbao.cp.basic;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description ExtendsThread
 * @Author zaomianbao
 * @Date 2020/3/17
 **/
@Slf4j
public class ExtendsThread extends Thread{

    @Override
    public void run() {
        log.info("用Thread类实现线程");
    }

}
