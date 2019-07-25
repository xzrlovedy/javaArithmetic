package com.createType.singleton;

public class LazySingletonDemo {

    public static void main(String[] arg){
        President zt1 = President.getPresident();
        zt1.getName();
        President zt2 = President.getPresident();
        zt2.getName();
        if(zt1==zt2){
            System.out.println("他们是同一人！");
        }else{
            System.out.println("他们不是同一人！");
        }
    }
}
