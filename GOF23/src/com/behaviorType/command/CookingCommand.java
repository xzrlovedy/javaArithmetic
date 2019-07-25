package com.behaviorType.command;

/**
 * 用命令模式实现客户去餐馆吃早餐的实例。
 *
 * 分析：客户去餐馆可选择的早餐有肠粉、河粉和馄饨等，
 * 客户可向服务员选择以上早餐中的若干种，服务员将客户的请求交给相关的厨师去做。
 * 这里的点早餐相当于“命令”，服务员相当于“调用者”，厨师相当于“接收者”，所以用命令模式实现比较合适。
 *
 * 首先，定义一个早餐类（Breakfast），它是抽象命令类，有抽象方法 cooking()，说明要做什么；
 *
 * 再定义其子类肠粉类（ChangFen）、馄饨类（HunTun）和河粉类（HeFen），
 * 它们是具体命令类，实现早餐类的 cooking() 方法，但它们不会具体做，而是交给具体的厨师去做；
 *
 * 具体厨师类有肠粉厨师（ChangFenChef）、馄蚀厨师（HunTunChef）和河粉厨师（HeFenChef），
 * 他们是命令的接收者。
 */
public class CookingCommand {
    public static void main(String[] args){
        Breakfast food1=new ChangFen();
        Breakfast food2=new HunTun();
        Waiter fwy=new Waiter();

        fwy.setHeFen(food1);
        fwy.setHunTun(food2);
        fwy.getHeFen();
        fwy.getHunTun();
    }
}
//调用者：服务员
class Waiter{
    private Breakfast changFen,hunTun,heFen;

    public void setChangFen(Breakfast changFen) {
        this.changFen = changFen;
    }
    public void setHunTun(Breakfast hunTun) {
        this.hunTun = hunTun;
    }
    public void setHeFen(Breakfast heFen) {
        this.heFen = heFen;
    }

    public void getChangFen() {
        changFen.cooking();
    }
    public void getHunTun() {
        hunTun.cooking();
    }
    public void getHeFen() {
        heFen.cooking();
    }
}
//抽象命令：早餐
interface Breakfast{
    public abstract void cooking();
}
//具体命令：肠粉
class ChangFen implements Breakfast{
    private ChangFenChef receiver;
    ChangFen(){
        receiver=new ChangFenChef();
    }
    public void cooking(){
        receiver.cooking();
    }
}
//具体命令：馄饨
class HunTun implements Breakfast{
    private HunTunChef receiver;
    HunTun(){
        receiver=new HunTunChef();
    }
    public void cooking(){
        receiver.cooking();
    }
}
//具体命令：河粉
class HeFen implements Breakfast{
    private HeFenChef receiver;
    HeFen(){
        receiver=new HeFenChef();
    }
    public void cooking(){
        receiver.cooking();
    }
}
//接收者：肠粉厨师
class ChangFenChef{
    public void cooking(){
        System.out.println("煮肠粉！");
    }
}
//接收者：馄饨厨师
class HunTunChef{
    public void cooking(){
        System.out.println("煮馄饨！");
    }
}
//接收者：河粉厨师
class HeFenChef{
    public void cooking(){
        System.out.println("炒河粉！");
    }
}
