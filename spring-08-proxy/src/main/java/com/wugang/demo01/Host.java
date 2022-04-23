package com.wugang.demo01;

/**
 * 房东
 * @author wugang
 * @date 2022/4/23 9:27
 */
public class Host implements Rent{

    @Override
    public void rent() {
        System.out.println("房东要出租房子！");
    }
}
