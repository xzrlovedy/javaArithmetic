package com.createType.abstractFactory;

import javax.swing.*;
import java.awt.*;

/**
 * 农场中除了像畜牧场一样可以养动物，还可以培养植物，如养马、养牛、种菜、种水果等，
 * 所以本实例比前面介绍的畜牧场类复杂，必须用抽象工厂模式来实现。
 */
public class FarmTest {
    public static void main(String[] args){
        Sfarm s1 = new Sfarm();
        s1.newAnimal(new Horse());
        s1.newPlant(new Vegetables());
    }
}

/**
 * 抽象产品：动物类
 */
interface Animal{
    public void show();
}
//具体产品：马类
class Horse implements Animal{
    JScrollPane sp;
    JFrame jf=new JFrame("抽象工厂模式测试");
    public Horse(){
        Container contentPane=jf.getContentPane();
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(1,1));
        p1.setBorder(BorderFactory.createTitledBorder("动物：马"));
        sp=new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel l1=new JLabel(new ImageIcon("src\\com\\createType\\abstractFactory\\A_Horse.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
    }
    public void show(){
        jf.setVisible(true);
    }
}
//具体产品：牛类
class Cattle implements Animal{
    JScrollPane sp;
    JFrame jf=new JFrame("抽象工厂模式测试");
    public Cattle(){
        Container contentPane=jf.getContentPane();
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(1,1));
        p1.setBorder(BorderFactory.createTitledBorder("动物：牛"));
        sp=new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel l1=new JLabel(new ImageIcon("src\\com\\createType\\abstractFactory\\A_Cattle.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
    }
    public void show(){
        jf.setVisible(true);
    }
}

/**
 * 抽象产品：植物类
 */
interface Plant{
    public void show();
}
//具体产品：水果类
class Fruitage implements Plant{
    JScrollPane sp;
    JFrame jf=new JFrame("抽象工厂模式测试");
    public Fruitage(){
        Container contentPane=jf.getContentPane();
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(1,1));
        p1.setBorder(BorderFactory.createTitledBorder("植物：水果"));
        sp=new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel l1=new JLabel(new ImageIcon("src\\com\\createType\\abstractFactory\\P_Fruitage.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
    }
    public void show(){
        jf.setVisible(true);
    }
}
//具体产品：蔬菜类
class Vegetables implements Plant{
    JScrollPane sp;
    JFrame jf=new JFrame("抽象工厂模式测试");
    public Vegetables(){
        Container contentPane=jf.getContentPane();
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(1,1));
        p1.setBorder(BorderFactory.createTitledBorder("植物：蔬菜"));
        sp=new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel l1=new JLabel(new ImageIcon("src\\com\\createType\\abstractFactory\\P_Vegetables.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
    }
    public void show(){
        jf.setVisible(true);
    }
}

/**
 * 抽象工厂：农场类
 */
interface Farm{
    public Animal newAnimal(Animal animal);
    public Plant newPlant(Plant plant);
}
//具体工厂：农场类
class Sfarm implements Farm{
    public Animal newAnimal(Animal animal){
        animal.show();
        return animal;
    }
    public Plant newPlant(Plant plant){
        plant.show();
        return plant;
    }
}