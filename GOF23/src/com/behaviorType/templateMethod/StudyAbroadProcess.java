package com.behaviorType.templateMethod;

/**
 * 用模板方法模式实现出国留学手续设计程序。
 *
 * 分析：出国留学手续一般经过以下流程:
 * 索取学校资料，提出入学申请，办理因私出国护照、出境卡和公证，申请签证，
 * 体检、订机票、准备行装，抵达目标学校等，
 * 其中有些业务对各个学校是一样的，但有些业务因学校不同而不同，所以比较适合用模板方法模式来实现。
 *
 * 在本实例中，我们先定义一个出国留学的抽象类 StudyAbroad，里面包含了一个模板方法 TemplateMethod()，
 * 该方法中包含了办理出国留学手续流程中的各个基本方法，其中有些方法的处理由于各国都一样，
 * 所以在抽象类中就可以实现，但有些方法的处理各国是不同的，必须在其具体子类（如美国留学类 StudyInAmerica）中实现。
 * 如果再增加一个国家，只要增加一个子类就可以了
 */
public class StudyAbroadProcess {
    public static void main(String[] args){
        //美国留学
        StudyAbroad s = new StudyInAmerica();
        s.TemplateMethod();
    }
}

//抽象类: 出国留学
abstract class StudyAbroad {
    //模板方法
    public void TemplateMethod() {
        //前两个方法因学校不同，放到子类中实现
        LookingForSchool(); //索取学校资料
        ApplyForEnrol();    //入学申请

        //这三个方法无论去哪个国家的学校，都一样，在抽象类中实现
        ApplyForPassport(); //办理因私出国护照、出境卡和公证
        ApplyForVisa();     //申请签证
        ReadyGoAbroad();    //体检、订机票、准备行装

        //因学校不同，放到子类中实现
        Arriving();         //抵达
    }

    public void ApplyForPassport(){
        System.out.println("三.办理因私出国护照、出境卡和公证！");
    }
    public void ApplyForVisa(){
        System.out.println("四.申请签证！");
    }
    public void ReadyGoAbroad(){
        System.out.println("五.体检、订机票、准备行装！");
    }

    public abstract void LookingForSchool();//索取学校资料
    public abstract void ApplyForEnrol();   //入学申请
    public abstract void Arriving();        //抵达
}

//具体子类: 美国留学
class StudyInAmerica extends StudyAbroad{
    @Override
    public void LookingForSchool() {
        System.out.println("一.索取“美国”学校资料！");
    }
    @Override
    public void ApplyForEnrol() {
        System.out.println("二.入学申请！");
    }
    @Override
    public void Arriving() {
        System.out.println("六.抵达目标学校！");
    }
}
