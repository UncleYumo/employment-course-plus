package cn.uncleyumo.chapter01.unit05.practise;

/**
 * @author uncle_yumo
 * @fileName Demo03
 * @createDate 2025/4/15 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */
public class Demo03 {
    /*
        请在main方法中通过多态创建对象，随后使用对象，使得程序符合最终运行结果
     */
    public static void main(String[] args) {
        Fu fu = new Zi();
        System.out.println(fu.num);
        fu.method();
        // 向下转型
        Zi zi = (Zi)fu;
        zi.show();
    }
}

class Fu {
    int num = 10;

    public void method(){
        System.out.println("父类的method方法");
    }
}

class Zi extends Fu{
    int num = 20;

    public void method(){
        System.out.println("子类的method方法");
    }

    public void show(){
        System.out.println("子类的show方法");
    }
}