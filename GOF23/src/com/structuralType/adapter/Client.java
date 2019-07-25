package com.structuralType.adapter;

/**
 * 客户端
 */
public class Client {
    public void test(Target target){
        target.handleReq();
    }
    public static void main(String[] arg){
        Client client = new Client();//客户端
        Adaptee adaptee = new Adaptee();//被适配的对象
        Target target = new Adapter();//多态，适配器
        client.test(target);
    }
}
