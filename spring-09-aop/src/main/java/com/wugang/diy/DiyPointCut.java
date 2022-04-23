package com.wugang.diy;

/**
 * @author wugang
 * @date 2022/4/23 16:29
 */
public class DiyPointCut {

    public void before(){
        System.out.println("=========方法执行前=========");
    }

    public void after(){
        System.out.println("=========方法执行后=========");
    }
}
