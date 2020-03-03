package com.imyiren.swordoffer.q02;

/**
 * 懒汉式-静态内部类
 * @author yiren
 */
public class Singleton04 {

    /**
     * 通过静态内部类的方式实现单例模式是线程安全的，
     * 同时静态内部类不会在Singleton类加载时就加载，
     * 而是在调用getInstance()方法时才进行加载，达到了懒加载的效果。
     */
    private static class SingletonHolder {
        private static Singleton04 INSTANCE = new Singleton04();
    }

    private Singleton04() {

    }

    public static Singleton04 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
