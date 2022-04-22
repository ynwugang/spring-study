import com.wugang.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wugang
 * @date 2022/4/22 14:37
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = context.getBean("user", User.class);

        System.out.println(user.name);
    }
}
