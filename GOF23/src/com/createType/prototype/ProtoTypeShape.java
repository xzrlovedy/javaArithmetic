package com.createType.prototype;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 用带原型管理器的原型模式来生成包含“圆”和“正方形”等图形的原型，
 * 并计算其面积。分析：本实例中由于存在不同的图形类，例如，“圆”和“正方形”，
 * 它们计算面积的方法不一样，所以需要用一个原型管理器来管理它们
 */
public class ProtoTypeShape {
    public static void main(String[] arg){
        ProtoTypeManager pm = new ProtoTypeManager();
        Shape obj1 = (Circle)pm.getShape("Circle");
        obj1.countArea();
        Shape obj2 = (Square)pm.getShape("Square");
        obj2.countArea();
    }
}

/**
 * 几何形接口，继承Cloneable
 */
interface Shape extends Cloneable
{
    public Object clone();    //拷贝
    public void countArea();    //计算面积
}

/**
 * 圆形的原型
 */
class Circle implements Shape{
    @Override
    public Object clone() {
        Circle circle = null;
        try {
            circle = (Circle)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝圆失败!");
            e.printStackTrace();
        }
        return circle;
    }
    @Override
    public void countArea() {
        int r=0;
        System.out.print("这是一个圆，请输入圆的半径：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该圆的面积="+3.1415*r*r+"\n");
    }
}

/**
 * 正方形的原型
 */
class Square implements Shape
{
    public Object clone()
    {
        Square square=null;
        try
        {
            square=(Square)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            System.out.println("拷贝正方形失败!");
        }
        return square;
    }
    public void countArea()
    {
        int a=0;
        System.out.print("这是一个正方形，请输入它的边长：");
        Scanner input=new Scanner(System.in);
        a=input.nextInt();
        System.out.println("该正方形的面积="+a*a+"\n");
    }
}

class ProtoTypeManager{
    private HashMap<String,Shape> hashMap = new HashMap<String,Shape>();
    public ProtoTypeManager(){
        hashMap.put("Circle",new Circle());
        hashMap.put("Square",new Square());
    }
    public void addShape(String key,Shape obj){
        hashMap.put(key, obj);
    }
    public Shape getShape(String key){
        Shape temp = hashMap.get(key);
        //原型模式
        return (Shape) temp.clone();
    }
}