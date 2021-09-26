package com.example.sampledemo.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName JavaMethodAreaOOM.java
 * @Description 借助CGLib使得方法区出现内存溢出异常   在JDK 8以后，永久代便完全退出了历史舞台，元空间作为其替代者登场
 * @createTime 2021年09月24日 13:40
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> null);
        enhancer.create();
    }
}
    static class OOMObject {
    }
}
