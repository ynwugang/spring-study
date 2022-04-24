package com.wugang.mapper;

import com.wugang.pojo.User;

import java.util.List;

/**
 * @author wugang
 * @date 2022/4/23 20:32
 */
public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    List<User> selectUser();

    /**
     * 新增一个用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据id删除一个用户
     * @param id
     * @return
     */
    int deleteUser(int id);
}
