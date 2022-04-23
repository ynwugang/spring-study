package com.wugang.mapper;

import com.wugang.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author wugang
 * @date 2022/4/23 21:08
 */
public class UserMapperImpl implements UserMapper{
    //我们的所有操作，在原来都使用sqlSession来执行，现在都使用sqlSessionTemplate；

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {
//        return sqlSession.getMapper(UserMapper.class).selectUser();
//        return sqlSession.selectList("com.wugang.mapper.UserMapper.selectUser");
        return sqlSession.selectList("selectUser");
    }
}
