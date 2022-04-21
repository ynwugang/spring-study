package com.wugang.pojo;

/**
 * @author wugang
 * @date 2022/4/21 15:29
 */
public class User {
    private String name;

    public User (String name){
        this.name = name;
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
