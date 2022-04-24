package com.wugang.mapper;

import com.wugang.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author wugang
 * @date 2022/4/23 21:08
 */
public class UserMapperImpl implements UserMapper {
    //我们的所有操作，在原来都使用sqlSession来执行，现在都使用sqlSessionTemplate；

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {
        User user = new User(99, "999", "123456789");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(user);

        mapper.deleteUser(5);

        return mapper.selectUser();
    }

    public int addUser(User user) {
        return sqlSession.getMapper(UserMapper.class).addUser(user);
    }

    public int deleteUser(int id) {
        return sqlSession.delete("deleteUser", id);
    }
}
