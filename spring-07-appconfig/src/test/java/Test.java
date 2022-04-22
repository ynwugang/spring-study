import com.wugang.config.Config;
import com.wugang.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wugang
 * @date 2022/4/22 16:49
 */
public class Test {
    public static void main(String[] args) {
        //如果完全使用了配置类方式去做，我们就只能通过 AnnotationConfig 上下文来获取容器，通过配置类的class对象加载！
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        User user = (User) context.getBean("getUser");

        System.out.println(user.getName());
    }
}
