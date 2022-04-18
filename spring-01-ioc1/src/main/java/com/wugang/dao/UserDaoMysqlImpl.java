package com.wugang.dao;

/**
 * @author wugang
 * @date 2022/4/18 20:09
 */
public class UserDaoMysqlImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("Msql获取用户数据");
    }
}
