package com.wugang.demo04;

import com.wugang.demo02.UserService;
import com.wugang.demo02.UserServiceImpl;

/**
 * @author wugang
 * @date 2022/4/23 14:28
 */
public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色：不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //设置要代理的对象
        pih.setTarget(userService);
        //动态生成代理类
        UserService proxy = (UserService) pih.getProxy();

        proxy.update();
    }
}
