package com.structuralType.adapter;

/**
 * 适配器
 * 将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void handleReq() {
        super.request();
    }
}
