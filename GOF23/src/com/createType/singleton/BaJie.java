package com.createType.singleton;

import javax.swing.*;

/**
 * 饿汉式单例
 */
public class BaJie extends JPanel{
    private static BaJie baJie = new BaJie();
    private BaJie(){
        JLabel jLabel = new JLabel(new ImageIcon("src\\com\\createType\\singleton\\BaJie.jpg"));
        this.add(jLabel);
    }
    public static BaJie getBaJie(){
        return baJie;
    }
}
