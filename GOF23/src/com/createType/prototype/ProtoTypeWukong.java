package com.createType.prototype;

import javax.swing.*;
import java.awt.*;

/**
 * 原型（Prototype）模式的定义如下：用一个已经创建的实例作为原型，
 * 通过复制该原型对象来创建一个和原型相同或相似的新对象。在这里，原型实例指定了要创建的对象的种类。
 * 原型模式包含以下主要角色。
        抽象原型类：规定了具体原型对象必须实现的接口。
        具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
        访问类：使用具体原型类中的 clone() 方法来复制新的对象。
 */
public class ProtoTypeWukong {
    public static void main(String[] arg){
        JFrame jFrame = new JFrame("原型模式，拷贝孙悟空");
        jFrame.setLayout(new GridLayout(1,2));
        Container contentPane = jFrame.getContentPane();
        SunWukong obj1 = new SunWukong();
        contentPane.add(obj1);
        //孙悟空拔下猴毛轻轻一吹就变出很多孙悟空，这实际上是用到了原型模式。
        // 这里的孙悟空类 SunWukong 是具体原型类，而 Java 中的 Cloneable 接口是抽象原型类。
        SunWukong obj2 = (SunWukong)obj1.clone();
        contentPane.add(obj2);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class SunWukong extends JPanel implements Cloneable{
    public SunWukong(){
        JLabel jLabel = new JLabel(new ImageIcon("src\\com\\createType\\prototype\\Wukong.jpg"));
        this.add(jLabel);
    }
    /*
    克隆方法
     */
    public Object clone(){
        SunWukong wukong = null;
        try {
            wukong = (SunWukong)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝悟空失败！");
            e.printStackTrace();
        }
        return wukong;
    }
}
