package com.wugang.service;

import com.wugang.dao.UserDao;
import com.wugang.dao.UserDaoImpl;

/**
 * @author wugang
 * @date 2022/4/18 20:04
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    /**
     * 利用set实现动态设置userDao的实现类
     *
     * @param userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
