package com.structuralType.decorator;

import javax.swing.*;
import java.awt.*;

/**
 * 在《迪迦奥特曼》中，角色迪迦的原身是红蓝两色，
 * 但变身时，会变成纯蓝色速度型，还可以变为纯红色力量型。
 *
 * 这些都可用装饰模式来实现，原身有 setImage(String t) 方法决定其显示方式，
 * 而其变身“纯蓝色速度型”和“纯红色力量型”可以用 setChanger() 方法来改变其外观，
 * 原身与变身后的效果用 display() 方法来显示
 */
public class DiJia {
    public static void main(String[] args){
        Altman a1 = new Original();
        Altman a2 = new Blue(a1);
        Altman a3 = new Red(a1);
        a1.display();
        a2.display();
        a3.display();
    }
}

//抽象构件角色：奥特曼
interface  Altman{
    public void display();
}
//具体构件角色：原身
class Original extends JFrame implements Altman{

    private String s="diJia.jpg";

    public Original(){
        super("迪迦的三种形态");
    }
    public void setImage(String s){
        this.s = s;
    }
    @Override
    public void display() {
        this.setLayout(new FlowLayout());
        JLabel l1=new JLabel(new ImageIcon("src\\com\\structuralType\\decorator\\"+s));
        this.add(l1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
//抽象装饰角色：变形
class Changer implements Altman{
    Altman a;
    public Changer(Altman a){
        this.a = a;
    }
    @Override
    public void display() {
        a.display();
    }
}
//具体装饰角色：蓝色
class Blue extends Changer{
    public Blue(Altman m){
        super(m);
    }
    public void display(){
        setChanger();
        super.display();
    }
    public void setChanger(){
        ((Original) super.a).setImage("blue.jpg");
    }
}
//具体装饰角色：红色
class Red extends Changer{
    public Red(Altman m){
        super(m);
    }
    public void display(){
        setChanger();
        super.display();
    }
    public void setChanger(){
        ((Original) super.a).setImage("red.jpg");
    }
}
