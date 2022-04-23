package com.wugang.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author wugang
 * @date 2022/4/23 16:04
 */
public class AfterLog implements AfterReturningAdvice {
    /**
     * @param returnValue ：返回值
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了" + target.getClass().getName() + "的" + method.getName() + "方法，返回值为：" + returnValue);
    }
}
