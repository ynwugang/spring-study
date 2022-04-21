package com.wugang.pojo;

/**
 * @author wugang
 * @date 2022/4/21 15:29
 */
public class UserT {
    private String name;

    public UserT(){
        System.out.println("UserT被创建");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("name=" + name);
    }
}
