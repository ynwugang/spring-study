import com.wugang.pojo.Student;
import com.wugang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wugang
 * @date 2022/4/21 17:35
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");

        System.out.println(student.toString());

        /*
        Student{
            name='张三',
            address=Address{address='林荫大道108号'},
            book=[三国演义, 水浒传, 西游记, 红楼梦],
            hobbies=[听歌, 看电影, 打篮球],
            card={身份证=123456789456321598,
                  银行卡=12345678945652159875},
            games=[LOL, DNF],
            wife='null',
            info={password=男, url=男, driver=201612085, username=男}}
         */
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
        User user = context.getBean("user2", User.class);

        System.out.println(user);
    }
}
