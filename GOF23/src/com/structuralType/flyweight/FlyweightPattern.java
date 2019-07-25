package com.structuralType.flyweight;

import java.util.HashMap;

/**
 * 享元模式用法
 */
public class FlyweightPattern {
    public static void main(String[] args){
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight f1 = factory.getFlyweight("a");
        Flyweight f2 = factory.getFlyweight("a");
        Flyweight f3 = factory.getFlyweight("a");
        Flyweight f4 = factory.getFlyweight("b");
        Flyweight f5 = factory.getFlyweight("b");

        f1.operation(new UnsharedConcreteFlyweight("第一次调用a "));
        f2.operation(new UnsharedConcreteFlyweight("第二次调用a "));
        f3.operation(new UnsharedConcreteFlyweight("第三次调用a "));
        f4.operation(new UnsharedConcreteFlyweight("第一次调用b "));
        f5.operation(new UnsharedConcreteFlyweight("第二次调用b "));
    }
}
//非享元角色
class UnsharedConcreteFlyweight{

    private String info;

    UnsharedConcreteFlyweight(String info){
        this.info = info;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}
//抽象享元角色
interface Flyweight{
    public void operation(UnsharedConcreteFlyweight state);
}
//具体享元角色
class ConcreteFlyweight implements Flyweight{
    private String key;
    ConcreteFlyweight(String key){
        this.key=key;
        System.out.println("具体享元"+key+"被创建！");
    }
    @Override
    public void operation(UnsharedConcreteFlyweight outState) {
        System.out.print("具体享元"+key+"被调用，");
        System.out.println("非享元信息是:"+outState.getInfo());
    }
}
//享元工厂角色
class FlyweightFactory{
    private HashMap<String,Flyweight> flyweights = new HashMap<String,Flyweight>();
    public Flyweight getFlyweight(String key){
        Flyweight flyweight=(Flyweight)flyweights.get(key);
        if(flyweight!=null){
            System.out.println("具体享元"+key+"已经存在，被成功获取！");
        }else{
            flyweight=new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}
