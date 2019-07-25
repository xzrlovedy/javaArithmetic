package com.structuralType.composite;

import java.util.ArrayList;

public class CompositePattern {
    public static void main(String[] args){
        Component c1 = new Composite();
        Component c2 = new Composite();
        Component leaf1 = new Leaf("1");
        Component leaf2 = new Leaf("2");
        Component leaf3 = new Leaf("3");

        c1.add(leaf1);
        c1.add(c2);//c1包含c2,c2缺少leaf1
        c2.add(leaf2);
        c2.add(leaf3);

        c1.operation();
        c2.operation();
    }
}

//抽象构件
interface Component{
    public void add(Component c);
    public void remove(Component c);
    public Component getChild(int i);
    public void operation();
}
//树叶构件
class Leaf implements Component{
    private String name;
    public Leaf(String name){
        this.name=name;
    }
    @Override
    public void add(Component c) {
    }
    @Override
    public void remove(Component c) {
    }
    @Override
    public Component getChild(int i) {
        return null;
    }
    @Override
    public void operation() {
        System.out.println("树叶"+name+":被访问");
    }
}
//树枝构件
class Composite implements Component{
    private ArrayList<Component> children = new ArrayList<Component>();

    @Override
    public void add(Component c) {
        children.add(c);
    }
    @Override
    public void remove(Component c) {
        children.remove(c);
    }
    @Override
    public Component getChild(int i) {
        return children.get(i);
    }
    @Override
    public void operation() {
        for(Object obj:children){
            ((Component)obj).operation();
        }
    }
}