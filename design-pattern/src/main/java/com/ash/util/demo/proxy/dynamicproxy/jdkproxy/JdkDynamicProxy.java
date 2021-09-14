package com.ash.util.demo.proxy.dynamicproxy.jdkproxy;

import com.ash.util.demo.proxy.dynamicproxy.Buy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName JdkDynamicProxy.java
 * @Description JDK 动态代码实现
 * @createTime 2021年03月08日 18:13:00
 */
public class JdkDynamicProxy implements InvocationHandler {

    private Buy target;

    public Buy getInstance(Buy target) {
        this.target = target;
        Class<?> targetClass = target.getClass();
        return (Buy) Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        this.before();
        Object invoke = method.invoke(this.target, args);
        this.after();

        return invoke;
    }

    public void after(){
        System.out.println("用盒子包装MAC");
    }

    public void before(){
        System.out.println("代理去到美国...");
    }

}
