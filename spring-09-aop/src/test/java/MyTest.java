import com.wugang.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wugang
 * @date 2022/4/23 16:21
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //动态代理代理的是接口！
        UserService userService = context.getBean("userService", UserService.class);

        userService.update();
    }
}
