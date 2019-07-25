package com.createType.singleton;

/**
 * 懒汉式单例
 */
public class President {
    private President(){
        System.out.println("产生一个总统！");
    }
    private static volatile President president = null;
    public static synchronized President getPresident(){
        if(president == null){
            president = new President();
        }else {
            System.out.println("已经有总统了！");
        }
        return president;
    }
    public void getName(){
        System.out.println("我是美国总统：特朗普。");
    }
}
