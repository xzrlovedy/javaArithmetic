package com.structuralType.proxyPattern;

/**
 * 真实主题
 */
public class RelSubject implements Subject{
    @Override
    public void Request() {
        System.out.println("访问真实角色方法...");
    }
}
