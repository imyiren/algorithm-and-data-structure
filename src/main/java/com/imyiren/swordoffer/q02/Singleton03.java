package com.imyiren.swordoffer.q02;

/**
 * 懒汉式-double-check
 * @author yiren
 */
public class Singleton03 {
    /**
     * volatile禁止new Singleton03()的指令重排序。
     * 以防止指针指向内存->对象初始化的顺序颠倒而造成还未初始化的对象被访问。
      */
    private volatile static Singleton03 INSTANCE;

    private Singleton03() {

    }

    public static Singleton03 getInstance() {
        if (null == INSTANCE) {
            synchronized (Singleton03.class) {
                if (null == INSTANCE) {
                    INSTANCE = new Singleton03();
                }
            }
        }

        return INSTANCE;
    }
}
