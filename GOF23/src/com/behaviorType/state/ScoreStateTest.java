package com.behaviorType.state;

/**
 * 用“状态模式”设计一个学生成绩的状态转换程序。
 *
 * 分析：本实例包含了“不及格”“中等”和“优秀” 3 种状态，当学生的分数小于 60 分时为“不及格”状态，
 * 当分数大于等于 60 分且小于 90 分时为“中等”状态，当分数大于等于 90 分时为“优秀”状态，
 * 我们用状态模式来实现这个程序。
 *
 * 首先，定义一个抽象状态类（AbstractState），其中包含了环境属性、状态名属性和当前分数属性，
 * 以及加减分方法 addScore(intx) 和检查当前状态的抽象方法 checkState()；
 *
 * 然后，定义“不及格”状态类 LowState、“中等”状态类 MiddleState 和“优秀”状态类 HighState，
 * 它们是具体状态类，实现 checkState() 方法，负责检査自己的状态，并根据情况转换；
 *
 * 最后，定义环境类（ScoreContext），其中包含了当前状态对象和加减分的方法 add(int score)，
 * 客户类通过该方法来改变成绩状态。
 */
public class ScoreStateTest {
    public static void main(String[] args){
        ScoreContext account=new ScoreContext();
        System.out.println("学生成绩状态测试：");

        account.add(30);
        account.add(40);
        account.add(25);
        account.add(-15);
        account.add(-25);
    }
}

//环境类
class ScoreContext{

    private AbstractState state;
    ScoreContext(){
        state = new LowState(this);
    }

    public void setState(AbstractState state){
        this.state=state;
    }
    public AbstractState getState(){
        return state;
    }
    public void add(int score){
        state.addScore(score);
    }
}
//抽象状态类
abstract class AbstractState{
    protected ScoreContext sc;//环境
    protected String stateName;//状态名
    protected int score;//分数

    public abstract void checkState();
    public void addScore(int x){
        score+=x;
        System.out.print("加上："+x+"分，\t当前分数："+score );
        checkState();
        System.out.println("分，\t当前状态："+sc.getState().stateName);
    }

}
//具体状态类：不及格
class LowState extends AbstractState{

    public LowState(ScoreContext scoreContext){
        sc = scoreContext;
        stateName="不及格";
        score=0;
    }

    public LowState(AbstractState s)
    {
        sc=s.sc;
        stateName="不及格";
        score=s.score;
    }
    @Override
    public void checkState() {
        if(score>=90){
            sc.setState(new HighState(this));
        }else if(score>=60){
            sc.setState(new MiddleState(this));
        }
    }
}
//具体状态类：中等
class MiddleState extends AbstractState{

    public MiddleState(AbstractState s){
        sc=s.sc;
        stateName="中等";
        score=s.score;
    }

    @Override
    public void checkState() {
        if(score<60){
            sc.setState(new LowState(this));
        }else if(score>=90){
            sc.setState(new HighState(this));
        }
    }
}
//具体状态类：优秀
class HighState extends AbstractState{
    public HighState(AbstractState s)
    {
        sc=s.sc;
        stateName="优秀";
        score=s.score;
    }
    @Override
    public void checkState() {
        if(score<60){
            sc.setState(new LowState(this));
        }else if(score<90){
            sc.setState(new MiddleState(this));
        }
    }
}
