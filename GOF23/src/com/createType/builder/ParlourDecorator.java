
package com.createType.builder;

/**
 * 客户把客厅装修要求告诉项目经理，项目经理指挥装修工人一步步装修
 * 这里客厅是产品，包括墙、电视和沙发等组成部分。
 * 具体装修工人是具体建造者，他们负责装修与墙、电视和沙发的布局。
 * 项目经理是指挥者，他负责指挥装修工人进行装修。
 */
public class ParlourDecorator {
    public static void main(String[] args){
        //抽象工人引用指向具体工人对象
        Decorator decorator = new ConcreteDecorator();
        //项目指挥指引具体工人
        ProjectManager pm = new ProjectManager(decorator);
        //产品
        Product product= pm.decorate();
        product.show();
    }
}

/**
 * 产品角色：客厅
 */
class Product{
    private String wall;    //墙壁
    private String TV;      //电视
    private String sofa;    //沙发

    public void setWall(String wall) {
        this.wall = wall;
    }
    public void setTV(String TV) {
        this.TV = TV;
    }
    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

    //显示客厅产品的细节
    public void show(){
        System.out.println("客厅包含墙壁，电视，沙发！");
    }
}

/**
 * 抽象建造者：装修工人
 */
abstract class Decorator{
    //创建产品对象
    protected Product product = new Product();
    public  abstract void buildWall();
    public  abstract void buildTV();
    public  abstract void buildSofa();

    //返回产品对象
    public Product getProduct() {
        return product;
    }
}

/**
 * 具体建造者：具体装修工人
 */
class ConcreteDecorator  extends Decorator{

    @Override
    public void buildWall() {
        System.out.println("粉刷墙壁");
        product.setWall("粉刷墙壁");
    }
    @Override
    public void buildTV() {
        System.out.println("搬运电视");
        product.setTV("搬运电视");
    }
    @Override
    public void buildSofa() {
        System.out.println("搬运沙发");
        product.setSofa("搬运沙发");
    }
}

/**
 * 指挥者：项目经理
 */
class ProjectManager{
    //抽象建造者：装修工人
    private Decorator decorator;
    //构造器
    public ProjectManager(Decorator decorator){
        this.decorator = decorator;
    }
    //产品构建与组装方法
    public Product decorate(){
        decorator.buildWall();
        decorator.buildTV();
        decorator.buildSofa();
        return decorator.getProduct();
    }
}
