package com.wugang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author wugang
 * @date 2022/4/22 14:35
 */
//等价于 <bean id="user" class="com.wugang.pojo.User"/>
//@Component 组件
@Component
@Scope("singleton")
public class User {

    public String name;

    //相当于 <property name="name" value="张三123456789"/>
    @Value("张三123456789")
    public void setName(String name) {
        this.name = name;
    }
}
