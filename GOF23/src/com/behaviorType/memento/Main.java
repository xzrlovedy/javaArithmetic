package com.behaviorType.memento;

public class Main {
    public static void main(String[] args){
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();

        for(int i=0;i<10;i++){
            System.out.println("当前状态："+i);
            System.out.println("当前金额："+gamer.getMoney());
            gamer.bet();

            if(gamer.getMoney() < memento.getMoney()/2){
                System.out.println("金钱过少，恢复到以前的状态：");
                gamer.restoreMemento(memento);
                System.out.println("此时状态为："+gamer);
            }else if(gamer.getMoney() > memento.getMoney()){
                System.out.println("金钱增多，保存当前状态：");
                memento = gamer.createMemento();
                System.out.println("此时状态为："+gamer);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
