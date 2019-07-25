package com.behaviorType.memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private int money;
    private ArrayList fruits;

    //窄接口，访问部分信息
    public int getMoney(){
        return money;
    }
    //宽接口，构造器，本包内访问
    Memento(int money){
        this.money = money;
        fruits = new ArrayList();
    }
    List getFruits(){
        return (List)fruits.clone();
    }
    void addFruits(String fruit){
        fruits.add(fruit);
    }
}
