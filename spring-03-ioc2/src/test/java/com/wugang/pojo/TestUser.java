package com.wugang.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wugang
 * @date 2022/4/21 15:33
 */
public class TestUser {
    public static void main(String[] args) {
        //在配置文件加载的时候，容器中管理的对象就已经初始化了
        //Sprig容器创建的时候会将xml文件中的所有bean创建，使用的时候直接取就可以，并且不论取多少次，都是同一个bean
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        User user = (User) context.getBean("user");
//        UserT user = (UserT) context.getBean("user2");
        UserT user = (UserT) context.getBean("u5");

        user.show();
    }
}
