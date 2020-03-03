package com.imyiren.swordoffer.q02;

/**
 * 饿汉式-多线程不安全
 * @author yiren
 */
public class Singleton02 {
    private static Singleton02 INSTANCE;

    private Singleton02() {

    }

    public static Singleton02 getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new Singleton02();
        }

        return INSTANCE;
    }
}
