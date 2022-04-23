package com.wugang.demo02;

/**
 * @author wugang
 * @date 2022/4/23 10:15
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        UserServiceProxy userServiceProxy = new UserServiceProxy();

        userServiceProxy.setUserService(userService);

        userServiceProxy.add();
    }
}
