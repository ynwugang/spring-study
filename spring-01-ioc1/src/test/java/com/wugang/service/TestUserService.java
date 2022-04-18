package com.wugang.service;

import com.wugang.dao.UserDaoOracleImpl;

/**
 * @author wugang
 * @date 2022/4/18 20:07
 */
public class TestUserService {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        ((UserServiceImpl) userService).setUserDao(new UserDaoOracleImpl());

        userService.getUser();
    }
}
