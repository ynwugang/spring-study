package com.wugang.service;

import com.wugang.dao.UserDaoOracleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wugang
 * @date 2022/4/18 20:07
 */
public class TestUserService {
    public static void main(String[] args) {

//        UserService userService = new UserServiceImpl();
//
//        ((UserServiceImpl) userService).setUserDao(new UserDaoOracleImpl());
//
//        userService.getUser();

        //获取ApplicationContext，拿到Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //需要什么，就直接get什么
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");

        userServiceImpl.getUser();
    }
}
