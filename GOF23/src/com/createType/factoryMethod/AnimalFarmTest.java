package com.createType.factoryMethod;

import javax.swing.*;
import java.awt.*;

/**
 * 有很多种类的畜牧场，如养马场用于养马，养牛场用于养牛，所以该实例用工厂方法模式比较适合。
 * 对养马场和养牛场等具体工厂类，只要定义一个生成动物的方法 newAnimal() 即可。
 * 由于要显示马类和牛类等具体产品类的图像，所以它们的构造函数中用到了 JPanel、JLabd 和 ImageIcon 等组件，
 * 并定义一个 show() 方法来显示它们。
 */
public class AnimalFarmTest {
    public static void main(String[] args){
        //Animal animal = new Horse();
        //animal.show();
        AnimalFarm af1 = new HorseFarm();
        af1.newAnimal();
        AnimalFarm af2 = new CattleFarm();
        af2.newAnimal();
    }
}

/**
 * 抽象产品：动物类
 */
interface Animal{
    public void show();
}

/**
 * 具体产品：马类
 */
class Horse implements Animal{
    JScrollPane sp;
    JFrame jf=new JFrame("工厂方法模式测试");
    public Horse(){
        Container contentPane=jf.getContentPane();
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(1,1));
        p1.setBorder(BorderFactory.createTitledBorder("动物：马"));
        sp=new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel l1=new JLabel(new ImageIcon("src\\com\\createType\\factoryMethod\\A_Horse.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        //用户点击窗口关闭
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void show(){
        jf.setVisible(true);
    }
}

/**
 * 具体产品：牛类
 */
class Cattle implements Animal{
    JScrollPane sp;
    JFrame jf=new JFrame("工厂方法模式测试");
    public Cattle(){
        Container contentPane=jf.getContentPane();
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(1,1));
        p1.setBorder(BorderFactory.createTitledBorder("动物：牛"));
        sp=new JScrollPane(p1);
        contentPane.add(sp,BorderLayout.CENTER);
        JLabel l1=new JLabel(new ImageIcon("src\\com\\createType\\factoryMethod\\A_Cattle.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void show(){
        jf.setVisible(true);
    }
}

/**
 * 抽象工厂：畜牧场
 */
interface AnimalFarm{
    public Animal newAnimal();
}

/**
 * 具体工厂：养马场
 */
class HorseFarm implements AnimalFarm{
    @Override
    public Animal newAnimal() {
        System.out.println("新马出生！");
        Animal horse = new Horse();
        horse.show();
        return horse;
    }
}

/**
 * 具体工厂：养牛场
 */
class CattleFarm implements AnimalFarm{
    @Override
    public Animal newAnimal() {
        System.out.println("新牛出生！");
        Animal cattle = new Cattle();
        cattle.show();
        return cattle;
    }
}