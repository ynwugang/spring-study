package com.wugang.mapper;

import com.wugang.pojo.User;

import java.util.List;

/**
 * @author wugang
 * @date 2022/4/23 20:32
 */
public interface UserMapper {
    List<User> selectUser();
}
