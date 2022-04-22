package com.wugang.config;

import com.wugang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author wugang
 * @date 2022/4/22 16:47
 */
//这个也会被Spring容器托管，注册到容器中，因为它本身就是一个@Component
//@Configuration代表这是一个配置类，就和我们之前看的Beans.xml一样
@Configuration
@ComponentScan("com.wugang.pojo")
@Import(Config2.class)
public class Config {

    //注册一个bean，就相当于我们之前写的一个bean标签，
    //这个方法的名字就是相当于bean标签中的id属性
    //这个方法的返回值就相当于bean标签中的class属性
    @Bean
    public User getUser(){
        return new User();  //就是返回要注入到bean的对象！
    }
}
