package com.createType.singleton;

/**
 * 饿汉式单例：该模式的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了。
 */
public class HungrySingleton {
    /*
    饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，
    所以是线程安全的，可以直接用于多线程而不会出现问题。
     */
    private static final HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getHungrySingleton(){
        return hungrySingleton;
    }
}
