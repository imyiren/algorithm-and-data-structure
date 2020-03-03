package com.imyiren.swordoffer.q02;


/**
 * 懒汉式
 *
 * @author yiren
 */
public class Singleton01 {
    private static Singleton01 INSTANCE = new Singleton01();

    private Singleton01() {

    }

    public static Singleton01 getInstance() {
        return INSTANCE;
    }
}
