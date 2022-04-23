import com.wugang.mapper.UserMapper;
import com.wugang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author wugang
 * @date 2022/4/23 20:34
 */
public class MyTest {
    @Test
    public void test() throws IOException {
//        //加载配置文件
//        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//        //通过SqlSessionFactoryBuilder().build(配置文件流)创建SqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //通过创建SqlSessionFactory对象的openSession()方法获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //sqlSession.getMapper(持久层接口.class)获取持久层对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        //调用持久层对象中的方法，获取查询结果
//        List<User> userList = userMapper.selectUser();
//
//        for (User user : userList) {
//            System.out.println(user);
//        }
//        //关闭sqlSession连接
//        sqlSession.close();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);

        List<User> userList = userMapper.selectUser();

        for (User user : userList) {
            System.out.println(user);
        }
    }
}
