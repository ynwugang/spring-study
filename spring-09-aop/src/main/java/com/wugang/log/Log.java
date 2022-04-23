package com.wugang.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author wugang
 * @date 2022/4/23 16:00
 */
public class Log implements MethodBeforeAdvice {

    /**
     *
     * @param method ：要执行的目标对象的方法
     * @param args ：参数
     * @param target ：目标对象
     * @throws Throwable
     */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "的" + method.getName() + "被执行了");
    }
}
