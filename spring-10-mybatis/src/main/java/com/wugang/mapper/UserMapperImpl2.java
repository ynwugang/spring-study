package com.wugang.mapper;

import com.wugang.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author wugang
 * @date 2022/4/23 21:08
 */
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{

    public List<User> selectUser() {
        return getSqlSession().selectList("selectUser");
    }
}
