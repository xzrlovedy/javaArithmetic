package com.structuralType.proxyPattern;

/**
 * 代理角色
 */
public class Proxy implements Subject {

    //真实角色对象
    private RelSubject relSubject;

    @Override
    public void Request() {
        if (relSubject == null) {
            relSubject = new RelSubject();
        }
        preRequest();
        relSubject.Request();
        postRequest();
    }

    public void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }

    public void postRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }
}