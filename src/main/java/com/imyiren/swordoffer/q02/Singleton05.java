package com.imyiren.swordoffer.q02;

/**
 * 枚举实现：在effective java中说道，最佳的单例实现模式就是枚举模式。
 * 利用枚举的特性，让JVM来帮我们保证线程安全和单一实例的问题。除此之外，写法还特别简单。
 * @author yiren
 */
public enum Singleton05 {
    INSTANCE;

    public void doSomething() {
        System.out.println("doSomething");
    }

    public Singleton05 getInstance() {
        return INSTANCE;
    }
}
