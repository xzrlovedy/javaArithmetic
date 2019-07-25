package com.behaviorType.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式的主要角色如下。
 * 抽象主题（Subject）角色：也叫抽象目标类，它提供了一个用于保存观察者对象的聚集类和增加、
 * 删除观察者对象的方法，以及通知所有观察者的抽象方法。
 *
 * 具体主题（Concrete    Subject）角色：也叫具体目标类，它实现抽象目标中的通知方法，
 * 当具体主题的内部状态发生改变时，通知所有注册过的观察者对象。
 *
 * 抽象观察者（Observer）角色：它是一个抽象类或接口，它包含了一个更新自己的抽象方法，
 * 当接到具体主题的更改通知时被调用。
 *
 * 具体观察者（Concrete Observer）角色：实现抽象观察者中定义的抽象方法，
 * 以便在得到目标的更改通知时更新自身的状态。
 */
public class ObserverPattern {
    public static void main(String[] args){
        //一个目标
        Subject subject = new ConcreteSubject();

        //两个观察者
        Observer obs1 = new ConcreteObserver1();
        Observer obs2=new ConcreteObserver2();

        //添加两个观察者
        subject.add(obs1);
        subject.add(obs2);

        subject.notifyObserver();
    }
}

//抽象目标
abstract class Subject{
    protected List<Observer> observers = new ArrayList<Observer>();
    //增加观察者方法
    public void add(Observer observer){
        observers.add(observer);
    }
    //删除观察者方法
    public void remove(Observer observer){
        observers.remove(observer);
    }
    //通知观察者方法
    public abstract void notifyObserver();
}
//具体目标
class ConcreteSubject extends Subject{
    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");
        for(Object obj:observers){
            //观察者响应
            ((Observer)obj).response();
        }
    }
}

//抽象观察者
interface Observer{
    void response();//反应
}
//具体观察者1
class ConcreteObserver1 implements Observer{
    @Override
    public void response() {
        System.out.println("观察者1号做出反应");
    }
}
//具体观察者2
class ConcreteObserver2 implements Observer{
    @Override
    public void response() {
        System.out.println("观察者2号做出反应");
    }
}
