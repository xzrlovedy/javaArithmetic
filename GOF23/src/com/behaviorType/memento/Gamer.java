package com.behaviorType.memento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
    private static String[] FruitsSame = {"香蕉","苹果","橘子","柚子"};

    private int money;
    private List fruits = new ArrayList();
    private Random random = new Random();

    public int getMoney(){
        return money;
    }
    public Gamer(int money){
        this.money = money;
    }
    public void bet(){
        int next = random.nextInt(6)+1;
        if(next==1||next==2){
            money+=100;
            System.out.println("金钱增加了100,当前金钱为："+money);
        }else if(next==3||next==4){
            money/=2;
            System.out.println("金钱减少一半，当前金钱为："+money);
        }else if(next==5){
            String f = getFruits();
            fruits.add(f);
            System.out.println("获得了水果:"+f+"，当前金钱为："+money);
        }else{
            System.out.println("金钱没有发生改变，当前金钱为："+money);
        }
    }
    private String getFruits(){
        String prefix = "";
        if(random.nextBoolean()){
            prefix = "好吃的";
        }
        return prefix+FruitsSame[random.nextInt(FruitsSame.length)];
    }
    public Memento createMemento(){
        Memento m = new Memento(money);
        Iterator it = fruits.iterator();
        while(it.hasNext()){
            String fruit = (String)it.next();
            if(fruit.startsWith("好吃的")){
                m.addFruits(fruit);
            }
        }
        return m;
    }
    public void restoreMemento(Memento memento){
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }
    public String toString(){
        return "Money: "+money+",Fruits: "+fruits;
    }
}
