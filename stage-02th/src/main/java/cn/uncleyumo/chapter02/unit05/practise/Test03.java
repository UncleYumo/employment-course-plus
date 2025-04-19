package cn.uncleyumo.chapter02.unit05.practise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author uncle_yumo
 * @fileName Test03
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 * 现有一个5星级酒店，按照要求完成代码：
 * ①定义抽象类员工（Employee），具有姓名name，工号id等属性
 * ②接口Service，实现这一接口表示具有vip服务
 * ③再定义厨师Cooker类,服务员Waiter类,经理Manager类，三个员工都有姓名name，工号id的属性,
 *  只有厨师和服务员有vip服务,厨师vip服务加菜,服务员嘘寒问暖,
 * ④定义程序实现功能并测试
 */

public class Test03 {
    public static void main(String[] args) {
        Cooker cooker = new Cooker("厨师", 1001);
        Waiter waiter = new Waiter("服务员", 1002);
        Manager manager = new Manager("经理", 1003);
        cooker.vipService();
        waiter.vipService();
    }
}

interface Service {
    void vipService();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
abstract class Employee {
    private String name;
    private int id;
}

class Cooker extends Employee implements Service {
    private Cooker() {
        super();
    }
    public Cooker(String name, int id) {
        super(name, id);
    }

    @Override
    public void vipService() {
        System.out.println(getName() + "进行了VIP服务：加菜");
    }
}

class Waiter extends Employee implements Service {
    private Waiter() {
         super();
    }
    public Waiter(String name, int id) {
        super(name, id);
    }
    @Override
    public void vipService() {
        System.out.println(getName() + "进行了VIP服务：嘘寒问暖");
    }
}

class Manager extends Employee {
    private Manager() {
        super();
    }
    public Manager(String name, int id) {
        super(name, id);
    }
}