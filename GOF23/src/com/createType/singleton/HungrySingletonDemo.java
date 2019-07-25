package com.createType.singleton;

import javax.swing.*;
import java.awt.*;

public class HungrySingletonDemo {
    public static void main(String[] arg){
        JFrame jf=new JFrame("饿汉单例模式测试");
        jf.setLayout(new GridLayout(1,2));
        Container contentPane=jf.getContentPane();
        BaJie obj1=BaJie.getBaJie();
        contentPane.add(obj1);
        BaJie obj2=BaJie.getBaJie();
        contentPane.add(obj2);
        if(obj1==obj2){
            System.out.println("他们是同一人！");
        }else{
            System.out.println("他们不是同一人！");
        }
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
