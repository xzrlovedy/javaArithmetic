package com.behaviorType.strategy;

/**
 * 在现实生活中常常遇到实现某种目标存在多种策略可供选择的情况，
 *
 * 例如，出行旅游可以乘坐飞机、乘坐火车、骑自行车或自己开私家车等，
 * 超市促销可以釆用打折、送商品、送积分等方法。
 */
public class StrategyPattern {
    public static void main(String[] args){
        Travel travel = new Travel();

        Strategy bus = new Bus();
        travel.setStrategy(bus);
        travel.strategyMethod();

        Strategy plane = new Plane();
        travel.setStrategy(plane);
        travel.strategyMethod();
    }
}

//抽象策略：出行方式选择
interface Strategy{
    //出行方式
    public void go();
}
//具体策略：坐飞机
class Plane implements Strategy{
    @Override
    public void go() {
        System.out.println("坐飞机旅游！");
    }
}
//具体策略：坐巴士
class Bus implements Strategy{
    @Override
    public void go() {
        System.out.println("坐巴士旅游！");
    }
}
//具体策略：开始私家车
class Car implements Strategy{
    @Override
    public void go() {
        System.out.println("开私家车旅游！");
    }
}
//环境类
class Travel{
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void strategyMethod(){
        strategy.go();
    }
}
